package com.project.view;

import java.util.Scanner;

public class AfterLoginRegularMember {

	public void afterLoginRegularMember() {
		
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		
		System.out.println("    일반 회원 로그인 후 화면");
		System.out.println("========================");
		System.out.println("1. 로그아웃");
		System.out.println("2. 센터 정보");
		System.out.println("3. 수강 신청 안내 페이지");
		System.out.println("4. 수강 신청");
		System.out.println("5. 마이페이지");
		System.out.println("6. 셔틀");
		System.out.println("========================");
		System.out.println("번호 입력: ");
		
		num = scan.nextInt();
	}
}
