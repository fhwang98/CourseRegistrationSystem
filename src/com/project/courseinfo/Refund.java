package com.project.courseinfo;

import java.util.Scanner;

/**
 * 환불 안내 화면을 출력하는 클래스입니다.
 * 
 */
public class Refund {

	static Scanner scan = new Scanner(System.in);

	/**
	 * 환불 안내 메세지를 출력하는 메소드 입니다.
	 * 
	 */
	public static void refund() {

		System.out.println();
		System.out.println("========================");
		System.out.println("환불 안내");
		System.out.println("========================");
		System.out.println("신청 후 7일 이내: 100% 환불");
		System.out.println("신청 후 8일 ~ 수강일 10일 전: 90% 환불");
		System.out.println("수강일 9일 전 ~ 7일 전: 80% 환불");
		System.out.println("수강일 6일 전 ~ 3일 전 : 70% 환불");
		System.out.println("수강일 2일 전 ~ 1일 전: 60% 환불");
		System.out.println("당일 취소 : 환불 불가");

		System.out.println();
		System.out.println("0.뒤로가기");
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
