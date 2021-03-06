package com.ysc.after.school.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ysc.after.school.domain.db.Lesson;
import com.ysc.after.school.domain.db.QLesson;
import com.ysc.after.school.domain.db.User;
import com.ysc.after.school.domain.db.User.UserRole;
import com.ysc.after.school.domain.param.SearchParam;
import com.ysc.after.school.domain.param.SearchParam.LessonSearchType;
import com.ysc.after.school.repository.LessonRepository;
import com.ysc.after.school.service.LessonService;

/**
 * 학생 관리 서비스
 * 
 * @author hgko
 *
 */
@Service
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Lesson> getList() {
		return lessonRepository.findAll();
	}

	@Override
	public boolean regist(Lesson domain) {
		if (isNew(domain)) {
			return lessonRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Lesson domain) {
		if (!isNew(domain)) {
			return lessonRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Lesson domain) {
		lessonRepository.delete(domain);
		return true;
	}

	private boolean isNew(Lesson domain) {
		return !lessonRepository.exists(domain.getId());
	}

	@Override
	public List<Lesson> getList(SearchParam param) {
		LessonSearchType searchType = param.getLessonSearchType();
		String content = param.getContent();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		User user = (User) authentication.getPrincipal();
		
		if (searchType == LessonSearchType.전체) {
			if (user.getRole() == UserRole.ADMIN) {
				return getList();
			} else {
				return lessonRepository.findByUserId(user.getId());
			}
		} else {
			if (!content.isEmpty()) {
				JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
				QLesson lesson = QLesson.lesson;
				
				Predicate predicate = null;
				
				if (searchType == LessonSearchType.과목) {
					predicate = lesson.subject.name.contains(content);
				} else if (searchType == LessonSearchType.강좌명) {
					predicate = lesson.name.contains(content);
				} else if (searchType == LessonSearchType.강사명) {
					predicate = lesson.teacher.name.contains(content);
				} else if (searchType == LessonSearchType.상태) {
					predicate = lesson.status.contains(content);
				}
				
				if (user.getRole() == UserRole.ADMIN) {
					return queryFactory.selectFrom(lesson)
							.where(predicate)
							.fetch().stream().collect(Collectors.toList());
				} else {
					return queryFactory.selectFrom(lesson)
							.where(lesson.userId.eq(user.getId()).and(predicate))
							.fetch().stream().collect(Collectors.toList());
				}
			}
			
			return null;
		}
	}

	@Override
	public Lesson get(int id) {
		return lessonRepository.findOne(id);
	}

	@Override
	public List<Lesson> findByTeacherId(int teacherId) {
		return lessonRepository.findByTeacherId(teacherId);
	}

	@Override
	public boolean delete(List<Lesson> lessons) {
		lessonRepository.deleteInBatch(lessons);
		return true;
	}

}
