package com.project.busstop;

public class BusStopView {

	public static void printBusStopMain() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println("                셔틀버스");
		System.out.println("=====================================");
		System.out.println("          정류장 별 시간표 안내");
		System.out.println("-------------------------------------");

		// 셔틀버스 전체 리스트 - 이름 출력
		printAllBusStopName();
		
		System.out.println("0. 뒤로가기");
		System.out.println("-------------------------------------");
		System.out.print("조회할 버스 정류장 번호를 입력하세요: ");
	}

	// 셔틀버스 전체 리스트 - 이름 출력
	private static void printAllBusStopName() {
		for (BusStop b : BusStopData.busStopList) {
			System.out.println(b.getNum() + ". " + b.getName());
		}
	}

	public static void printInvalidInput() {
		System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
	}

}
