package com.project.notice;

import java.util.Scanner;

import com.project.user.data.UserDbms;

public class NoticeMain {
	public static Scanner scan;

	static {
		NoticeMain.scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		noticeMainPage();
	}

	public static void noticeMainPage() {

		// 공지사항 데이터 로드
		NoticeData.load();
		
		// 회원 데이터 로드
		UserDbms u = new UserDbms();
		
		// 공지사항 초기 화면 출력
//		NoticeView.printNoticeLabel();
		
		// 기능
		NoticeService.showNoticeList();
	}
}
