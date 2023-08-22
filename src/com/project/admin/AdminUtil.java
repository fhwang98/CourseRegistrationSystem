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
	
}