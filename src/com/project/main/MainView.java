package com.project.main;

import java.util.Scanner;

public class MainView {

	public void MainScreen() {
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;
		
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
