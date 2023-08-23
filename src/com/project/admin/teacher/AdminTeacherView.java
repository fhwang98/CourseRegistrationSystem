package com.project.admin.teacher;

public class AdminTeacherView {

	public static void printAdminTeacherMain() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println("              강사 회원 관리");
		System.out.println("=====================================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 전체 회원 조회");
		System.out.println("2. 회원 검색");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	public static void printTeacherListLabel(String label) {
		System.out.println("=====================================");
		System.out.println("            강사 회원 정보 " + label);
		System.out.println("=====================================");
	}

	public static void printLine() {
		System.out.println("-------------------------------------");
	}

	public static void printMovePage() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이전 페이지");
		System.out.println("2. 다음 페이지");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	public static void printTeacherSearchBy() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 아이디로 검색");
		System.out.println("2. 이름으로 검색");
		System.out.println("-------------------------------------");
		System.out.print("번호를 입력하세요 : ");
	}

	public static void printSearchTeacherId() {
		System.out.println("=====================================");
		System.out.println("            강사 아이디 검색");
		System.out.println("=====================================");
		System.out.print("아이디를 입력하세요. : ");
	}

	public static void printTeacherSearch() {
		System.out.println("0. 뒤로가기");
		System.out.println("1. 회원정보 수정");
		System.out.println("2. 회원 탈퇴");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력 : ");
	}

	public static void printTeacherDataModify() {
		System.out.println("=====================================");
		System.out.println("            강사 정보 수정");
		System.out.println("=====================================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이름");
		System.out.println("2. 전화번호");
		System.out.println("-------------------------------------");
		System.out.println("회원 정보를 수정합니다.");
		System.out.println("수정하고 싶은 항목 번호를 입력해주세요.");
		System.out.println("-------------------------------------");
		System.out.print("번호 입력: ");
	}

	public static void printInvalidInput() {
		System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
	}

	public static void printSearchTeacherName() {
		System.out.println("=====================================");
		System.out.println("            강사 이름 검색");
		System.out.println("=====================================");
		System.out.print("이름을 입력하세요. : ");
	}

}
