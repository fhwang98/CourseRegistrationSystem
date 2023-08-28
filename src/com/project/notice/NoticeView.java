package com.project.notice;

/**
 * 공지사항의 출력 부분을 담당하는 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class NoticeView {

	/**
	 * 공지사항 메인 라벨을 출력하는 메소드입니다.
	 */
	public static void printNoticeLabel() {
		System.out.println("=====================================");
		System.out.println("               공지사항");
		System.out.println("=====================================");
	}

	/**
	 * 한 줄을 출력하는 메소드입니다.
	 */
	public static void printLine() {
		System.out.println("-------------------------------------");
	}

	/**
	 * 페이지 이동부를 출력하는 메소드입니다.
	 */
	public static void printMovePage() {
		System.out.println("-------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.println("3. 공지사항 확인");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

}
