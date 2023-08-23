package com.project.busstop;

import java.util.Scanner;

public class BusStopMain {
	public static boolean outLoop = true;
	public static boolean inLoop = true;

	public static void busStopMain() {
		// 버스정류장 데이터 가져오기
		BusStopData.load();

		Scanner scan = new Scanner(System.in);

		while (outLoop) {
			BusStopMain.inLoop = true;
			BusStopView.printBusStopMain();

			while (inLoop) {
				// 버스 정류장 연번 입력받기
				String sel = scan.nextLine();
				System.out.println();

				// 문자열 내의 공백 제거
				sel = sel.replace(" ", "");

				if (Integer.parseInt(sel) == 0) { // 뒤로가기. 가장 초기 화면으로 돌아간다.
					BusStopMain.inLoop = false;
					BusStopMain.outLoop = false;
					break;
				} else if (Integer.parseInt(sel) <= BusStopData.busStopList.size()) {
					BusStopService.showTimeList(sel);
				} else {
					BusStopView.printInvalidInput(); // 다시 inLoop 돌기
				}
			}
		}

//		System.out.println("outloop is false"); // 초기 메인화면으로 이동하기
	}

//	public static void main(String[] args) {
//
//		// 버스정류장 데이터 가져오기
//		BusStopData.load();
//
//		Scanner scan = new Scanner(System.in);
//
//		while (outLoop) {
//			BusStopMain.inLoop = true;
//			BusStopView.printBusStopMain();
//
//			while (inLoop) {
//				// 버스 정류장 연번 입력받기
//				String sel = scan.nextLine();
//				System.out.println();
//
//				// 문자열 내의 공백 제거
//				sel = sel.replace(" ", "");
//
//				if (Integer.parseInt(sel) == 0) { // 뒤로가기. 가장 초기 화면으로 돌아간다.
//					BusStopMain.inLoop = false;
//					BusStopMain.outLoop = false;
//					break;
//				} else if (Integer.parseInt(sel) <= BusStopData.busStopList.size()) {
//					BusStopService.showTimeList(sel);
//				} else {
//					BusStopView.printInvalidInput(); // 다시 inLoop 돌기
//				}
//			}
//		}
//
//		System.out.println("outloop is false"); // 초기 메인화면으로 이동하기
//	}
}
