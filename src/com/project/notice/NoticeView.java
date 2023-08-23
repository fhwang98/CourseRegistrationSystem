package com.project.notice;

public class NoticeView {

	public static void printNoticeLabel() {
		System.out.println("=====================================");
		System.out.println("               공지사항");
		System.out.println("=====================================");
	}

	public static void printLine() {
		System.out.println("-------------------------------------");
	}

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
