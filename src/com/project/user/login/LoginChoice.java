package com.project.user.login;

import java.util.Scanner;

import com.project.auth.Auth;
import com.project.user.data.DataAdmin;
import com.project.user.data.DataMember;
import com.project.user.data.DataTeacher;

public class LoginChoice {
	public static void login(LoginMain main) {
		
		Auth auth = new Auth();
		
		 
		int num = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("       로그인      ");
		System.out.println("======================");
		System.out.println();
		System.out.println("로그인 할 회원 유형을 선택하세요.");
		System.out.println("1. 일반회원");
		System.out.println("2. 강사");
		System.out.println("3. 관리자");
		System.out.println();
		System.out.println("======================");
		System.out.print("번호를 입력하세요: ");

		num = scan.nextInt();
		System.out.println();

		while (num > 3) {
			System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
			System.out.println();
			System.out.print("번호를 입력하세요: ");
			num = scan.nextInt();
		}
		if (num == 1) {
			DataMember m = LoginMember.login();
			if(m !=  null) {
				auth.setAllCode(m.getMemberCode());
				auth.setChoiceCode("1");
				auth.setId(m.getId());
				auth.setName(m.getName());
				
				main.getLoginMList().add(m);
			}
		} else if (num == 2) {
			DataTeacher t = LoginTeacher.login();
			if(t !=  null) {
				main.getLoginTList().add(t);
			}	
		} else {
			DataAdmin a = LoginAdmin.login();
			if(a !=  null) {
				main.getLoginAList().add(a);
			}
		}

	}
}
