package com.project.admin.user;

public class AdminUserView {

	public static void printAdminUserMain() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println("              일반 회원 관리");
		System.out.println("=====================================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 전체 회원 조회");
		System.out.println("2. 회원 검색");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	public static void printInvalidInput() {
		System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
	}

	public static void printMovePage() {
//		System.out.println("-------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

}
