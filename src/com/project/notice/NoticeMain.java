package com.project.notice;

import java.util.Scanner;

import com.project.user.data.UserDbms;

/**
 * 초기 메인화면에서 공지사항 기능을 불러오는 메인클래스 입니다.
 * @author 황은하
 *
 */
public class NoticeMain {
	public static Scanner scan;

	static {
		NoticeMain.scan = new Scanner(System.in);
	}

	/**
	 * 공지사항 기능이 실행되는 메인 메소드입니다.
	 */
	public static void noticeMainPage() {

		// 공지사항 데이터 로드
		NoticeData.load(); // 반복 실행 시 데이터 중복 저장되는 문제 발생
		
		// 회원 데이터 로드
		UserDbms u = new UserDbms();
		
		// 기능
		NoticeService.showNoticeList();
	}
}
