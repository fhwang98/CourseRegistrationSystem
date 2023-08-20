package com.project.admin.user;

import com.project.admin.user.test.User;

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
	
	static void printMovePage() {
		System.out.println("-------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	public static void printUserData(User u) {
		System.out.println("회원 번호 : " + u.getUserNum());
		System.out.println("아이디 : " + u.getId());
		System.out.println("이름 : " + u.getUserNum());
		System.out.println("전화번호 : " + u.getPhone());
		System.out.println("생년월일 : " + u.getBday());
//		System.out.println("할인 : " +u.);
	}
}
