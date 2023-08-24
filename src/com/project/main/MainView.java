package com.project.main;

import java.util.Scanner;

import com.project.admin.notice.NoticeMain;
import com.project.busstop.BusStopMain;
import com.project.centerinfo.CenterInfo;
import com.project.courseinfo.CourseInfo;
import com.project.user.login.LoginMain;
import com.project.user.signup.SignUpMain;

public class MainView {
	
	public static void MainScreen() {
		
		Scanner scan = new Scanner(System.in);
		
		String input = "";
		
		mainView();
		
		boolean loop = true;
		
		while (loop) {

			input = scan.nextLine();
			
			if (input.equals("1")) {
				LoginMain lMain = new LoginMain();
		        lMain.LoginProcess();
				mainView();
			} else if (input.equals("2")) {
				SignUpMain.main(null);
				mainView();
			} else if (input.equals("3")) {
				CourseInfo.courseInfo();
				mainView();
			} else if (input.equals("4")) {
				CenterInfo.centerInfo();
				mainView();
			} else if (input.equals("5")) {
				BusStopMain.busStopMain();
				mainView();
			} else if (input.equals("6")) {
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
		System.out.println();
	}
}
