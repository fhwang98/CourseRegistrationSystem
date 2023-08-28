package com.project.busstop;

/**
 * 셔틀 버스 기능 중 화면 출력을 담당하는 클래스 입니다.
 * @author 황은하
 *
 */
public class BusStopView {

	/**
	 * 셔틀 버스의 메인 화면을 출력하는 메소드입니다.
	 * 전체 셔틀버스의 번호와 목록이 출력됩니다.
	 */
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

	/**
	 * 해당하는 셔틀 버스 정류장의 세부사항을 출력하는 메소드입니다.
	 * 해당 정류장의 연번과 이름, 1회차부터 5회차까지의 시간이 출력됩니다.
	 * @param busStopObj 연번과 이름을 출력할 버스 정류장 객체
	 */
	public static void printBusStopDetail(BusStop busStopObj) {
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
	}

	/**
	 * 초기 화면으로 돌아감을 출력하는 메소드입니다.
	 */
	public static void printPauseAndBack() {
		System.out.println("초기 메인화면으로 돌아갑니다.");
		System.out.println("계속 하려면 엔터를 입력하세요.");
	}

	
	/**
	 * 전체 셔틀 버스 정류장의 연번과 이름을 출력하는 메소드입니다.
	 */
	private static void printAllBusStopName() {
		for (BusStop b : BusStopData.busStopList) {
			System.out.println(b.getNum() + ". " + b.getName());
		}
	}

	/**
	 * 유효하지 않은 입력 시 출력되는 메소드입니다.
	 */
	public static void printInvalidInput() {
		System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
	}

}
