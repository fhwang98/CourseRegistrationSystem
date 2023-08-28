package com.project.admin.admininfo;

/**
 * 관리자 내정보의 화면을 출력하는 메소드 입니다.
 * @author eugene
 *
 */
public class AdminInfoView {

	/**
	 * 관리자 내정보의 제목을 출력하는 메소드 입니다.
	 */
	public static void adminInfoTitle() {
		
		System.out.println("=====================================");
		System.out.println("\t\t\t\t\t내정보");
		System.out.println("=====================================");
		
	}

	public static void adminInfoInput() {
		
		System.out.println("-------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이름 수정");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.println("-------------------------------------");
		
	}
	
}
