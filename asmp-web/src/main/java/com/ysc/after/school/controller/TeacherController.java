package com.ysc.after.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysc.after.school.domain.CommonEnum.Subject;
import com.ysc.after.school.domain.db.Teacher;
import com.ysc.after.school.domain.param.SearchParam;
import com.ysc.after.school.service.TeacherService;

/**
 * 강사 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	/**
	 * 강사 리스트
	 * @param model
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model) {
		
	}
	
	/**
	 * 강사 검색
	 * @param model
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Teacher>> search(@RequestBody SearchParam param) {
		System.out.println("강사 검색 조건 => " + param);
		return new ResponseEntity<>(teacherService.getList(param), HttpStatus.OK);
	}
	
	/**
	 * 강사 등록 화면
	 * @param model
	 */
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public void regist(Model model) {
		model.addAttribute("subjects", Subject.values());
	}
	
	/**
	 * 강사 등록
	 * @param model
	 */
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> regist(Teacher teacher) {
		teacher.setContractDate(teacher.getContractYear() + "-" + teacher.getContractMonth() + "-" + teacher.getDay());
		if (teacherService.regist(teacher)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 강사 수정 화면
	 * @param model
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, int id) {
		Teacher teacher = teacherService.get(id);
		String[] contractDate = teacher.getContractDate().split("-");
		teacher.setContractYear(contractDate[0]);
		teacher.setContractMonth(contractDate[1]);
		teacher.setContractDay(contractDate[2]);
		model.addAttribute("teacher", teacher);
		model.addAttribute("subjects", Subject.values());
	}
	
	/**
	 * 강사 수정
	 * @param model
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity<?> update(Teacher teacher) {
		teacher.setContractDate(teacher.getContractYear() + "-" + teacher.getContractMonth() + "-" + teacher.getDay());
		if (teacherService.update(teacher)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 강사 상세정보
	 * @param model
	 */
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(Model model, int id) {
	}
}
