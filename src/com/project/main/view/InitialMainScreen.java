package com.project.main.view;

import java.util.Scanner;

public class InitialMainScreen {

	public void initialMainScreen () {
		
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		
		System.out.println("       초기 메인 화면");
		System.out.println("========================");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 수강 신청 안내 페이지");
		System.out.println("4. 센터 정보");
		System.out.println("5. 셔틀");
		System.out.println("========================");
		System.out.println("번호 입력: ");
		
		num = scan.nextInt();
		
	}
		
	
}
