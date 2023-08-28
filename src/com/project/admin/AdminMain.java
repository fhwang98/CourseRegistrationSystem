package com.project.admin;

import java.util.Scanner;

import com.project.admin.admininfo.AdminInfoMain;
import com.project.admin.course.AdminCourseMain;
import com.project.admin.notice.NoticeMain;
import com.project.admin.room.RoomMain;
import com.project.admin.user.AdminUserMain;
import com.project.authentication.Authentication;
import com.project.notice.NoticeData;
import com.project.user.data.DataAdmin;

/**
 * 관리자 로그인 화면을 컨트롤하는 클래스입니다.
 * @author eugene
 *
 */
public class AdminMain {
	
	public static boolean loop;

	static {
		loop = true;
	}

	/**
	 * 관리자 로그인 화면의 선택지를 컨트롤하는 메소드입니다.
	 * @param a
	 */
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
				AdminCourseMain.controlCourse();
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
				System.out.print("로그아웃하시겠습니까? [y/n] ");
				String answer = scan.nextLine();
				if (!answer.equals("y")) {
					System.out.println("로그아웃을 취소합니다. ");
					System.out.println("계속하려면 엔터를 입력해 주세요.");
					scan.nextLine();
					continue;
				}
				System.out.println("로그아웃합니다.");
				Authentication.loginUserCode = null;
				
				loop = false;
			}
		}

	}

}
