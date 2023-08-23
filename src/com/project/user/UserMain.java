package com.project.user;

import java.util.Scanner;

public class UserMain {

	public void LoginGeneralMember() {
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;

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
		
		input = scan.nextInt();
		
		if (input == 1) {
			//연결시켜
        } else if (input == 2) {
           //연결시켜
        } else if (input == 3) {
        	//연결시켜
        } else if (input == 4) {
        	//연결시켜
        } else if (input == 5) {
        	//연결시켜
        } else if (input == 6) {
        	//연결시켜
        } else {
            System.out.println("잘못된 입력입니다");
        }
	}
}
