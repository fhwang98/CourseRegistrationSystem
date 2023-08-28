package com.project.admin.course;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.courseinfo.CourseList;

/**
 * 관리자의 강좌 관련 기능을 컨트롤하는 클래스 입니다.
 * @author eugene
 *
 */
public class AdminCourseMain {

	/**
	 * 관리자의 강좌 관련 메뉴를 컨트롤하는 메소드입니다.
	 */
	public static void controlCourse() {
		/*
			뒤로가기
			전체강좌 조회
			강좌 분류별 조회
			강좌 검색
		
		
		*/
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) { // 강좌 관리 루프
		
			
			AdminCourseView.printCourseHead();
			AdminCourseView.printCourseMenu();
			String input = scan.nextLine();
			int sel = AdminUtil.isValidSel(input, 0, 2);
			if (sel == 0) {
				loop = false;
			} else if ( sel == 1) {
				//전체 강좌 조회
				CourseList.courseList();
			} else if ( sel == 2) {
				//승인 대기 강좌
				PendingCourseMain.controlPendingCourse();
			}
			
		}
	}
	
}
