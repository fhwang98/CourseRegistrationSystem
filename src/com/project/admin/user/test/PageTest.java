package com.project.admin.user.test;

import java.util.ArrayList;
import java.util.Scanner;

public class PageTest {

	public static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		// 끝을 모르는 리스트의 내용을 10개씩 출력 -> 1 페이지
		// 10개 출력하면 이전페이지 또는 다음 페이지로 넘어가게 보여주기

		for (int i = 0; i < 51; i++) {
			putList();
		}

		// 페이지 구현
		int curPage = 1;
		int lastPage = (int) Math.ceil(list.size() / (double) 10);

		int index = 0;
		boolean outLoop = true;
		boolean inLoop = true;

		Scanner scan = new Scanner(System.in);

		while (outLoop) {
			inLoop = true;
			int sel = -1;

			for (int i = 0; i < 10; i++) {
				if (index == list.size()) { // 멈춰야 한다! 다 출력함
					break;
				}

				System.out.println(index + ". " + list.get(index));
				index++;
			}
			System.out.println();
			System.out.println("0. 뒤로가기");
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
			System.out.print("번호 입력: ");

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
					if (index == list.size()) {
						System.out.print("마지막 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}

					inLoop = false;
				} else {
					System.out.print("잘못된 입력입니다. 다시 입력하세요. : ");
				}
			}
		}

	}

	private static void putList() {
		String[] arr = { "안녕", "졸리다", "자고싶어", "내일 안갈래", "피곤해", "내일점심뭐야", "점메추" };
		int n = (int) (Math.random() * arr.length);
		list.add(arr[n]);
	}
}
