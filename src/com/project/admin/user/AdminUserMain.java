package com.project.admin.user;

import java.util.Scanner;

public class AdminUserMain {
	public static void main(String[] args) {
		// 관리자 로그인 후 보이는 메인화면에서 1. 일반 회원 관리를 눌렀을 때 나오는 페이지.

		Scanner scan = new Scanner(System.in);

		// 기본 출력을 view에서 만들고 여기서 호출
		AdminUserView.printAdminUserMain();

		while (true) {
			// 번호 입력부터 여기서 시작
			String sel = scan.nextLine();

			if (sel.equals("0")) { // 이전 페이지인 관리자 로그인 후 화면으로 돌아간다.
				break;
			} else if (sel.equals("1")) { // 전체 회원 조회 페이지로 이동
				AdminUserService.showUserList();
				
			} else if (sel.equals("2")) { // 회원 검색 페이지로 이동
				AdminUserService.searchUser();
				
			} else { // invalid
				AdminUserView.printInvalidInput();
				
			}
		}

		System.out.println("AdminUserMain Out");
	}
}
