package com.project.admin.user;

/**
 * 관리자 일반 회원 관리 부분의 출력을 담당하는 클래스입니다.
 * @author 황은하
 *
 */
public class AdminUserView {

	/**
	 * 한 줄을 출력하는 메소드입니다.
	 */
	static void printLine() {
		System.out.println("-------------------------------------");
	}

	/**
	 * 관리자의 일반 회원 관리 메인 화면을 출력하는 메소드입니다.
	 */
	public static void printAdminUserMain() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println("              일반 회원 관리");
		System.out.println("=====================================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 전체 회원 조회");
		System.out.println("2. 회원 검색");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	/**
	 * 유효하지 않은 입력을 알리는 메소드입니다.
	 */
	public static void printInvalidInput() {
		System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
	}

	/**
	 * 페이지 이동을 출력하는 메소드입니다.
	 */
	public static void printMovePage() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	/**
	 * 라벨에 따른 제목을 출력하는 메소드입니다.
	 * @param label
	 */
	static void printMemberListLabel(String label) {
		System.out.println("=====================================");
		System.out.println("            일반 회원 정보 " + label);
		System.out.println("=====================================");
	}

	/**
	 * 회원 아이디 검색 제목을 출력하는 메소드입니다.
	 */
	public static void printSearchUserId() {
		System.out.println("=====================================");
		System.out.println("            회원 아이디 검색");
		System.out.println("=====================================");
		System.out.print("아이디를 입력하세요. : ");
	}

	/**
	 * 회원 이름 검색 제목을 출력하는 메소드입니다.
	 */
	public static void printSearchUserName() {
		System.out.println("=====================================");
		System.out.println("            회원 이름 검색");
		System.out.println("=====================================");
		System.out.print("이름을 입력하세요. : ");
	}

	/**
	 * 수정을 하거나 탈퇴를 하기 위해서 번호를 입력받기 위해 정보를 출력하는 메소드입니다.
	 */
	public static void printUserSearch() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 회원정보 수정");
		System.out.println("2. 회원 탈퇴");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	/**
	 * 아이디나 이름으로 검색하기 위해서 번호를 입력받고자 정보를 출력하는 메소드입니다.
	 */
	public static void printUserSearchBy() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 아이디로 검색");
		System.out.println("2. 이름으로 검색");
		System.out.println("-------------------------------------");
		System.out.print("번호를 입력하세요 : ");
	}

	/**
	 * 회원 정보 수정 화면을 출력하는 메소드입니다.
	 */
	public static void printUserDataModify() {
		System.out.println("=====================================");
		System.out.println("            회원 정보 수정");
		System.out.println("=====================================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이름");
		System.out.println("2. 전화번호");
		System.out.println("3. 할인대상 여부");
		System.out.println("4. 계좌번호");
		System.out.println("-------------------------------------");
		System.out.println("회원 정보를 수정합니다.");
		System.out.println("수정하고 싶은 항목 번호를 입력해주세요.");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력: ");
	}

	/**
	 * 회원 탈퇴 제목을 출력하는 메소드입니다.
	 */
	public static void printUserDeleteLabel() {
		System.out.println("=====================================");
		System.out.println("              회원 탈퇴");
		System.out.println("=====================================");
	}
}
