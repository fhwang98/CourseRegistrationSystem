package com.project.admin.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.course.CourseHistory;
import com.project.course.CourseHistoryData;
import com.project.courseinfo.Course;
import com.project.courseinfo.CourseData;
import com.project.user.data.DataMember;
import com.project.user.data.UserDbms;

public class AdminUserService {

	public static void showUserList() {

		// 페이지 출력
		// 10명씩 보여주기
		// 10명이 다 출력된 뒤 페이지 이동하는 화면 출력
		// 0을 입력하면 이전 메인 페이지로 이동

		int index = 0;
		boolean outLoop = true;
		boolean inLoop = true;

		Scanner scan = new Scanner(System.in);

		while (outLoop) {

			inLoop = true;
			String sel = null;

			AdminUserView.printMemberListLabel("조회");

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

				sel = scan.nextLine();
				System.out.println();

				if (sel.equals("0")) {
					System.out.println("이전 화면으로 이동합니다.");
					System.out.println("계속 하시려면 엔터키를 입력해주세요.");
					scan.nextLine();
					
					inLoop = false;
					outLoop = false;

				} else if (sel.equals("1")) {
					if (index == 10) {
						System.out.print("첫번째 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					index = (((index - 1) / 10) - 1) * 10; // 보여줄 일반 회원의 시작 인덱스를 변경
					inLoop = false;

				} else if (sel.equals("2")) {
					if (index == UserDbms.getMemberAllList().size()) {
						System.out.print("마지막 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					inLoop = false;

				} else {
					System.out.print("잘못된 입력입니다. 다시 입력하세요. : ");
				}
			}

		}

		AdminUserView.printLine();
	}

	public static void printMemberData(DataMember m) {
		System.out.println("회원번호: " + m.getMemberCode());
		System.out.println("이름: " + m.getName());
		System.out.println("아이디: " + m.getId());
		System.out.println("생년월일: " + m.getBirth());
		System.out.println("전화번호: " + m.getTel());

		String discountType = checkDiscountType(m);
		System.out.println("할인: " + discountType);

		System.out.println("환불 은행: " + m.getRefundBank());
		System.out.println("환불 계좌번호: " + m.getRefundAccountNum());

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

		Scanner scan = new Scanner(System.in);

		boolean outLoop = true;
		boolean innerLoop = true;

		while (outLoop) {
			innerLoop = true;

			AdminUserView.printMemberListLabel("검색");
			AdminUserView.printUserSearchBy();

			while (innerLoop) {

				String sel = scan.nextLine(); // 유효화 과정 필요
				System.out.println();

				if (sel.equals("0")) { // 뒤로가기
					System.out.println("이전 화면으로 이동합니다.");
					System.out.println("계속 하시려면 엔터키를 입력해주세요.");
					scan.nextLine();
					
					// 이전 화면으로 이동
					innerLoop = false;
				} else if (sel.equals("1")) { // 아이디로 검색

					searchById();

//					AdminUserView.printLine();
//					AdminUserView.printMemberListLabel("검색"); // View에 추출하기
//					AdminUserView.printUserSearchBy();

					innerLoop = false;
					outLoop = false;

				} else if (sel.equals("2")) { // 이름으로 검색

					searchByName();

//					AdminUserView.printLine();
//					AdminUserView.printMemberListLabel("검색"); // View에 추출하기
//					AdminUserView.printUserSearchBy();
					
					innerLoop = false;
					outLoop = false;
				} else {
					System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
				}
			}

			if (!innerLoop) {
				break;
			}
		}
	}

	private static void searchByName() {

		// 회원 이름 검색 문자열 출력
		AdminUserView.printSearchUserName();

		Scanner scan = new Scanner(System.in);

		String inputName = scan.nextLine();

		AdminUserView.printLine();

		// 입력받은 회원 이름을 회원 리스트에서 검색하기

		DataMember curMember = AdminUserService.getMemberObjectByName(inputName);

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
			// 새 이름 입력
			String inputSearch = scan.nextLine();

			if (inputSearch.equals("0")) { // 이전 메인 화면으로 이동
				return;
			} else if (inputSearch.equals("1")) { // 수정
				AdminUserService.modifyMember(curMember);

				// 바뀐 일반 회원의 정보 보여줌
				AdminUserView.printMemberListLabel("조회");
//				System.out.println("inputName: "+inputName);

//				DataMember changedMember = AdminUserService.getMemberObjectByName(inputName);
//				AdminUserService.printMemberData(changedMember);

//						AdminUserView.printUserSearch();

				// 추가
				return;
				
			} else if (inputSearch.equals("2")) { // 삭제
				curMember = AdminUserService.getMemberObjectByName(inputName); // 변경된 데이터 리로드

				if (curMember.getUsing() == 1) { // 이미 탈퇴한 회원인 경우
					System.out.println("이미 탈퇴한 회원입니다.");
					System.out.print("번호를 다시 입력해주세요. : ");
					continue;
				}

				// 탈퇴하지 않은 회원인 경우
				AdminUserService.deleteMember(curMember);

				AdminUserView.printMemberListLabel("조회");
				DataMember changedMember = AdminUserService.getMemberObjectByName(inputName);
				AdminUserService.printMemberData(changedMember);

//						AdminUserView.printUserSearch();

				return;

			} else {
				AdminUserView.printInvalidInput(); // 다시 입력받기
			}
		}
	}

	private static void searchById() {
		// 회원 아이디 검색 문자열 출력
		AdminUserView.printSearchUserId();

		Scanner scan = new Scanner(System.in);

		String inputId = scan.nextLine();

		AdminUserView.printLine();

		// 입력받은 회원 아이디를 회원 리스트에서 검색하기

		DataMember curMember = AdminUserService.getMemberObjectById(inputId);

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

			if (inputSearch.equals("0")) { // 이전 메인 화면으로 이동
				System.out.println("이전 화면으로 이동합니다.");
				System.out.println("계속 하시려면 엔터키를 입력해주세요.");
				scan.nextLine();
				
				return;
			} else if (inputSearch.equals("1")) { // 수정
				AdminUserService.modifyMember(curMember);

				// 바뀐 일반 회원의 정보 보여줌
				AdminUserView.printMemberListLabel("조회");
				DataMember changedMember = AdminUserService.getMemberObjectById(inputId);
				AdminUserService.printMemberData(changedMember);

//				AdminUserView.printUserSearch();

				// 추가
				return;
			} else if (inputSearch.equals("2")) { // 삭제
				curMember = AdminUserService.getMemberObjectById(inputId); // 변경된 데이터 리로드

				if (curMember.getUsing() == 1) { // 이미 탈퇴한 회원인 경우
					System.out.println("이미 탈퇴한 회원입니다.");
					System.out.print("번호를 다시 입력해주세요. : ");
					continue;
				}

				// 탈퇴하지 않은 회원인 경우
				AdminUserService.deleteMember(curMember);

				AdminUserView.printMemberListLabel("조회");
				DataMember changedMember = AdminUserService.getMemberObjectById(inputId);
				AdminUserService.printMemberData(changedMember);

//				AdminUserView.printUserSearch();

				return;

			} else {
				AdminUserView.printInvalidInput(); // 다시 입력받기
			}
		}

	}

	private static DataMember getMemberObjectByName(String inputName) {
		ArrayList<DataMember> userList = UserDbms.getMemberAllList();

		DataMember curMember = null;

		for (DataMember m : userList) {
			// 있다면 - 해당 회원 객체 뽑아오기
			if (m.getName().equals(inputName)) {
				curMember = m;
				break;
			}
		}

		return curMember;
	}

	private static DataMember getMemberObjectById(String inputId) {
		ArrayList<DataMember> userList = UserDbms.getMemberAllList();

		DataMember curMember = null;

		for (DataMember m : userList) {
			// 있다면 - 해당 회원 객체 뽑아오기
			if (m.getId().equals(inputId)) {
				curMember = m;
				break;
			}
		}

		return curMember;
	}

	private static void deleteMember(DataMember m) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			AdminUserView.printUserDeleteLabel();

			System.out.println("회원번호: " + m.getMemberCode());
			System.out.println("이름: " + m.getName());
			System.out.println("아이디: " + m.getId());
			AdminUserView.printLine();
			System.out.println("회원의 상태를 탈퇴 회원으로 변경합니다.");
			System.out.print("변경하시겠습니까? (y/n) : ");

			String input = scan.nextLine();

			input = changeValidInput(input);

			if (input.equals("Y")) {
				// 삭제
				// 파일 읽기
				// 해당하는 회원 번호를 list에서 조회
				// 마지막 값인 Using 값을 1로 변경한다.
				// 해당 파일들을 합쳐 하나의 문자열로 변경한다.
				// stringbuilder에 붙인다.
				// 파일 읽기가 끝난다
				// 파일 쓰기
				// stringbuilder로 파일을 작성한다
				// 데이터를 리로드한다.

				// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
				AdminUserService.changeUserUsingFile(m.getMemberCode());

				System.out.println();
				System.out.println("수정이 완료되었습니다.");
				System.out.println("계속하려면 엔터를 입력해주세요.");
				scan.nextLine();

				break;
			} else if (input.equals("N")) {
				printBackToBeforePage(scan);

				break;
			} else {
				AdminUserView.printInvalidInput();
			}
		}

	}

	private static void changeUserUsingFile(String memberCode) {
		try {
			String path = "data/dataMember.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");

				String curMemberCode = temp[0];

				// 찾았다면
				if (curMemberCode.equals(memberCode)) {

					// 찾으면 유저의 using을 1로 수정하기
					temp[temp.length - 1] = "1";
				}

				DataMember changeMember = new DataMember(); // 새로운 객체 생성

				changeMember.setDataMemeber(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식

				sb.append(changeMember.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장

			}

			reader.close(); // reader 끝

			// 파일에 작성하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			writer.write(sb.toString()); // 읽어온 모든 데이터를 파일에 쓰기

			writer.close(); // writer 끝

			// 데이터를 리로드하기
			UserDbms reLoadMember = new UserDbms();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void modifyMember(DataMember m) {
		AdminUserView.printUserDataModify();

		Scanner scan = new Scanner(System.in);

		while (true) {

			String sel = scan.nextLine();

			if (sel.equals("0")) {
				break;

			} else if (sel.equals("1")) { // 이름 수정
				boolean isInValid = modifyMemberName(m, scan);
				if (isInValid) {
					continue;
				}
				break;

			} else if (sel.equals("2")) { // 전화번호
				boolean isInValid = modifyMemberTel(m, scan);
				if (isInValid) {
					continue;
				}
				break;

			} else if (sel.equals("3")) { // 할인대상 여부
				boolean isInValid = modifyMemberDiscount(m, scan);
				if (isInValid) {
					continue;
				}
				break;

			} else if (sel.equals("4")) { // 계좌번호
				boolean isInValid = modifyMemberAccount(m, scan);
				if (isInValid) {
					continue;
				}
				break;

			} else {
				AdminUserView.printInvalidInput();
			}
		}

	}

	private static boolean modifyMemberAccount(DataMember m, Scanner scan) {
		boolean invalid = false;

		String input;
		System.out.print("아이디(" + m.getId() + ") 회원의 계좌 정보를 수정하시겠습니까? (y/n) : ");
		input = scan.nextLine();
		input = changeValidInput(input); // trim + upperCase

		if (input.equals("Y")) { // 수정할 경우
			AdminUserView.printLine();

			System.out.print("환불받을 은행을 입력해주세요. : ");
			String newBank = scan.nextLine();

			System.out.print("환불받을 계좌번호를 입력해주세요. : ");
			String newAccount = scan.nextLine();

			AdminUserView.printLine();

			// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
			AdminUserService.changeUserAccountFile(m.getMemberCode(), newBank, newAccount);

			System.out.println();
			System.out.println("수정이 완료되었습니다.");
			System.out.println("계속하려면 엔터를 입력해주세요.");
			scan.nextLine();

		} else if (input.equals("N")) {// 수정하지 않을 경우
			// 회원 아이디 검색 화면으로 이동 (이전 페이지)
			// 작성하기
			printBackToBeforePage(scan);
		} else { // 유효하지 않은 입력
			AdminUserView.printInvalidInput();
			invalid = true;
		}
		return invalid;
	}

	private static void changeUserAccountFile(String memberCode, String newBank, String newAccount) {
		try {
			String path = "data/dataMember.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");
				String curMemberCode = temp[0];

				// 찾았다면
				if (curMemberCode.equals(memberCode)) {

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[7] = newBank;
					temp[8] = newAccount;
				}

				DataMember changeMember = new DataMember(); // 새로운 객체 생성
				changeMember.setDataMemeber(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식
				sb.append(changeMember.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장
			}

			reader.close(); // reader 끝

			// 파일에 작성하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString()); // 읽어온 모든 데이터를 파일에 쓰기
			writer.close(); // writer 끝

			// 데이터를 리로드하기
			UserDbms reLoadMember = new UserDbms();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static boolean modifyMemberDiscount(DataMember m, Scanner scan) {
		boolean invalid = false;

		String input;
		System.out.print("아이디(" + m.getId() + ") 회원의 할인대상여부를 수정하시겠습니까? (y/n) : ");
		input = scan.nextLine();
		input = changeValidInput(input); // trim + upperCase

		if (input.equals("Y")) { // 수정할 경우
			AdminUserView.printLine();

			System.out.println("1. 국가유공자(본인)");
			System.out.println("2. 국민기초생활보장수급자");
			System.out.println("3. 다자녀가정");
			System.out.println("4. 해당 없음");

			AdminUserView.printLine();

			System.out.println("새로운 할인대상여부 번호를 입력해주세요.");
			System.out.print("번호 : ");

			input = scan.nextLine();

			input = changeInputTrim(input); // trim + 추가 한글인지 유효성 검사 하는 작업 필요

			// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
			AdminUserService.changeUserDiscountFile(m.getMemberCode(), input);

			System.out.println();
			System.out.println("수정이 완료되었습니다.");
			System.out.println("계속하려면 엔터를 입력해주세요.");
			scan.nextLine();

		} else if (input.equals("N")) {// 수정하지 않을 경우
			// 회원 아이디 검색 화면으로 이동 (이전 페이지)
			// 작성하기
			printBackToBeforePage(scan);

		} else { // 유효하지 않은 입력
			AdminUserView.printInvalidInput();
			invalid = true;
		}
		return invalid;
	}

	private static void changeUserDiscountFile(String memberCode, String input) {

		try {
			String path = "data/dataMember.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");
				String curMemberCode = temp[0];

				// 찾았다면
				if (curMemberCode.equals(memberCode)) {

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[6] = input;
				}

				DataMember changeMember = new DataMember(); // 새로운 객체 생성
				changeMember.setDataMemeber(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식
				sb.append(changeMember.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장
			}

			reader.close(); // reader 끝

			// 파일에 작성하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString()); // 읽어온 모든 데이터를 파일에 쓰기
			writer.close(); // writer 끝

			// 데이터를 리로드하기
			UserDbms reLoadMember = new UserDbms();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static boolean modifyMemberTel(DataMember m, Scanner scan) {
		boolean invalid = false;

		String input;
		System.out.print("아이디(" + m.getId() + ") 회원의 전화번호를 수정하시겠습니까? (y/n) : ");
		input = scan.nextLine();
		input = changeValidInput(input); // trim + upperCase

		if (input.equals("Y")) { // 수정할 경우
			AdminUserView.printLine();

			System.out.println("새로운 전화번호을 입력해주세요.");
			System.out.print("전화번호: ");

			input = scan.nextLine();

			input = changeInputTrim(input); // trim + 추가 한글인지 유효성 검사 하는 작업 필요

			// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
			AdminUserService.changeUserTelFile(m.getMemberCode(), input);

			System.out.println();
			System.out.println("수정이 완료되었습니다.");
			System.out.println("계속하려면 엔터를 입력해주세요.");
			scan.nextLine();

		} else if (input.equals("N")) {// 수정하지 않을 경우
			// 회원 아이디 검색 화면으로 이동 (이전 페이지)
			// 작성하기
			printBackToBeforePage(scan);

		} else { // 유효하지 않은 입력
			AdminUserView.printInvalidInput();
			invalid = true;
		}
		return invalid;
	}

	private static void changeUserTelFile(String memberCode, String input) {
		try {
			String path = "data/dataMember.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");
				String curMemberCode = temp[0];

				// 찾았다면
				if (curMemberCode.equals(memberCode)) {

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[4] = input;
				}

				DataMember changeMember = new DataMember(); // 새로운 객체 생성
				changeMember.setDataMemeber(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식
				sb.append(changeMember.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장
			}

			reader.close(); // reader 끝

			// 파일에 작성하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString()); // 읽어온 모든 데이터를 파일에 쓰기
			writer.close(); // writer 끝

			// 데이터를 리로드하기
			UserDbms reLoadMember = new UserDbms();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static boolean modifyMemberName(DataMember m, Scanner scan) {
		boolean invalid = false;

		String sel;
		System.out.print("아이디(" + m.getId() + ") 회원의 이름을 수정하시겠습니까? (y/n) : ");
		sel = scan.nextLine();
		sel = changeValidInput(sel); // trim + upperCase

		if (sel.equals("Y")) { // 수정할 경우
			AdminUserView.printLine();

			System.out.println("새로운 이름을 입력해주세요.");
			System.out.print("이름: ");

			sel = scan.nextLine();

			sel = changeInputTrim(sel); // trim + 추가 한글인지 유효성 검사 하는 작업 필요

			// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
			AdminUserService.changeUserNameFile(m.getMemberCode(), sel);

			System.out.println();
			System.out.println("수정이 완료되었습니다.");
			System.out.println("계속하려면 엔터를 입력해주세요.");
			scan.nextLine();

		} else if (sel.equals("N")) {// 수정하지 않을 경우
			// 회원 아이디 검색 화면으로 이동 (이전 페이지)
			// 작성하기
			printBackToBeforePage(scan);

		} else { // 유효하지 않은 입력
			AdminUserView.printInvalidInput();
			invalid = true;
		}
		return invalid;
	}

	private static void printBackToBeforePage(Scanner scan) {
		System.out.println("취소를 선택했습니다.");
		System.out.println("이전 화면으로 돌아갑니다.");
		System.out.println("계속 하려면 엔터를 입력해주세요.");
		scan.nextLine();
	}

	private static void changeUserNameFile(String memberCode, String newName) {

		try {

			String path = "data/dataMember.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");

				String curMemberCode = temp[0];

				// 찾았다면
				if (curMemberCode.equals(memberCode)) {

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[3] = newName;
				}

				DataMember changeMember = new DataMember(); // 새로운 객체 생성

				changeMember.setDataMemeber(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식

				sb.append(changeMember.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장

			}

			reader.close(); // reader 끝

			// 파일에 작성하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			writer.write(sb.toString()); // 읽어온 모든 데이터를 파일에 쓰기

			writer.close(); // writer 끝

			// 데이터를 리로드하기
			UserDbms reLoadMember = new UserDbms();

		} catch (Exception e) {
			// TODO: handle exception
		}

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
