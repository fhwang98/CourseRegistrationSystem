package com.project.busstop;

import java.util.Scanner;

/**
 * 셔틀 버스 메인 역할을 하는 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class BusStopMain {
	public static boolean outLoop = true;
	public static boolean inLoop = true;

	/**
	 * 셔틀 버스 메인 기능이 실행되는 메소드입니다.
	 */
	public static void busStopMain() {
		// 버스정류장 데이터 가져오기
		BusStopData.load();

		Scanner scan = new Scanner(System.in);

		while (outLoop) {
			BusStopMain.inLoop = true;

			// 라벨 출력
			BusStopView.printBusStopMain();

			while (inLoop) {
				// 버스 정류장 연번 입력받기
				String sel = scan.nextLine();
				System.out.println();

				int intSel = BusStopService.changeValidNumInput(sel);

				if (intSel == 0) { // 뒤로가기. 가장 초기 화면으로 돌아간다.
					BusStopService.pause(scan);

					BusStopMain.inLoop = false;
					BusStopMain.outLoop = false;
					break;
				} else if (intSel > 0 && intSel <= BusStopData.busStopList.size()) { // 버스정류장 연번에 해당되는 경우
					BusStopService.showTimeList("" + intSel);
				} else { // 그 외의 다른 입력 (-1)
					BusStopView.printInvalidInput(); // 다시 inLoop 돌기
				}
			}
		}
	}

	// 테스트용. 최종에서는 지우고 올리기
	public static void main(String[] args) {
		busStopMain();
	}
}
