package com.project.admin;

import java.util.Scanner;

/**
 * 관리자 화면을 출력하는 기능을 하는 클래스 입니다.
 * @author eugene
 *
 */
public class AdminView {

	/**
	 * 관리자 로그인 후의 화면을 출력하는 메소드 입니다.
	 */
	public static void printAdminMain() {
		System.out.println("===========================");
		System.out.println("\t\t\t관리자 모드");
		System.out.println("===========================");
		System.out.println("   1.  일반 회원 관리\t\t5.  공지사항");
		System.out.println("   2.  강사 회원 관리\t\t6.  내정보");
		System.out.println("   3.  강좌 관리\t\t\t7.  로그아웃");
		System.out.println("   4.  강의실 관리");
		System.out.println("------------------------------------");
		System.out.print("번호 입력: ");
		
		
	}
	
	/**
	 * 화면을 잠시 멈추는 메소드 입니다.
	 * @param scan
	 */
	public static void printPendingMessage(Scanner scan) {
		
		System.out.println("계속하려면 엔터를 입력해 주세요.");
		scan.nextLine();
		
	}
	
	/**
	 * 입력받은 값이 유효성 검사를 통과하지 못했을 때 메시지를 출력하는 메소드 입니다.
	 * @param scan
	 */
	public static void printInvalidInputMessage(Scanner scan) {
		
		System.out.println("입력이 올바르지 않습니다.");
		System.out.println("다시 입력해 주세요.");
		
		AdminView.printPendingMessage(scan);
	}
	
}
