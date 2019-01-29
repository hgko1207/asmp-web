package com.ysc.after.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysc.after.school.domain.db.Lesson;
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

}