package com.project.user;

import java.util.Scanner;

import com.project.busstop.BusStopMain;
import com.project.centerinfo.CenterInfo;
import com.project.course.CourseApplication;
import com.project.courseinfo.CourseInfo;
import com.project.main.MainView;
import com.project.user.mypage.MyPageMain;

public class UserMain {

	
	public static void LoginGeneralMember() {
		
		Scanner scan = new Scanner(System.in);
		
		String input = "";

		userMainView();
		
		boolean loop = true;
		
		while (loop) {
			
			input = scan.nextLine();
			
			if (input.equals("1")) {
				loop = false;
			} else if (input.equals("2")) {
				CenterInfo.centerInfo();
				userMainView();
			} else if (input.equals("3")) {
				CourseInfo.lectureInfo();
				userMainView();
			} else if (input.equals("4")) {
				CourseApplication.courseApplicationment();
				userMainView();
			} else if (input.equals("5")) {
				MyPageMain.mypage(null); // null 추가
				userMainView();
			} else if (input.equals("6")) {
				BusStopMain.busStopMain();
				userMainView();
			} else if (input.equals("7")) {
				//추가해야함

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
		System.out.println("7. 공지사항");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");
	}
}
