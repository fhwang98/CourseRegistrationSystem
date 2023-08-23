package com.project.admin.course;

import java.util.Scanner;

import com.project.admin.AdminUtil;

public class AdminCourseMain {

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
			int sel = AdminUtil.isValidSel(input, 0, 4);
			if (sel == 0) {
				loop = false;
			} else if ( sel == 1) {
				//전체 강좌 조회
			} else if ( sel == 2) {
				//강좌 분류별 조회
			} else if ( sel == 3) {
				//강좌 검색
				//TODO 구현해야함
				AdminCourseService.searchCourse();
			} else if ( sel == 4) {
				//승인 대기 강좌
				System.out.println("승인대기강좌");
				PendingCourseMain.controlPendingCourse();
			}
			
		}
	}
	
}
