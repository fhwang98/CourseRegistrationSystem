package com.project.user.login;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.user.data.UserDbms;

public class FindData {

	public static ArrayList<String> findId() {
		
		String name = "";
		String birth = "";

		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println("      아이디 찾기      ");
		System.out.println("======================");
		System.out.println();
		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.print("생년월일: ");
		birth = scan.nextLine();
		System.out.println("======================");
		
		
		ArrayList<String> idList = UserDbms.getIdFind(name, birth);
		
		return idList;
		
		
	}

	public static ArrayList<String> findPw() {
		
		String name = "";
		String tel = "";
		String newPassword = "";
		String checkNewPassword = "";
		

		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println("      비밀번호 재설정      ");
		System.out.println("======================");
		System.out.println();
		System.out.print("이름: ");
		name = scan.nextLine();
		System.out.print("전화번호: ");
		tel = scan.nextLine();
		System.out.println("======================");
		
		String temp = tel.replaceAll("-", "");
		ArrayList<String> pwList = UserDbms.getPwFind(name, temp);
			
			if(pwList.size()>0) {
				System.out.print("새로운 비밀번호를 입력해주세요: ");
				newPassword = scan.nextLine();
				
				while (newPassword.equals(pwList.get(0))) {
					System.out.println("기존 비밀번호는 사용할 수 없습니다.");
					System.out.print("새로운 비밀번호를 입력해주세요: ");
					newPassword = scan.nextLine();
					
					while (!newPasswordCheck(newPassword)) {
						System.out.println("유효하지 않은 비밀번호입니다. 다시 입력해주세요.");
						System.out.print("새로운 비밀번호를 입력해주세요: ");
						newPassword = scan.nextLine();
					}
					
					
				}
				
				while(!newPassword.equals(pwList.get(0))) {
					System.out.print("새 비밀번호 확인: ");
					checkNewPassword = scan.nextLine();
					while(!checkNewPassword.equals(newPassword)) {
						System.out.println("입력받은 비밀번호가 일치하지 않습니다.");
						System.out.print("새 비밀번호 확인: ");
						checkNewPassword = scan.nextLine();
						
					}
					break;
				}
				
				
				
				System.out.println("재설정 완료.");
				
				
				
			}else {
				System.out.print("정보가 일치하지 않습니다.");
			}
		
		
		return pwList;
		
	}
	
	
	private static boolean newPasswordCheck(String newPassword) {
			
		//길이 제한 10-16자
		 if (newPassword.length() < 10 || newPassword.length() > 16) {
	            return false;
	        }
		 
		 	boolean hasUppercase = false;
	        boolean hasLowercase = false;
	        boolean hasDigit = false;
	        
	        //영어 대문자 소문자 숫자만 포함되는가 
	        for (char p : newPassword.toCharArray()) {
	            if (Character.isUpperCase(p)) {
	                hasUppercase = true;
	            } else if (Character.isLowerCase(p)) {
	                hasLowercase = true;
	            } else if (Character.isDigit(p)) {
	                hasDigit = true;
	            } else {
	                return false; // 다른 문자가 포함되어 있다면 유효하지 않은 비밀번호
	            }
	        }
	        
	        return hasUppercase && hasLowercase && hasDigit;
	}
	

}
