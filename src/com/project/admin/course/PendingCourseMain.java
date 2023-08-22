package com.project.admin.course;

import java.util.Scanner;

public class PendingCourseMain {

	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}

	
	public static void controlPendingCourse() {
		//승인 대기 강좌 목록 보기
		
		boolean loop = true;
		int page = 0;
		int lastpage = PendingCourseData.getList().size() / 10;
		
		while (true) {
			
			//10개를 보여줌
			System.out.println("0. 뒤로가기 1. 이전 2. 다음 3. 강좌 확인");
			String sel = scan.nextLine();
			if (!sel.matches("[0-3]{1}")) {
				System.out.println("invalid input");
				continue;
			}
			if (sel.equals("0")) {
				loop = false;
			} else if (sel.equals("1")) {
				if (page == 0) {
					page++;
				} else {
					page--;
				}
			} else if (sel.equals("2")) {
				if (page == 0 || page == lastpage) {
					//강좌 확인
				} else {
					page++;
				}
			} else if (sel.equals("3")) {
				if (page == 0 || page == lastpage) {
					continue;
				} else {
					//강좌 확인
					checkingControl(page);
				}
			}
		}
	}
	
	public static void checkingControl(int page) {
	
		System.out.println("확인할 대기강좌 정보");
		String no = scan.nextLine();
		if (!no.matches("[1-9]{1}")) {
			System.out.println("invalid input");
			return;
		}
		
		//실제 확인할 대기강좌의 인덱스를 구함
		int index = PendingCourseData.getList().size() - Integer.parseInt(no) - page * 10;
		boolean loop = true;
		
		while (loop) {
			
		}
		
	}
}
