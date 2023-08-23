package com.project.user.login;

import java.util.Scanner;

import com.project.auth.Auth;
import com.project.auth.AuthDbms;
import com.project.user.data.DataAdmin;
import com.project.user.data.DataMember;
import com.project.user.data.DataTeacher;

public class LoginChoice {
	static AuthDbms authDbms = new AuthDbms();
	
	public static void login(LoginMain main) {
		
		Auth auth = new Auth();
		
		 
		int num = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("       로그인      ");
		System.out.println("======================");
		System.out.println();
		System.out.println("로그인 할 회원 유형을 선택하세요.");
		System.out.println("0. 뒤로가기");
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
		
		if(num == 0) {
			//TODO 로그인 메인페이지로 이동
			LoginMain lMain = new LoginMain();
			lMain.LoginProcess();
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
				auth.setAllCode(t.getTeacherCode());
				auth.setChoiceCode("2");
				auth.setId(t.getId());
				auth.setName(t.getName());
				
				main.getLoginTList().add(t);
			}	
		} else if (num == 3) {
			DataAdmin a = LoginAdmin.login();
			if(a !=  null) {
				auth.setAllCode(a.getAdminCode());
				auth.setChoiceCode("3");
				auth.setId(a.getId());
				auth.setName(a.getName());
				
				main.getLoginAList().add(a);
			}
		}
		
		if( auth.getAllCode() != null && !"".equals(auth.getAllCode()) ) {
			authDbms.insertAuth(auth);
		}

	}
}
