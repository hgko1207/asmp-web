package com.ysc.after.school.domain.param;

import com.ysc.after.school.domain.CommonEnum.NoticeSearchType;

import lombok.Data;

/**
 * 검색 조건 공통 클래스
 * 
 * @author hgko
 *
 */
@Data
public class SearchParam {
	
	private NoticeSearchType noticeSearchType;

	private String searchType;
	
	private String content;
	
	/** 학년 */
	private int grade;
	
	/** 반 */
	private int classType;
	
	/** 이름 */
	private String name;
}
