package com.project.courseinfo;

import java.util.Scanner;

public class Individual {

	static Scanner scan = new Scanner(System.in);

	public static void individual() {

		individualMent();
	}


	private static void individualMent() {

		System.out.println();
		System.out.println("==========================");
		System.out.println("개인 별 강좌 추천");
		System.out.println("==========================");
		System.out.println("강좌 추천을 위해 관심있는 카테고리의 번호를 입력해주세요.");
		System.out.println();
		System.out.println();
		System.out.println("0. 뒤로가기");
		System.out.println("1. 문화");
		System.out.println("2. 피아노");
		System.out.println("3. 체육");
		System.out.println("4. 어린이");
		System.out.println("5. 블록교실");
		System.out.println("----------------------------------");
		
		System.out.print("입력: ");
		String input = scan.nextLine();
		
		if(input.equals("0")) {
			CourseInfo.lectureInfo();
		}
		//
		while (!input.equals("0")) {

		if (input.equals("1")) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("개인 별 강좌 추천");
			System.out.println("==========================");
			System.out.println("문화를 선택하셨습니다.");
			System.out.println("아래 강좌를 추천합니다.");
			System.out.println("==========================");
			System.out.println();

			CourseData.cultureRecommend();

			System.out.println();
			System.out.println("0.뒤로가기");
			System.out.print("입력: ");

			input = scan.nextLine();

			if (input.equals("0")) {
				individualMent();
				}

		} else if (input.equals("2")) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("개인 별 강좌 추천");
			System.out.println("==========================");
			System.out.println("피아노를 선택하셨습니다.");
			System.out.println("아래 강좌를 추천합니다.");
			System.out.println("==========================");
			System.out.println();
			
			CourseData.pianoRecommend();

			System.out.println();
			System.out.println("0.뒤로가기");
			System.out.println("입력: ");

			input = scan.nextLine();

			if (input.equals("0")) {
				individualMent();
				}

		} else if (input.equals("3")) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("개인 별 강좌 추천");
			System.out.println("==========================");
			System.out.println("체육을 선택하셨습니다.");
			System.out.println("아래 강좌를 추천합니다.");
			System.out.println("==========================");
			System.out.println();

			CourseData.sportsRecommend();

			System.out.println();
			System.out.println("0.뒤로가기");
			System.out.println("입력: ");

			input = scan.nextLine();

			if (input.equals("0")) {
				individualMent();
				}

		} else if (input.equals("4")) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("개인 별 강좌 추천");
			System.out.println("==========================");
			System.out.println("어린이를 선택하셨습니다.");
			System.out.println("아래 강좌를 추천합니다.");
			System.out.println("==========================");
			System.out.println();

			CourseData.kidsRecommend();

			System.out.println();
			System.out.println("0.뒤로가기");
			System.out.println("입력: ");

			input = scan.nextLine();

			if (input.equals("0")) {
				individualMent();
				}

		} else if (input.equals("5")) {
			System.out.println();
			System.out.println("==========================");
			System.out.println("개인 별 강좌 추천");
			System.out.println("==========================");
			System.out.println("블럭교실을 선택하셨습니다.");
			System.out.println("아래 강좌를 추천합니다.");
			System.out.println("==========================");
			System.out.println();

			CourseData.blockRecommend();

			System.out.println();
			System.out.println("0.뒤로가기");
			System.out.println("입력: ");
			
			input = scan.nextLine();

			if (input.equals("0")) {
				individualMent();
				}
			} else {
				System.out.println("목록에 있는 번호를 입력하세요.");
				System.out.print("입력: ");
				input = scan.nextLine();

				
			}
		}
		if(input.equals("0")) {
			CourseInfo.lectureInfo();
		}

	}

//	private static void goBack() {
//		CourseInfo.lectureInfo();
//		
//	}

}// 문화, 피아노, 어린이, 체육, 블럭교실
