package com.project.admin;

/**
 * 관리자 기능 전체에서 필요할만한 메소드를 모아둔 클래스 입니다.
 * @author eugene
 *
 */
public class AdminUtil {

	private static boolean isDigit(String sel) {
		//길이가 0일때
		if (!sel.matches("[0-9]{1,2}")) {
			return false;
		}
		return true;
	}
	
	/**
	 * 스캐너로 입력받은 값의 유효성 검사를 진행하는 메소드 입니다.
	 * @param input
	 * @param min
	 * @param max
	 * @return
	 */
	public static int isValidSel(String input, int min, int max) {

		if (!isDigit(input)) {
			return -1;
		}
		if (Integer.parseInt(input) < min || Integer.parseInt(input) > max) {
			return -1;
		}
		
		return Integer.parseInt(input);
	}

	//TODO 분단위도 받았을 때 사용하는 메소드 -> 12:00 단위로 강의 개설할거라서 필요 없어!
//	public static boolean isOverlappedTime(String time, String inputTime) {
//
//		// 일단 둘다 숫자, 00시를 기준으로 분단위로 바꿈
//		int timeToMinute = getMinute(time);
//		int inputTimeToMinute = getMinute(inputTime);
//
//		// 두 시간의 차이 절댓값 60(분) 이하면 시간이 겹침
//		int gap = Math.abs(inputTimeToMinute - timeToMinute);
//		if (gap < 60) {
//			return false;
//		}
//		return true;
//	}
//
//	public static int getMinute(String time) {
//
//		String[] temp = time.split(":");
//
//		return (Integer.parseInt(time.substring(0, 2)) * 60) + Integer.parseInt(time.substring(3, 4));
//	}
	
	
}