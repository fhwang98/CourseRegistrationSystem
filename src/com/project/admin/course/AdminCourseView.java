package com.project.admin.course;

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
	public static void printCourseHead() {
		System.out.println("=============================================");
		System.out.println("\t\t강좌 관리");
		System.out.println("=============================================");
	}
	
	public static void printCourseMenu() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 전체 강좌 조회");
		System.out.println("2. 강좌 분류별 조회");
		System.out.println("3. 강좌 검색");
		System.out.println("4. 승인 대기 강좌");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력: ");
	}
}
