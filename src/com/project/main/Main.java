package com.project.main;

import com.project.course.CourseHistoryData;
import com.project.courseinfo.CourseData;
import com.project.user.data.UserDbms;

/**
 * 메인 클래스
 * 
 * 프로젝트 메인 역할을 하는 클래스 입니다.
 */
public class Main {
	
	/**
	 * 메인 메소드 입니다. 프로그램의 시작을 담당합니다.
	 * @param args 메인 인자입니다.
	 */
	public static void main(String[] args) {
		
		
		
		// 모든 사용자 정보 로드 - 일반, 강사, 관리자
        UserDbms userDbms = new UserDbms();

        // 전체 수강 내역 로드
        CourseHistoryData.load();

        // 전체 강좌 목록 로드
        CourseData.allCourseMap();
        CourseData.allCourseList();
		
		
		//초기화면
		MainView.MainScreen();

	}
}
