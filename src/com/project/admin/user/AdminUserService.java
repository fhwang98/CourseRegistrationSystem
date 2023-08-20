package com.project.admin.user;

import com.project.admin.user.test.User;
import com.project.admin.user.test.UserData;

public class AdminUserService {

	public static void showUserList() {

		System.out.println("=====================================");
		System.out.println("            일반 회원 정보 조회");
		System.out.println("=====================================");

		// 회원 파일을 읽어오기

		UserData.loadUserData(); // 테스트용 임시 데이터 생성 메소드
//		System.out.println(UserData.userList);

		int count = 1;

		// 회원 리스트 읽어오기
		for (User u : UserData.userList) {
			System.out.println(u.getName());
			if (count == 10) {
				AdminUserView.printMovePage();
				count = 0;
			}
			count++;
		}

		System.out.println("-------------------------------------");
	}

	public static void searchUser() {

	}

}
