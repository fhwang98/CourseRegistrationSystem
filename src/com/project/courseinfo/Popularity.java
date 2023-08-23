package com.project.courseinfo;

import java.util.Scanner;

public class Popularity {

	//이달의 추천 선택 시 출력 멘트
	public static void popularity() {
		
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("==========================");
		System.out.println("	이달의 추천 ");
		System.out.println("==========================");
		System.out.println("★ 이달의 추천 강좌 ★");
		System.out.println("==========================");
		System.out.println("프로그램명: 인라인스케이트");
		System.out.println("강사명: 홍길동");
		System.out.println("시간: 15:00~16:00");
		System.out.println("요일: 화, 목");
		System.out.println("대상: 유아, 어린이");
		System.out.println("수강료: 35000원(1개월)");
		System.out.println("현재 신청 인원수: 15명");
		System.out.println("강좌 평균 별점: ★★★★★");
		System.out.println("강사 평균 별점: ★★★★");

		System.out.println();
		System.out.println("==========================");
		System.out.println("★ 이달의 추천 강사 ★");
		System.out.println("==========================");
		System.out.println("프로그램명: 월요통기타");
		System.out.println("강사명: 아무개");
		System.out.println("시간: 13:00~14:00");
		System.out.println("요일: 월");
		System.out.println("대상: 초 3 이상 누구나");
		System.out.println("수강료: 50000원(1개월)");
		System.out.println("현재 신청 인원수: 8명");
		System.out.println("강좌 평균 별점: ★★★★");
		System.out.println("강사 평균 별점: ★★★★★");
	
		System.out.println();
		System.out.println("0. 뒤로가기 ");
		System.out.print("입력:  ");
		String input = scan.nextLine();
		while (!input.equals("0")) {

			if (input.equals("0")) {
				CourseInfo.lectureInfo();

			} else {
				System.out.println("뒤로가려면 0번을 입력하세요.");
				System.out.print("입력: ");
				input = scan.nextLine();

			}

		}
		if (input.equals("0")) {
			CourseInfo.lectureInfo();
		}
	}
	
}
