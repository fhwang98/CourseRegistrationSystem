package com.project.admin.admininfo;

import java.util.Iterator;
import java.util.Scanner;

import com.project.admininfo.AdminData;
import com.project.admininfo.AdminInfo;

public class AdminInfoMain {

	public static void myInfoMain() {
		AdminInfoView.adminInfoTitle();
				
		AdminInfoService.check();
		
		AdminInfoView.adminInfoInput();

		Scanner scan = new Scanner(System.in);
		System.out.print("번호 입력: ");
		
		String input = scan.nextLine();
		
		boolean loop = true;
		
		while (loop) {			
			if (input.equals("0")) {
				
				loop = false;
			} else if (input.equals("1")) {
				
				System.out.print("수정할 이름을 입력해주세요. ");
				String name = scan.nextLine();
				
				if (name.matches("^[가-힣]{2,12}$")) {
					
					loop = false;
					updateName(name);
					System.out.println("수정이 완료되었습니다.");
				} else {
					System.out.println("잘못된 이름입니다.");
				}
				
				
			} else if (input.equals("2")) {
				
				System.out.print("수정할 전화번호를 입력해주세요. ");
				String phone = scan.nextLine();
				
				phone = phone.replace("-", "");
				
				if (phone.matches("^[0-9]{11}$")) {
					
					loop = false;
					updatePhone(phone);
					System.out.println("수정이 완료되었습니다.");
				} else {
					System.out.println("잘못된 전화번호입니다.");
				}
								
			} else if (input.equals("3")) {
				
				System.out.println("정말 회원을 탈퇴하시겠습니까?\n한번 지워진 계정은 복구가 불가능합니다.");
				
				while (loop) {

					System.out.print("Y 또는 N 입력: ");
					String answer = scan.nextLine();

					if (answer.equals("y") || answer.equals("Y")) {
						System.out.println("탈퇴 처리되었습니다.");
						deleteMember();
						loop = false;
					} else if (answer.equals("n") || answer.equals("N")) {
						System.out.println("다시 돌아갑니다.");
						loop = false;
					} else {
						System.out.println("다시 입력해주세요.");
					}
					
				}
				
				
			} else {
				System.out.println("올바르지 않은 번호입니다.");
			}
		}
		
	}

	private static void deleteMember() {

		String id = "qjweirowe142";
		
		Iterator<AdminInfo> admin = AdminData.adminList.iterator();
		while (admin.hasNext()) {
			AdminInfo a = admin.next();
			
			if (a.getAdminId().equals(id)) {
				admin.remove();
				break;
			}
		}
		
		AdminData.update();
		
	}

	private static void updateName(String input) {	
		
		String id = "qjweirowe142";
		
		String name = input;
		
		for (AdminInfo a : AdminData.adminList) {
			if (a.getAdminId().equals(id)) {
				a.setAdminName(name);
				break;
			}
		}
		
		AdminData.update();		
		
	}

	private static void updatePhone(String input) {	
		
		String id = "qjweirowe142";
		
		String phone = input;
		
		for (AdminInfo a : AdminData.adminList) {
			if (a.getAdminId().equals(id)) {
				a.setAdminPhone(phone);
				break;
			}
		}
		
		AdminData.update();

	}
	
}
