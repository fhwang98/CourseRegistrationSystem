package com.project.main;

import com.project.course.CourseHistoryData;
import com.project.courseinfo.CourseData;
import com.project.user.data.UserDbms;

public class Main {
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
