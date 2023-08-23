package com.project.user.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.project.user.data.DataAdmin;
import com.project.user.data.DataMember;
import com.project.user.data.DataTeacher;

public class LoginMain {
	
	private ArrayList<DataMember> loginMList = new ArrayList<DataMember>();
	private ArrayList<DataTeacher> loginTList = new ArrayList<DataTeacher>();
	private ArrayList<DataAdmin> loginAList = new ArrayList<DataAdmin>();
	
	public ArrayList<DataMember> getLoginMList() {
		return loginMList;
	}
	
	public ArrayList<DataTeacher> getLoginTList() {
		return loginTList;
	}
	
	public ArrayList<DataAdmin> getLoginAList() {
		return loginAList;
	}
	

	public void LoginProcess() {
			
		int num = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("       로그인      ");
		System.out.println("======================");
		System.out.println();
		System.out.println("0. 뒤로가기");
		System.out.println("1. 로그인");
		System.out.println("2. 아이디 찾기");
		System.out.println("3. 비밀번호 재설정");
		System.out.println();
		System.out.println("======================");
		System.out.print("번호를 입력하세요: ");

		num = scan.nextInt();
		System.out.println();
		
		while(num > 3) {
			System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
			System.out.println();
			System.out.print("번호를 입력하세요: ");
			num = scan.nextInt();
		}
		//
		if(num == 0) {
			System.out.println("메인화면으로 돌아갑니다.");
			System.out.println();
		} else if (num == 1) {
			LoginChoice.login(this);
		}else if(num==2) {
			//idList와 회원정보가 일치할시 아이디를 찾아준다.
			ArrayList<String> idList = FindData.findId();
			if(idList.size()>0) {
				System.out.print("회원님의 아이디는 ");
				System.out.print(Arrays.toString(idList.toArray()));
				System.out.print("입니다.");
			}else {
				System.out.print("정보가 일치하지 않습니다.");
			}
		}else {
			
			FindData.resetPw();
		}
		
	}
		
}
