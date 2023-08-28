package com.project.main;

import java.util.Scanner;

import com.project.busstop.BusStopMain;
import com.project.centerinfo.CenterInfo;
import com.project.courseinfo.CourseInfo;
import com.project.notice.NoticeMain;
import com.project.user.login.LoginMain;
import com.project.user.signup.SignUpMain;

/**
 * 초기메인화면을 담당하는 클래스입니다.
 *
 */
public class MainView {
	
	/**
	 * 초기메인화면에서 선택하는 선택지에 따라 달라지는 화면을 연결시켜주는 메소드입니다.
	 */
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
				NoticeMain.noticeMainPage();
				mainView();
			} else {
				System.out.println("잘못된 입력입니다");
				System.out.print("재입력: ");
			}
			
		}
		
	}

	/**
	 * 초기메인화면을 출력하는 메소드입니다.
	 */
	public static void mainView() {
		System.out.println("              초기메인화면");
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
