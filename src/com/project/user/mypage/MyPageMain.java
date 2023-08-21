package com.project.user.mypage;

import java.util.Scanner;

public class MyPageMain {

	public static void main(String[] args) {
		
		MyPageData.load();
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			
			MyPageView.mainMenu();
			
			String sel = scan.nextLine();
			
			String id = "otqapf7199";
			
			if (sel.equals("0")) {
				
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
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				loop = false;
			}
			
		}
		
		System.out.println("프로그램 종료");
		
		MyPageData.save();
	}
	
}
