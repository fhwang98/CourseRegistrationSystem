package com.project.busstop;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 셔틀 버스의 기능을 담당하는 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class BusStopService {

	/**
	 * 입력받은 숫자에 해당하는 셔틀 버스 정보를 보여주는 메소드입니다.
	 * 
	 * @param sel 버스정류장 연번
	 */
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
		
		// 해당 버스 정류장의 자세한 정보 출력
		BusStopView.printBusStopDetail(busStopObj);

		while (true) {
			// 더 검색할건지 물어보기
			String input = scan.nextLine();

			// 입력받은 문자열을 유효하게 만들기
			input = changeValidYNInput(input);

			// 검색한다면 inloop로 돌아가기
			if (input.equals("Y")) {
				BusStopMain.inLoop = false;
				break;
			} else if (input.equals("N")) { // 검색 안한다면 outloop도 빠져나와 초기 메인화면으로 돌아가기
				pause(scan);

				BusStopMain.inLoop = false;
				BusStopMain.outLoop = false;
				break;
			} else {
				BusStopView.printInvalidInput();
			}

		}

	}

	/**
	 * 이전 화면으로 돌아갈 때 문구를 출력하고 엔터를 입력받는 메소드입니다.
	 * @param scan 스캐너 객체
	 */
	public static void pause(Scanner scan) {
		BusStopView.printPauseAndBack();
		scan.nextLine();
	}

	/**
	 * y, n를 입력받았을 때 공백을 지우고, 대문자로 변경하는 메소드입니다.
	 * @param input 대답을 받기 위한 y 또는 n 문자
	 * @return 공백이 사라지고 대문자로 변경된 input
	 */
	public static String changeValidYNInput(String input) { // 입력받은 문자열을 유효하게 만들기
		// 공백 지우기
		input = input.replace(" ", "");

		// 문자를 모두 대문자로 변경하기
		input = input.toUpperCase();

		return input;
	}

	/**
	 * 입력받은 숫자를 유효한 숫자로 변환하는 메소드입니다. 
	 * @param input 뒤로가기, 혹은 자세한 정보를 볼 버스 정류장 연번
	 * @return 공백이 사라지고, 숫자인지 유효성 검사를 마친 결과
	 */
	public static int changeValidNumInput(String input) {

		// 입력받은 문자열을 사용한다.
		// 적합한 입력은 그대로 반환 후 상황에 맞는 코드를 진행한다.
		// 적합하지 않은 입력은 -1로 반환한다.

		// 들어올 수 있는 문자열의 종류
		// 영어 대문자, 영어 소문자, 한글, 공백, 특수문자, 숫자
		// 1. 공백 제거
		// 2. 숫자인지 확인
		// 숫자 - 음수는 안된다. -> return -1;

		// 공백 지우기
		input = input.replace(" ", "");

		// 1, 2자 숫자만 승인하기
		String regex = "";
		Pattern p1 = null;
		Matcher m1 = null;

		regex = "^[0-9]{1,2}$"; // 숫자만. 1 ~ 2자
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(input);

		if (!m1.find()) { // 없는 경우
			return -1;
		}

		// 유효한 숫자 값이 있는 경우
		return Integer.parseInt(m1.group());
	}

}
