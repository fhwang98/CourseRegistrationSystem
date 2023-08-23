package com.project.user.mypage;

import java.util.Scanner;

import com.project.user.data.DataMember;

public class MyPageMain {
	
	public static void main(String[] args) {
		mypage(null);
	}

	public static void mypage(DataMember m) {
		
		MyPageData.load();
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			
			MyPageView.mainMenu();
			
			String sel = scan.nextLine();
			
			String id = "otqapf7199"; // TODO 로그인 연동
			
			if (sel.equals("0")) {
				loop = false; // 루프 빠져나가고 myPageData.save 후에 메인화면으로 이동
			} else if (sel.equals("1")) {
				MyPageService.memCheck();
			} else if (sel.equals("2")) {
				MyPageService.memChange();
			} else if (sel.equals("3")) {
				MyPageService.classCheck();
			} else if (sel.equals("4")) {
				MyPageService.classDelete();
			} else if (sel.equals("5")) {
				MyPageService.logout();
			} else if (sel.equals("6")) {
				MyPageService.memDelete();
				loop = false;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			
		}
				
		MyPageData.save();
		
		// TODO ???.???(); 메인화면으로 이동 
	}
	
}
