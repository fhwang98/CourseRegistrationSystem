package com.project.admin.teacher;

import java.util.Scanner;

import com.project.course.CourseHistoryData;
import com.project.courseinfo.CourseData;
import com.project.user.data.UserDbms;

public class AdminTeacherMain {

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

//				System.out.println("AdminUserMain Out");
	}

	public static void main(String[] args) {

		// 모든 사용자 정보 로드 - 일반, 강사, 관리자
		UserDbms userDbms = new UserDbms();

		// 전체 수강 내역 로드
		CourseHistoryData.load();

		// 전체 강좌 목록 로드
		CourseData.allCourseMap();
		CourseData.allCourseList();

		// 관리자 로그인 후 보이는 메인화면에서 1. 일반 회원 관리를 눌렀을 때 나오는 페이지.
		// 기능
		AdminTeacherMain.showAdminTeacherMain();

	}
}
