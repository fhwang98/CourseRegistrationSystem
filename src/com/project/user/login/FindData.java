package com.project.user.login;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		//이름과 생년월일이 일치할시 idList를 반환한다.
		ArrayList<String> idList = UserDbms.getIdFind(name, birth);
		
		return idList;
		
		
	}

	public static HashMap<String, String> resetPw() {
		
		String name = "";
		String tel = "";
		String newPassword = "";
		String checkNewPassword = "";
		HashMap<String, String> pwMap = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("======================");
			System.out.println("      비밀번호 재설정     ");
			System.out.println("======================");
			System.out.println();
			System.out.print("이름: ");
			name = scan.nextLine();
			System.out.print("전화번호: ");
			tel = scan.nextLine();
			System.out.println("======================");
			
			String temp = tel.replaceAll("-", "");
			pwMap = UserDbms.getPwFind(name, temp);
			int step = 0;
			//입력된 값과 고유 코드와 일치하지 않을시
			if(!("".equals(pwMap.get("code")) || pwMap.get("code") == null   )) {
				
				// 비밀번호 변경 로직 start
				while(true) {
					if(step < 2) {
						System.out.print("새로운 비밀번호를 입력해주세요: ");
						newPassword = scan.nextLine();
						System.out.println();
					}
					
					// 1. 기존의 pw와 새로 입력된 pw가 같을시
					if( newPassword.equals(pwMap.get("password")) ) {
						System.out.println("기존 비밀번호는 사용할 수 없습니다.");
						continue;
					} else {
						step = 1;
					}
					
					// 2. 새로 입력한 pw가 유효성 검사와 맞지 않을시 
					if(!newPasswordCheck(newPassword)) {
						System.out.println("유효하지 않은 비밀번호입니다. 다시 입력해주세요.");
						continue;
					}else {
						step = 2;
					}
					
					if(step>=2) {
						System.out.print("새 비밀번호 확인: ");
						checkNewPassword = scan.nextLine();
					}
					
					// 3. 새 비밀번호와 확인용으로 입력한 새 비밀번호가 일치하지 않을시
					if( !checkNewPassword.equals(newPassword) ) {
						System.out.println("입력받은 비밀번호가 일치하지 않습니다.");
						continue;
					} else {
						step = 3;
					}
					
					if(step == 3) {
						break;
					}
					
				}
				
			}else {
				System.out.println("정보가 일치하지 않습니다.");
			}
			
			//위 단계를 모두 수행시
			if(step == 3) {
				System.out.println("재설정 완료.");
				pwMap.put("chPw", newPassword);
				// 비밀번호 데이터 변경
				UserDbms.setModifyPw(pwMap);
				break;
			} else {
				System.out.print("비밀번호 재설정 하시겠습니까? (Y/N): ");
				
				if("N".equals(scan.nextLine())) {
					//로그인 메인페이지로 이동
					LoginMain lMain = new LoginMain();
					lMain.LoginProcess();
					break;
				}
			}
			
		}
		
		return pwMap;
	}
	
	//새 비밀번호 유효성 체크
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
