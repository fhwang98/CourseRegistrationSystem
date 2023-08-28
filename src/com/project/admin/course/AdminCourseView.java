package com.project.admin.course;

/**
 * 관리자의 강좌 관리 화면을 출력하는 클래스입니다.
 * @author eugene
 *
 */
public class AdminCourseView {

	/*
	=================
        강좌 관리
	=================
	뒤로가기
	전체강좌 조회
	강좌 분류별 조회
	강좌 검색
	승인 대기 강좌
	—---------------------------
	번호 입력: 

	
	*/
	/**
	 * 관리자의 강좌 관리 제목을 출력하는 메소드 입니다.
	 */
	public static void printCourseHead() {
		System.out.println("===========================");
		System.out.println("\t\t\t강좌 관리");
		System.out.println("===========================");
	}
	
	/**
	 * 관리자의 강좌 관리 메뉴를 출력하는 메소드입니다.
	 */
	public static void printCourseMenu() {
		System.out.println("   0.  뒤로가기");
		System.out.println("   1.  강좌 목록 조회");
		System.out.println("   2.  승인 대기 강좌");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력: ");
	}
}
