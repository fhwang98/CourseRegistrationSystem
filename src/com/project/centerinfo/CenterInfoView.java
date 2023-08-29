package com.project.centerinfo;

import java.util.Scanner;

import com.project.main.MainView;

/**
 * 출력클래스 입니다.
 * 
 * 출력과 관련된 기능을 제공합니다.
 */
public class CenterInfoView {

	static Scanner scan = new Scanner(System.in);

	/**
	 * 센터 정보를 출력하는 역할을 합니다.
	 * @param centerInfo
	 */
	public static void centerInfo() {

		System.out.println();
		System.out.println("=========================");
		System.out.println("센터 정보");
		System.out.println("=========================");
		System.out.println();
		System.out.println("센터명 : OOO센터");
		System.out.println("오시는 길 : OOO센터");
		System.out.println("전화번호 : 02-123-4567");
		System.out.println();
		System.out.println("방문 접수 가능한 시간: 10:00 - 18:00");
		System.out.println("----------------------------------");

		System.out.println();
		System.out.println();
		System.out.println("0. 뒤로가기");
		System.out.print("입력: ");
		String input = scan.nextLine();

		while (!input.equals("0")) {

			if (input.equals("0")) {
				MainView.MainScreen();

			} else {
				System.out.println("뒤로가려면 0번을 입력하세요.");
				System.out.print("입력: ");
				input = scan.nextLine();
			}
		}
			
		if (input.equals("0")) {
			MainView.MainScreen();
		}

	}
}
