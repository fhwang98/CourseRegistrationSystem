package com.project.admin;

import java.util.Scanner;

import com.project.admin.admininfo.AdminInfoMain;
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

			String input = scan.nextLine();
			int sel = AdminUtil.isValidSel(input, 1, 7);
			if (sel == -1) {
				AdminView.printInvalidInputMessage(scan);
			} else if (sel == 1) {
				//일반 회원 관리
				System.out.println("일반 회원 관리");
//				AdminUserMain.showAdminUserMain();
			} else if (sel == 2) {
				//강사 회원 관리
				System.out.println("강사 회원 관리");
			} else if (sel == 3) {
				//강좌 관리
				System.out.println("강좌 관리");
			} else if (sel == 4) {
				//강의실 관리
				RoomMain.controlRoom();
			} else if (sel == 5) {
				//5. 공지사항
				NoticeMain.controlNoticeMain();
			} else if (sel == 6) {
				//내정보
				AdminInfoMain.myInfoMain();
			}  else if (sel == 7) {
				//로그아웃

				System.out.println("log out");
				loop = false;
			}
		}

	}

}
