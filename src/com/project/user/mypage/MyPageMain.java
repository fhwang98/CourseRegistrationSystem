package com.project.user.mypage;

import java.util.Scanner;

import com.project.authentication.Authentication;
import com.project.user.data.DataMember;
/**
 * 
 *	회원 마이페이지 메인 클래스입니다.	
 * 	@author 이연섭	
 *
 */
public class MyPageMain {
	/**
	 * 
	 * 마이페이지 첫 화면의 동작을 위한 메서드입니다.
	 * 
	 */
	public static void mypage() {
		
		
		MyPageData.load();
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while (loop) {
			
			MyPageView.mainMenu();

			String loginCode = Authentication.loginUserCode; 

			String sel = scan.nextLine();
			
			
			if (sel.equals("0")) {
				loop = false; 
			} else if (sel.equals("1")) {
				MyPageService.memCheck(loginCode);
			} else if (sel.equals("2")) {
				MyPageService.memChange(loginCode);
			} else if (sel.equals("3")) {
				MyPageService.classCheck(loginCode);
			} else if (sel.equals("4")) {
				MyPageService.classDelete(loginCode);
			} else if (sel.equals("5")) {
				MyPageService.logout();
				loop = false;
			} else if (sel.equals("6")) {
				MyPageService.memDelete(loginCode);
				loop = false;
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			
		}
		
		
	}
	
}
