package com.project.admin.user;

import java.util.Scanner;

import com.project.user.User;
import com.project.user.data.DataMember;
import com.project.user.data.UserDbms;

public class AdminUserService {

	public static void showUserList() {

		UserDbms userDbms = new UserDbms();

		// 페이지 출력
		// 10명씩 보여주기
		// 10명이 다 출력된 뒤 페이지 이동하는 화면 출력
		// 0을 입력하면 이전 메인 페이지로 이동

		int index = 0;
		boolean outLoop = true;
		boolean inLoop = true;

		Scanner scan = new Scanner(System.in);

		while (outLoop) {
			inLoop = true;
			int sel = -1;

			System.out.println("=====================================");
			System.out.println("            일반 회원 정보 조회");
			System.out.println("=====================================");

			for (int i = 0; i < 10; i++) {
				if (index == UserDbms.getMemberAllList().size()) { // 멈춰야 한다! 다 출력함
					break;
				}

				DataMember m = UserDbms.getMemberAllList().get(index);

				// 회원 데이터 출력
				AdminUserService.printMemberData(m);

//				System.out.println(m.toString());

//				System.out.println(index + ". " + UserDbms.getMemberAllList().get(index));
				index++;
			}

			printMovePage();

			while (inLoop) {
				sel = scan.nextInt();
				System.out.println();

				if (sel == 0) {
					inLoop = false;
					outLoop = false;
				} else if (sel == 1) {
					if (index == 10) {
						System.out.print("첫번째 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}

					index = (((index - 1) / 10) - 1) * 10;
					inLoop = false;
				} else if (sel == 2) {
					if (index == UserDbms.getMemberAllList().size()) {
						System.out.print("마지막 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}

					inLoop = false;
				} else {
					System.out.print("잘못된 입력입니다. 다시 입력하세요. : ");
				}
			}
		}

//		System.out.println("=====================================");
//		System.out.println("            일반 회원 정보 조회");
//		System.out.println("=====================================");

		// 회원 파일을 읽어오기

		System.out.println("-------------------------------------");
	}

	private static void printMovePage() {
		System.out.println();
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.print("번호 입력: ");
	}

	public static void printMemberData(DataMember m) {
		System.out.println("회원번호: " + m.getMemberCode());
		System.out.println("이름: " + m.getName());
		System.out.println("아이디: " + m.getId());
		System.out.println("생년월일: " + m.getBirth());
		System.out.println("전화번호: " + m.getTel());

		String discountType = checkDiscountType(m);
		System.out.println("할인: " + discountType);

		//전체 수강 내역 읽고 회원 코드와 일치하는 수강명만 보여주기
		System.out.println("수강내역: "); 
		
		System.out.println();
	}

	private static String checkDiscountType(DataMember m) {
		String discountType = "";

		if (m.getDiscount() == 1) {
			discountType = "국가유공자";
		} else if (m.getDiscount() == 2) {
			discountType = "국민기초생활보장수급자";
		} else if (m.getDiscount() == 2) {
			discountType = "다자녀가정";
		} else {
			discountType = "해당없음";
		}
		
		return discountType;
	}

	public static void searchUser() {
		// TODO Auto-generated method stub
		
	}

}
