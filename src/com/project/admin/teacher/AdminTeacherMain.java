package com.project.admin.teacher;

import java.util.Scanner;

import com.project.course.CourseHistoryData;
import com.project.courseinfo.CourseData;
import com.project.user.data.UserDbms;

/**
 * 관리자 로그인 후 강사 회원 관리를 담당하는 메인 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class AdminTeacherMain {

	/**
	 * 관리자의 강사 회원 관리 메인 기능을 담당하는 메소드입니다.
	 */
	public static void showAdminTeacherMain() {
		// 관리자 로그인 후 보이는 메인화면에서 2. 강사 회원 관리를 눌렀을 때 나오는 페이지.

		Scanner scan = new Scanner(System.in);

		// 기본 출력을 view에서 만들고 여기서 호출

		AdminTeacherView.printAdminTeacherMain();

		while (true) {
			// 번호 입력부터 여기서 시작
			String sel = scan.nextLine();

			if (sel.equals("0")) { // 이전 페이지인 관리자 로그인 후 화면으로 돌아간다.

				break;
			} else if (sel.equals("1")) { // 전체 회원 조회 페이지로 이동
				// 기능
				AdminTeacherService.showTeacherList();

				AdminTeacherView.printAdminTeacherMain();
			} else if (sel.equals("2")) { // 회원 검색 페이지로 이동
				// 기능
				AdminTeacherService.searchTeacher();

				AdminTeacherView.printLine();
				AdminTeacherView.printAdminTeacherMain();
			} else { // invalid
				AdminTeacherView.printInvalidInput();
			}

		}
	}

}
