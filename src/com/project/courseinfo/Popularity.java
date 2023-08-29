package com.project.courseinfo;

import java.util.Scanner;

/**
 * 이달의 추천 출력 클래스 입니다.
 */
public class Popularity {

	/**
	 * 이달의 추천 메시지를 출력하는 메소드 입니다.
	 *  
	 */
	public static void popularity() {
		
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("========================");
		System.out.println("	이달의 추천 ");
		System.out.println("========================");
		System.out.println("★ 이달의 추천 강좌 ★");
		System.out.println("========================");
		System.out.println("프로그램명: 헬스");
		System.out.println("강좌코드: H002");
		System.out.println("강사명: 정호석");
		System.out.println("시작 시간: 06:00");
		System.out.println("요일: 화");
		System.out.println("대상: 청소년");
		System.out.println("수강료: 39000원");
		System.out.println("현재 신청 인원수: 0명");
		System.out.println("강좌 평균 별점: ★★★★★");
		System.out.println("강사 평균 별점: ★★★★");

		System.out.println();
		System.out.println("========================");
		System.out.println("★ 이달의 추천 강사 ★");
		System.out.println("========================");
		System.out.println("프로그램명: STEAM 초등과학토론");
		System.out.println("강좌코드: K003");
		System.out.println("강사명: 권유리");
		System.out.println("시간: 10:00");
		System.out.println("요일: 월");
		System.out.println("대상: 어린이");
		System.out.println("수강료: 무료");
		System.out.println("현재 신청 인원수: 9명");
		System.out.println("강좌 평균 별점: ★★★★");
		System.out.println("강사 평균 별점: ★★★★★");
	
		System.out.println();
		System.out.println("0. 뒤로가기 ");
		System.out.print("입력:  ");
		String input = scan.nextLine();
		while (!input.equals("0")) {

			if (input.equals("0")) {
				CourseInfo.courseInfo();

			} else {
				System.out.println("뒤로가려면 0번을 입력하세요.");
				System.out.print("입력: ");
				input = scan.nextLine();

			}

		}
		if (input.equals("0")) {
			CourseInfo.courseInfo();
		}
	}
	
}
