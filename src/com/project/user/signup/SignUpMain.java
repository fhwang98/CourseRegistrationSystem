package com.project.user.signup;

import java.util.Scanner;

public class SignUpMain {
	public static void main(String[] args) {

		int num = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("       회원가입      ");
		System.out.println("======================");
		System.out.println();
		System.out.println("가입할 회원 유형을 선택하세요.");
		System.out.println("1. 일반회원");
		System.out.println("2. 강사");
		System.out.println("3. 관리자");
		System.out.println();
		System.out.println("======================");
		System.out.print("번호를 입력하세요: ");

		num = scan.nextInt();
		
		
		while(num > 3) {
			System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
			System.out.println();
			System.out.print("번호를 입력하세요: ");
			num = scan.nextInt();
		}		
		if (num == 1) {
			SignUpMember.addMember();
		} else if(num==2) {
			SignUpTeacher.addTeacher();
		}else {
			SignUpAdmin.addAdmin();
		}
		
	
		
		

		

	}
}