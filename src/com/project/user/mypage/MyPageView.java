package com.project.user.mypage;

import java.util.Scanner;
/**
 * 
 * 회원 마이페이지의 문구를 출력하는 클래스입니다.
 * @author 이연섭
 *
 */
public class MyPageView {
	/**
	 * 
	 * 마이페이지의 각 기능의 제목을 출력하기 위한 메서드입니다.
	 * @param title 제목을 출력하기 위한 인자입니다.
	 */
	public static void subTitle(String title) {
		
		System.out.println();
		System.out.println("===========================");
		System.out.println("        " + title);
		System.out.println("===========================");
	}
	/**
	 * 
	 * 프로그램을 잠시 정지시키기 위한 메서드입니다.
	 * 엔터를 입력받으면 다시 동작합니다.
	 * 
	 */
	public static void pause() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("마이페이지로 돌아가려면 엔터를 눌러주세요.");
		scan.nextLine();
	}
	/**
	 * 회원 마이페이지 메인화면의 문구를 출력하기 위한 메서드입니다.
	 */
	public static void mainMenu() {

		System.out.println("===========================");
		System.out.println("          마이페이지");
		System.out.println("===========================");
		System.out.println("0. 메인화면\n");
		System.out.println("1. 내 정보 조회\n");
		System.out.println("2. 내 정보 수정\n");
		System.out.println("3. 수강 내역 조회\n");
		System.out.println("4. 수강 신청 취소\n");
		System.out.println("5. 로그아웃\n");
		System.out.println("6. 회원탈퇴\n");
		System.out.println("===========================");
		System.out.print("선택할 서비스의 번호를 입력해주세요: ");
		
	}
	/**
	 * 회원 마이페이지 내 정보 수정 메뉴의 문구를 출력하기 위한 메서드입니다.
	 */
	public static void changeList() {
		
		System.out.println();
		System.out.println("0. 마이페이지로 돌아가기\n");
		System.out.println("1. 이름\n");
		System.out.println("2. 전화번호\n");
		System.out.println("3. 할인여부\n");
		System.out.println("4. 은행 및 계좌번호\n");
		System.out.println("5. 생년월일\n");
	}
	/**
	 * 할인 여부 수정 시의 출력 메소드입니다.
	 */
	public static void changeDiscount() {
		System.out.println("===========================");
		System.out.println("         할인여부 수정");
		System.out.println("===========================");
		System.out.println();
		System.out.println("0. 마이페이지로 돌아가기\n");
		System.out.println("1. 국가유공자\n");
		System.out.println("2. 국민기초생활보장수급자\n");
		System.out.println("3. 다자녀가구\n");
		System.out.println("4. 해당없음\n");
	}
	/**
	 * 수정 완료시에 출력할 메서드입니다.
	 */
	public static void changeComplete() {
		System.out.println();
		System.out.println("수정이 완료되었습니다.");
	}
	
}
