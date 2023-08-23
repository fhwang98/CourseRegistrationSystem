package com.project.admin.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.project.course.CourseHistory;
import com.project.course.CourseHistoryData;
import com.project.courseinfo.Course;
import com.project.courseinfo.CourseData;
import com.project.user.data.DataMember;
import com.project.user.data.UserDbms;

public class AdminUserService {

	public static void showUserList() {
//		System.out.println("showUserList 시작");

//		UserDbms userDbms = new UserDbms(); // 데이터 로드

		// 페이지 출력
		// 10명씩 보여주기
		// 10명이 다 출력된 뒤 페이지 이동하는 화면 출력
		// 0을 입력하면 이전 메인 페이지로 이동

		int index = 0;
		boolean outLoop = true;
		boolean inLoop = true;

		Scanner scan = new Scanner(System.in);

		while (outLoop) {
//			System.out.println("showUserList outLoop 시작");

			inLoop = true;
			String sel = null;

			AdminUserView.printMemberList("조회");

			for (int i = 0; i < 10; i++) { // 10개씩 출력
				if (index == UserDbms.getMemberAllList().size()) { // 멈춰야 한다! 다 출력함
					break;
				}

				// 일반 회원 객체 가져오기
				DataMember m = UserDbms.getMemberAllList().get(index);

				// 회원 데이터 출력
				AdminUserService.printMemberData(m);

				index++;
			}

			// 페이지 이동 안내 라벨 출력
			AdminUserView.printMovePage();

			while (inLoop) {
//				System.out.println("showUserList inLoop 시작");

				sel = scan.nextLine();
				System.out.println();

				if (sel.equals("0")) {
//					System.out.println("showUserList inLoop - 0 입력");
					inLoop = false;
					outLoop = false;

				} else if (sel.equals("1")) {
//					System.out.println("showUserList inLoop - 1 입력");
					if (index == 10) {
						System.out.print("첫번째 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					index = (((index - 1) / 10) - 1) * 10; // 보여줄 일반 회원의 시작 인덱스를 변경
					inLoop = false;

				} else if (sel.equals("2")) {
//					System.out.println("showUserList inLoop - 2 입력");
					if (index == UserDbms.getMemberAllList().size()) {
						System.out.print("마지막 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					inLoop = false;

				} else {
//					System.out.println("showUserList inLoop - invalid 입력");
					System.out.print("잘못된 입력입니다. 다시 입력하세요. : ");
				}
//				System.out.println("showUserList inLoop 끝");
			}

//			System.out.println("showUserList outLoop 끝");
		}

		AdminUserView.printLine();

//		System.out.println("showUserList 끝");
	}

	public static void printMemberData(DataMember m) {
		System.out.println("회원번호: " + m.getMemberCode());
		System.out.println("이름: " + m.getName());
		System.out.println("아이디: " + m.getId());
		System.out.println("생년월일: " + m.getBirth());
		System.out.println("전화번호: " + m.getTel());

		String discountType = checkDiscountType(m);
		System.out.println("할인: " + discountType);

		// 전체 수강 내역 읽고 회원 코드와 일치하는 수강명만 보여주기 (추가할 것)
		System.out.println("수강내역: ");

		AdminUserService.printUserCourse(m.getMemberCode());

		String withdrawal = (m.getUsing() == 0) ? "X" : "O";
		System.out.println("탈퇴 여부: " + withdrawal);

		AdminUserView.printLine();
	}

	private static void printUserCourse(String memberCode) {

		// 현재 유저가 수강중인 강좌 코드들을 담은 리스트
		ArrayList<String> courseNumList = new ArrayList<>();

		// historyList 돌면서 회원 수강 내역 객체 뽑아오기 -> courseNumList에 수강중인 강좌 코드 저장하기
		for (CourseHistory courseHistory : CourseHistoryData.historyList) {

			// 뽑아온 객체를 읽으면서 멤버코드가 같은지 확인하기
			if (courseHistory.getMemberNum().equals(memberCode)) {

				// 같으면 해당 강좌 코드 받아오기
				// 강좌코드를 ArrayList에 저장
				courseNumList.add(courseHistory.getCourseNum());
			}
		}

		// 수강 내역이 없을 경우
		if (courseNumList.size() == 0) {
			System.out.println("\t없음");
			return;
		}

		// courseList인 경우
		for (String curCourseNum : courseNumList) { // 강좌코드 하나씩 순회

			// 강좌 데이터에 현재 강좌 번호가 없는 경우
			if (!CourseData.map.containsKey(curCourseNum)) {
				break;
			}

			// 강좌 맵에서 현재 강좌 코드 검색
			Course curCourse = CourseData.map.get(curCourseNum); // 현재 강좌 객체

			// 현재 강좌의 코드와 이름을 출력하기
			System.out.println(" - " + curCourse.getNum() + " " + curCourse.getCourseName());
		}
	}

	private static String checkDiscountType(DataMember m) {
		String discountType = "";

		if (m.getDiscount() == 1) {
			discountType = "국가유공자";
		} else if (m.getDiscount() == 2) {
			discountType = "국민기초생활보장수급자";
		} else if (m.getDiscount() == 2) {
			discountType = "다자녀가정";
		} else {
			discountType = "해당없음";
		}

		return discountType;
	}

	public static void searchUser() {
//		System.out.println("searchUser 시작");

		Scanner scan = new Scanner(System.in);
		boolean innerLoop = true;

		while (true) {
//			System.out.println("searchUser outLoop 시작");
			innerLoop = true;

			AdminUserView.printMemberList("검색"); // View에 추출하기

			AdminUserView.printUserSearchBy();

			while (innerLoop) {
//				System.out.println("searchUser innerLoop 시작");

				String sel = scan.nextLine(); // 유효화 과정 필요
				System.out.println();

				if (sel.equals("0")) {
//					System.out.println("searchUser innerLoop - 0 입력");

					// 이전 화면으로 이동
					innerLoop = false;
//					return;
				} else if (sel.equals("1")) {
//					System.out.println("searchUser innerLoop - 1 입력");

					searchById();
					AdminUserView.printLine();
					AdminUserView.printUserSearchBy();

				} else if (sel.equals("2")) {
//					System.out.println("searchUser innerLoop - 2 입력");
					searchByName();
					AdminUserView.printLine();
					AdminUserView.printUserSearchBy();
				} else if (sel.equals("3")) {
//					System.out.println("searchUser innerLoop - 3 입력");
					searchByPhone();

					AdminUserView.printLine();
					AdminUserView.printUserSearchBy();
				} else {
//					System.out.println("searchUser innerLoop - invalid 입력");
					System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
				}

//				System.out.println("searchUser innerLoop 끝");
			}

			if (!innerLoop) {
				break;
			}

//			System.out.println("searchUser outLoop 끝");

		}
//		System.out.println("searchUser 끝");
	}

	private static void searchByPhone() {
		System.out.print("전화번호를 입력하세요. : ");

	}

	private static void searchByName() {
		boolean hasData = false;

		Scanner scan = new Scanner(System.in);

		AdminUserView.printSearchUserName();

		String inputName = scan.nextLine();

		// 입력받은 회원 아이디를 회원 리스트에서 검색하기
		ArrayList<DataMember> userList = UserDbms.getMemberAllList();

		for (DataMember m : userList) {

			// 있다면 - 회원 정보 보여주기
			if (m.getName().equals(inputName)) {
				AdminUserService.printMemberData(m); // 찾은 회원 객체 데이터 출력
				hasData = true;
			}
		}

		// 없다면 - 검색결과가 없습니다. 계속하려면 엔터를 입력해주세요. -> 회원 검색 화면(이전 화면)으로 돌아가기
		if (!hasData) {
			System.out.println("검색 결과가 없습니다.");
			System.out.println("계속 하려면 엔터를 입력해주세요.");
			scan.nextLine();
		}

	}

	private static void searchById() {
		// 회원 아이디 검색 문자열 출력
		AdminUserView.printSearchUserId();

		Scanner scan = new Scanner(System.in);

		String inputId = scan.nextLine();
		AdminUserView.printLine();

		// 입력받은 회원 아이디를 회원 리스트에서 검색하기
		ArrayList<DataMember> userList = UserDbms.getMemberAllList();

		DataMember curMember = null;

		for (DataMember m : userList) {
			// 있다면 - 해당 회원 객체 뽑아오기
			if (m.getId().equals(inputId)) {
				curMember = m;
				break;
			}
		}

		// 없다면 - 검색결과가 없습니다. 계속하려면 엔터를 입력해주세요. -> 회원 검색 화면(이전 화면)으로 돌아가기
		if (curMember == null) {
			System.out.println("검색 결과가 없습니다.");
			System.out.println("계속 하려면 엔터를 입력해주세요.");
			scan.nextLine();
			AdminUserView.printLine();
			return;
		}

		// 찾은 회원 객체 데이터 출력
		AdminUserService.printMemberData(curMember);

		// 페이지 이동 라벨 출력
		AdminUserView.printUserSearch();

		while (true) {
			String inputSearch = scan.nextLine();
//			System.out.println();

			if (inputSearch.equals("0")) { // 이전 메인 화면으로 이동
				return;
			} else if (inputSearch.equals("1")) {
				AdminUserService.modifyMember(curMember);
				AdminUserView.printLine();
				AdminUserView.printUserSearch();
			} else if (inputSearch.equals("2")) {
				AdminUserService.deleteMember(curMember);
				AdminUserView.printLine();
				AdminUserView.printUserSearch();
			} else {
				AdminUserView.printInvalidInput(); // 다시 입력받기
			}
		}

	}

	private static void deleteMember(DataMember m) {
		// TODO Auto-generated method stub

	}

	private static void modifyMember(DataMember m) {
		AdminUserView.printUserDataModify();

		Scanner scan = new Scanner(System.in);

		String sel = scan.nextLine();

		if (sel.equals("0")) {

		} else if (sel.equals("1")) { // 이름 수정
			System.out.print("아이디(" + m.getId() + ") 회원의 이름을 수정하시겠습니까? (y/n) : ");
			sel = scan.nextLine();
			sel = changeValidInput(sel); // trim + upperCase

			if (sel.equals("Y")) { // 수정할 경우
				AdminUserView.printLine();
				System.out.println("새로운 이름을 입력해주세요.");
				System.out.print("이름: ");
				sel = scan.nextLine();
				System.out.println(sel);
				sel = changeInputTrim(sel); // trim + 추가 한글인지 유효성 검사 하는 작업 필요
				System.out.println("changed name: " + sel);

				// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
				AdminUserService.changeUserNameFile(m.getMemberCode(), sel);

				System.out.println();
				System.out.println("수정이 완료되었습니다.");
				System.out.println("계속하려면 엔터를 입력해주세요.");
				scan.nextLine();

			} else { // 수정하지 않을 경우
				// 회원 아이디 검색 화면으로 이동 (이전 페이지)
				AdminUserView.printInvalidInput();
			}

		} else if (sel.equals("2")) { // 전화번호

		} else if (sel.equals("3")) { // 할인대상 여부

		} else if (sel.equals("4")) { // 계좌번호

		} else {

		}
	}

	private static void changeUserNameFile(String memberCode, String newName) {

		System.out.println("changeUserNameFile 시작");
		try {
			System.out.println("changeUserNameFile try 시작");

			String path = "data\\dataMember.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();
			System.out.println("sb: " + sb);

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {
//				System.out.println("read line");
//				System.out.println(line);
//
//				// 해당 유저 코드 찾기
				String[] temp = line.split(",");
//				System.out.println(Arrays.toString(temp));
//
				String curMemberCode = temp[0];
//				System.out.println(curMemberCode);
//
//				// 찾았다면
				if (curMemberCode.equals(memberCode)) {

//					System.out.println(temp[3]);

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[3] = newName;
//					System.out.println("temp[3]: " + temp[3]);

//					System.out.println(Arrays.toString(temp));
				}

				DataMember changeMember = new DataMember();

				changeMember.setDataMemeber(temp);

				System.out.println(changeMember.toString());

				sb.append(changeMember.toString() + "\r\n");
				
//				System.out.println(sb.toString()); 

			}

//			System.out.println(sb.toString());

			reader.close();

			System.out.println();
			
			// 파일에 작성하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			writer.write(sb.toString());

			writer.close();

			System.out.println("old UserDbms\r\n" + UserDbms.getMemberAllList());
			System.out.println();

			// 데이터를 리로드하기
			UserDbms reLoadMember = new UserDbms();
			
			System.out.println("new UserDbms\r\n" + UserDbms.getMemberAllList());

		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("changeUserNameFile 끝");
	}

	private static String changeValidInput(String sel) {
		sel = changeInputTrim(sel);
		return changeInputUpper(sel);
	}

	private static String changeInputUpper(String sel) {
		return sel.toUpperCase();
	}

	private static String changeInputTrim(String sel) {
		return sel.trim();
	}

}
