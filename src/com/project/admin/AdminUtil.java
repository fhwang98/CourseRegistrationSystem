package com.project.admin;

public class AdminUtil {

	public static boolean isDigit(String sel) {
		//길이가 0일때
		if (sel.length() == 0) {
			return false;
		}
		for (int i = 0; i < sel.length(); i++) {
			if (sel.charAt(i) < '0' || sel.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	

	
	public static int isValidSel(String input, int min, int max) {
		
		input = input.replaceAll("(\\s||\\t|\\r\\n|\\n)", "");
		
		if (!isDigit(input)) {
			return -1;
		}
		if (Integer.parseInt(input) < min || Integer.parseInt(input) > max) {
			return -1;
		}
		
		return Integer.parseInt(input);
	}

	
	public static boolean isOverlappedTime(String time, String inputTime) {

		// 일단 둘다 숫자, 00시를 기준으로 분단위로 바꿈
		int timeToMinute = getMinute(time);
		int inputTimeToMinute = getMinute(inputTime);

		// 두 시간의 차이 절댓값 60(분) 이하면 시간이 겹침
		int gap = Math.abs(inputTimeToMinute - timeToMinute);
		if (gap < 60) {
			return false;
		}
		return true;
	}

	public static int getMinute(String time) {

		String[] temp = time.split(":");

		return (Integer.parseInt(time.substring(0, 2)) * 60) + Integer.parseInt(time.substring(3, 4));
	}
	
	
}