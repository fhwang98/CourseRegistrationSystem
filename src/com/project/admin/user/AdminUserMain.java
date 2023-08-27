package com.project.admin.user;

import java.util.Scanner;

import com.project.course.CourseHistoryData;
import com.project.courseinfo.CourseData;
import com.project.user.data.UserDbms;

/**
 * 관리자 로그인 후 일반 회원 관리를 담당하는 메인 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class AdminUserMain {

	/**
	 * 관리자의 일반 회원 관리 메인 기능을 담당하는 메소드입니다.
	 */
	public static void showAdminUserMain() {
		// 관리자 로그인 후 보이는 메인화면에서 1. 일반 회원 관리를 눌렀을 때 나오는 페이지.

		Scanner scan = new Scanner(System.in);

		// 기본 출력을 view에서 만들고 여기서 호출

		AdminUserView.printAdminUserMain();

		while (true) {
			// 번호 입력부터 여기서 시작
			String sel = scan.nextLine();

			if (sel.equals("0")) { // 이전 페이지인 관리자 로그인 후 화면으로 돌아간다.
				System.out.println("이전 화면으로 이동합니다.");
				System.out.println("계속 하시려면 엔터키를 입력해주세요.");
				scan.nextLine();
				
				break;
			} else if (sel.equals("1")) { // 전체 회원 조회 페이지로 이동
				// 기능
				AdminUserService.showUserList();

				AdminUserView.printAdminUserMain();
			} else if (sel.equals("2")) { // 회원 검색 페이지로 이동
				// 기능
				AdminUserService.searchUser();

				AdminUserView.printLine();
				AdminUserView.printAdminUserMain();
			} else { // invalid
				AdminUserView.printInvalidInput();
			}

		}

	}

	// 없애기
	public static void main(String[] args) {

		// 모든 사용자 정보 로드 - 일반, 강사, 관리자
		UserDbms userDbms = new UserDbms();

		// 전체 수강 내역 로드
		CourseHistoryData.load();

		// 전체 강좌 목록 로드
		CourseData.allCourseMap();

		// 관리자 로그인 후 보이는 메인화면에서 1. 일반 회원 관리를 눌렀을 때 나오는 페이지.
		// 기능
		AdminUserMain.showAdminUserMain();

	}
}
