package com.project.admin.admininfo;

import com.project.admin.AdminData;
import com.project.authentication.Authentication;
import com.project.admin.Admin;

/**
 * 로그인한 관리자의 정보를 출력하는 클래스 입니다.
 * @author eugene
 *
 */
public class AdminInfoService {

	/**
	 * 로그인한 관리자의 정보를 출력하는 메소드 입니다.
	 */
	public static void check() {
		
		AdminData.load();
		
		String id = AdminInfoMain.getId(Authentication.loginUserCode);
		
		for (Admin a : AdminData.adminList) {
			if (a.getAdminId().equals(id)) {
				System.out.printf("이름: %s\n아이디: %s\n전화번호: %s\n", a.getAdminName(), a.getAdminId(), a.getAdminPhone());
				break;
			}
		}
		
	}
	
}
