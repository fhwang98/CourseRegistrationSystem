package com.project.admin.user;

import java.util.Scanner;

import com.project.user.data.DataMember;
import com.project.user.data.UserDbms;

public class AdminUserService {

	public static void showUserList() {

		UserDbms userDbms = new UserDbms(); // 데이터 로드

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

			printMemberList("조회");

			for (int i = 0; i < 10; i++) {
				if (index == UserDbms.getMemberAllList().size()) { // 멈춰야 한다! 다 출력함
					break;
				}

				// 일반 회원 객체 가져오기
				DataMember m = UserDbms.getMemberAllList().get(index);

				// 회원 데이터 출력
				AdminUserService.printMemberData(m);

				index++;
			}

			// 페이지 이동 안내 라벨 출력
			AdminUserView.printMovePage();

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
					index = (((index - 1) / 10) - 1) * 10; // 보여줄 일반 회원의 인덱스를 변경
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

		System.out.println("-------------------------------------");
	}

	public static void printMemberData(DataMember m) {
		System.out.println("회원번호: " + m.getMemberCode());
		System.out.println("이름: " + m.getName());
		System.out.println("아이디: " + m.getId());
		System.out.println("생년월일: " + m.getBirth());
		System.out.println("전화번호: " + m.getTel());

		String discountType = checkDiscountType(m);
		System.out.println("할인: " + discountType);

		// 전체 수강 내역 읽고 회원 코드와 일치하는 수강명만 보여주기 (추가할 것)
		System.out.println("수강내역: ");

		System.out.println("-------------------------------------"); // view로 빼야하나

//		System.out.println();
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
		Scanner scan = new Scanner(System.in);

		while (true) {
			printMemberList("검색"); // View에 추출하기

			System.out.println("0. 뒤로가기");
			System.out.println("1. 아이디로 검색");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 전화번호로 검색");
			System.out.println("-------------------------------------");
			System.out.print("번호를 입력하세요 : ");

			String sel = scan.nextLine(); // 유효화 과정 필요

			if (sel.equals("0")) {
				// 이전 화면으로 이동
				break;
			} else if (sel.equals("1")) {
				searchById();
			} else if (sel.equals("2")) {
				searchByName();
			} else if (sel.equals("3")) {
				searchByPhone();
			} else {
				System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
			}
		}

	}

	private static void searchByPhone() {
		System.out.print("전화번호를 입력하세요. : ");

	}

	private static void searchByName() {
		System.out.print("이름을 입력하세요. : ");

	}

	private static void searchById() {
		System.out.print("아이디를 입력하세요. : ");

	}

	private static void printMemberList(String label) {
		System.out.println("=====================================");
		System.out.println("            일반 회원 정보 " + label);
		System.out.println("=====================================");
	}

}
