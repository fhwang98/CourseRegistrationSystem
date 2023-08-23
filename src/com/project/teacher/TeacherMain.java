package com.project.teacher;

import java.util.Scanner;

import com.project.teacher.Teacher;

public class TeacherMain {

	public static void LoginTeacher() {
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;

		System.out.println("         강사회원 로그인 후 화면");
		System.out.println("—-------------------------------------");
		System.out.println("1. 로그아웃");
		System.out.println("2. 마이페이지");
		System.out.println("3. 강좌관리");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");
		
		input = scan.nextInt();
		
		if (input == 1) {
			
			//로그인 한 정보 null로 전환 후 초기 메인 화면 
            
        } else if (input == 2) {
        	
        	Teacher.mypage();
        	
        } else if(input == 3) {
        	
        	Management.courseManagement();
            
        } else {
        	System.out.println("잘못된 입력입니다.");
        }
	}
}
