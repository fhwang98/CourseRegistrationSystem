package com.project.admin;

import java.util.Scanner;

public class AdminUtil {

	public static boolean isDigit(String sel) {
		for (int i = 0; i < sel.length(); i++) {
			if (sel.charAt(i) < '0' || sel.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidSel(String sel, int min, int max) {
		
		if (sel.replace(" ", "").equals("")) {
			return false;
		} else if (!isDigit(sel) ||Integer.parseInt(sel) < min || Integer.parseInt(sel) > max) {
			return false;
		}
		return true;
	}
	
}