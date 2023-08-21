package com.project.courseinfo;

import java.util.Scanner;

public class CourseInfo {
	
		
	public static void lectureInfo() {
		
		
		
		Scanner scan = new Scanner(System.in);
		
		lectureInfoList();
		
		int input = scan.nextInt();
		
		if(input == 0) {
			goMain();
			
		} else if (input == 1) {
			Popularity.popularity();
			
		} else if (input == 2) {
			Individual.individual();
			
		} else if(input == 3) {
			CourseList.lectureList();
			
		} else if(input == 4) {
			Discount.discount();
			
		} else if(input == 5) {
			Refund.refund();
		}
		
		
	}


	public static void lectureInfoList() {
	
		System.out.println();
		System.out.println("========================");
		System.out.println("수강신청 안내 페이지");
		System.out.println("========================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이달의 추천");
		System.out.println("2. 개인별 강좌 추천");
		System.out.println("3. 강좌 목록 조회");
		System.out.println("4. 할인 대상 안내");
		System.out.println("5. 환불 안내");
		System.out.println("------------------------");
		System.out.print("번호 입력: ");
		
	}
	
	private static void goMain() {
//		Main.mainMent();
	}
		
	
}
