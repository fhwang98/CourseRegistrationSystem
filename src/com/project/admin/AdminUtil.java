package com.project.admin;

public class AdminUtil {

	public static boolean isDigit(String sel) {
		for (int i = 0; i < sel.length(); i++) {
			if (sel.charAt(i) < '0' || sel.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	
}
