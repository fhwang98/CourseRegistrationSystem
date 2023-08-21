package com.project.admin;

public class AdminView {
/*
	================================
	           관리자 로그인 화면
================================
1. 일반 회원 관리		5.  공지사항
2. 강사 회원 관리		6.  내정보
3. 강좌 관리			7.  로그아웃
4. 강의실 관리
—------------------------------------------------------
번호 입력: 
	*/
	public static void printAdminMain() {
		System.out.println("=====================================");
		System.out.println("\t\t\t\t관리자 모드");
		System.out.println("=====================================");
		System.out.println("\t1.\t일반 회원 관리\t\t5.\t공지사항");
		System.out.println("\t2.\t강사 회원 관리\t\t6.\t내정보");
		System.out.println("\t3.\t강좌 관리\t\t\t7.\t로그아웃");
		System.out.println("\t4.\t강의실 관리");
		System.out.println("--------------------------------------------------");
		System.out.println("번호 입력:");
	}
	
	public static void printPendingMessage() {
		
		System.out.println("계속하려면 엔터를 입력해 주세요.");
		
	}
	
	public static void printInvalidInputMessage() {
		
		System.out.println("입력이 올바르지 않습니다.");
		System.out.println("다시 입력해 주세요.");
		
	}
	
}
