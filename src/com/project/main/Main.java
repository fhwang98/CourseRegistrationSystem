package com.project.main;

import java.util.ArrayList;

import com.project.admin.AdminMain;
import com.project.teacher.Teacher;
import com.project.user.data.DataTeacher;
import com.project.user.login.LoginMain;

public class Main {
	public static void main(String[] args) {

		//초기화면
		MainView lMain = new MainView();
        lMain.MainScreen();

		// 로그인
//        LoginMain abc = new LoginMain();
//        abc.getLoginTList();

//		//강사 마이페이지
		// Teacher.mypage();

		// 강사 로그인 데이터 가져오기
//		LoginMain lista = new LoginMain();
//		lista.LoginProcess();
//		lista.getLoginTList();
//
//		// 현재 로그인 한 강사 코드
//		System.out.println(lista.getLoginTList().get(0).getTeacherCode());
		
//		 LoginMain main = new LoginMain();
//         main.LoginProcess();
//         main.getLoginTList();
//         for(int i =0; i<main.getLoginTList().size(); i++) {
//            System.out.println(main.getLoginTList().get(i).toString());
//         }
//		
		

	}
}
