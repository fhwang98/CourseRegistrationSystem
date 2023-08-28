package com.project.teacher;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.teacher.Teacher;
import com.project.user.data.DataTeacher;

/**
 * 강사회원의 로그인 후 화면을 담당하는 클래스입니다.
 *
 */
public class TeacherMain {

	/**
	 * 강사회원의 로그인 후 화면을 출력하고 선택지에 따라 다른 화면을 연결시켜주는 메소드입니다.
	 */
	public static void LoginTeacher(DataTeacher t) {

		
		Scanner scan = new Scanner(System.in);
		
		String input = "";

		System.out.println("        강사회원 로그인상태");
		System.out.println("—---------------------------");
		System.out.println("1. 로그아웃");
		System.out.println("2. 마이페이지");
		System.out.println("3. 강좌관리");
		System.out.println("—---------------------------");
		System.out.print("번호 입력 : ");
		
		input = scan.nextLine();
		
		if (input.equals("1")) {
			
			//로그인 한 정보 null로 전환 후 초기 메인 화면 
            
        } else if (input.equals("2")) {
        	
        	Teacher.mypage();
        	
        } else if(input.equals("3")) {
        	
        	Management.courseManagement();
            
        } else {
        	System.out.println("잘못된 입력입니다.");
        }
	}
}
