package com.project.main;

import java.util.Scanner;

import com.project.admin.notice.NoticeMain;
import com.project.centerinfo.CenterInfo;
import com.project.courseinfo.CourseInfo;
import com.project.user.login.LoginMain;
import com.project.user.signup.SignUpMain;

public class MainView {
	
	public void MainScreen() {
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;
		
		mainView();
		
		boolean loop = true;
		
		while (loop) {

			input = scan.nextInt();
			
			if (input == 1) {
				LoginMain lMain = new LoginMain();
		        lMain.LoginProcess();
				mainView();
			} else if (input == 2) {
				SignUpMain.main(null);
				mainView();
			} else if (input == 3) {
				CourseInfo.lectureInfo();
				mainView();
			} else if (input == 4) {
				CenterInfo.centerInfo();
				mainView();
			} else if (input == 5) {
				CourseInfo.lectureInfo();
				mainView();
			} else if (input == 6) {
				NoticeMain.controlNoticeMain();
				mainView();
			} else {
				System.out.println("잘못된 입력입니다");
				System.out.print("재입력: ");
			}
			
		}
		
	}

	public static void mainView() {
		System.out.println("         초기메인화면");
		System.out.println("—-------------------------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 수강신청 안내 페이지");
		System.out.println("4. 센터 정보");
		System.out.println("5. 셔틀");
		System.out.println("6. 공지사항");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");
	}
}
