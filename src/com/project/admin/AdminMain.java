package com.project.admin;

import java.util.Scanner;

import com.project.admin.notice.NoticeMain;
import com.project.admin.room.RoomMain;
import com.project.admin.user.AdminUserMain;
import com.project.notice.NoticeData;

public class AdminMain {

	public static boolean loop;

	static {
		loop = true;
	}

	public static void controlAdmin() {

		Scanner scan = new Scanner(System.in);

		while (loop) {
			AdminView.printAdminMain();
			String sel = scan.nextLine();
			if (!AdminUtil.isValidSel(sel, 1, 7)) {
				System.out.println("is invalid input");
				System.out.println("enter a new line to going back");
				scan.nextLine();
				continue;
			}

			if (sel.equals("1")) {
				// 일반 회원 관리
				System.out.println("일반 회원 관리");
//				AdminUserMain.showAdminUserMain();
			} else if (sel.equals("2")) {
				// 강사 회원 관리
				System.out.println("강사 회원 관리");
			} else if (sel.equals("3")) {
				// 강좌 관리
				System.out.println("강좌 관리");
			} else if (sel.equals("4")) {
				// 강의실 관리
				System.out.println("강의실 관리");
				RoomMain.roomControl();
			} else if (sel.equals("5")) {
				// 5. 공지사항
				NoticeData.load();
				NoticeMain.controlNoticeMain();
			} else if (sel.equals("6")) {
				// 내정보
			} else if (sel.equals("7")) {
				// 로그아웃
				System.out.println("log out");
				loop = false;
			}
		}

	}

}
