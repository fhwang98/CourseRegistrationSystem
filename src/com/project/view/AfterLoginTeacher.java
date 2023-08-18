package com.project.view;

import java.util.Scanner;

public class AfterLoginTeacher {
	
	public void afterLoginTeacher() {
		
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		
		System.out.println("   강사 회원 로그인 후 화면");
		System.out.println("========================");
		System.out.println("1. 로그아웃");
		System.out.println("2. 마이페이지");
		System.out.println("3. 강좌 관리");
		System.out.println("========================");
		System.out.println("번호 입력: ");
		
		num = scan.nextInt();
	}
}
