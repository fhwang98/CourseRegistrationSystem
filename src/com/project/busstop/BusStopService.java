package com.project.busstop;

import java.util.Scanner;

public class BusStopService {

	public static void showTimeList(String sel) {
		Scanner scan = new Scanner(System.in);

		BusStop busStopObj = null;

		// 리스트에서 동일한 번호의 객체 가져오기
		for (BusStop b : BusStopData.busStopList) {
			if (b.getNum().equals(sel)) {
				busStopObj = b;
				break;
			}
		}

		// 초기 화면 출력
		System.out.println("=====================================");
		System.out.println("정류장: " + busStopObj.getNum() + ". " + busStopObj.getName());
		System.out.println("=====================================");
		System.out.println("[시간표]");
		System.out.println("-------------------------------------");

		// 가져온 객체의 시간 출력하기
		// 가져온 값이 null인 경우, x로 바꾸어 출력하기

		System.out.println("1회: " + ((busStopObj.getTime1() == null) ? "X" : busStopObj.getTime1()));
		System.out.println("2회: " + ((busStopObj.getTime2() == null) ? "X" : busStopObj.getTime2()));
		System.out.println("3회: " + ((busStopObj.getTime3() == null) ? "X" : busStopObj.getTime3()));
		System.out.println("4회: " + ((busStopObj.getTime4() == null) ? "X" : busStopObj.getTime4()));
		System.out.println("5회: " + ((busStopObj.getTime5() == null) ? "X" : busStopObj.getTime5()));

		System.out.println("-------------------------------------");

		System.out.print("다른 정류장의 시간표를 확인하시겠습니까? (y/n) : ");

		while (true) {
			// 더 검색할건지 물어보기
			String input = scan.nextLine();

			// 입력받은 문자열을 유효하게 만들기
			input = changeValidInput(input);

			// 검색한다면 inloop로 돌아가기
			if (input.equals("Y")) {
				BusStopMain.inLoop = false;
				break;
			} else if (input.equals("N")) { // 검색 안한다면 outloop도 빠져나와 초기 메인화면으로 돌아가기
				System.out.println("초기 메인화면으로 돌아갑니다.");
				System.out.println("계속 하려면 엔터를 입력하세요.");
				scan.nextLine();
				
				BusStopMain.inLoop = false;
				BusStopMain.outLoop = false;
				break;
			} else {
				BusStopView.printInvalidInput();
			}

		}

	}

	// 입력받은 문자열을 유효하게 만들기
	private static String changeValidInput(String input) {

		// 공백 지우기
		input = input.replace(" ", "");

		// 문자를 모두 대문자로 변경하기
		input = input.toUpperCase();

		return input;
	}

}
