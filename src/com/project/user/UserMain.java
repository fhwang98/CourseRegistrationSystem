package com.project.user;

import java.util.Scanner;

import com.project.busstop.BusStopMain;
import com.project.centerinfo.CenterInfo;
import com.project.course.CourseApplication;
import com.project.courseinfo.CourseInfo;
import com.project.main.MainView;
import com.project.user.mypage.MyPageMain;

public class UserMain {

	
	public void LoginGeneralMember() {
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;

		userMainView();
		
		boolean loop = true;
		
		while (loop) {
			
			input = scan.nextInt();
			
			if (input == 1) {
				loop = false;
			} else if (input == 2) {
				CenterInfo.centerInfo();
				userMainView();
			} else if (input == 3) {
				CourseInfo.lectureInfo();
				userMainView();
			} else if (input == 4) {
				CourseApplication.courseApplicationment();
				userMainView();
			} else if (input == 5) {
				MyPageMain.mypage();
				userMainView();
			} else if (input == 6) {
				BusStopMain.main(null);
				userMainView();
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.print("재입력: ");
			}
			
		}
		
		
	}

	public static void userMainView() {
		System.out.println("         일반회원 로그인 후 화면");
		System.out.println("—-------------------------------------");
		System.out.println("1. 로그아웃");
		System.out.println("2. 센터정보");
		System.out.println("3. 수강신청 안내 페이지");
		System.out.println("4. 수강신청");
		System.out.println("5. 마이페이지");
		System.out.println("6. 셔틀");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");
	}
}
