package com.project.admin.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.project.course.Course;
import com.project.course.CourseHistory;
import com.project.course.CourseHistoryData;
import com.project.user.data.DataMember;
import com.project.user.data.UserDbms;

public class AdminUserService {

	public static void showUserList() {

		UserDbms userDbms = new UserDbms(); // 데이터 로드

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
			int sel = -1;

			AdminUserView.printMemberList("조회");

			for (int i = 0; i < 10; i++) {
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
				sel = scan.nextInt();
				System.out.println();

				if (sel == 0) {
					inLoop = false;
					outLoop = false;

				} else if (sel == 1) {
					if (index == 10) {
						System.out.print("첫번째 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					index = (((index - 1) / 10) - 1) * 10; // 보여줄 일반 회원의 인덱스를 변경
					inLoop = false;

				} else if (sel == 2) {
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

		System.out.println("-------------------------------------");
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

		System.out.println("-------------------------------------"); // view로 빼야하나

//		System.out.println();
	}

	private static void printUserCourse(String memberCode) {

		ArrayList<String> courseNumList = new ArrayList<>();

		// for test
		Set<String> courseNumSet = new TreeSet<>();
		Map<String, Course> courseMap = new HashMap<>();

		// historyList 돌면서 객체 뽑아오기
		for (CourseHistory courseHistory : CourseHistoryData.historyList) {

			// 뽑아온 객체를 읽으면서 멤버코드가 같은지 확인하기
			if (courseHistory.getMemberNum().equals(memberCode)) {

				// 같으면 해당 강좌 코드 받아오기
				// 강좌코드를 ArrayList에 저장
				courseNumList.add(courseHistory.getCourseNum());

				// for test
				courseNumSet.add(courseHistory.getCourseNum());
//				courseMap = makeMap(courseMap,courseHistory.getCourseNum());
			}
		}

		System.out.println(courseNumList);
		System.out.println(courseNumSet);

		// courseList인 경우
//		for (String num : courseNumList) { // 강좌코드 하나씩 순회
////			System.out.println("num: " + num);
//
//			// ArrayList 순회하면서 강의 데이터에서 강의명 뽑아오기
//			for (Course c : CourseData.list) {
//				System.out.println(c.getCourseName());
//
//				// 강좌코드가 같다면
//				if (c.getNum().equals(num)) {
//
//					System.out.println("강좌코드가 같은 강의 찾음");
//					// 강좌명 출력
//					System.out.println(c.getNum() + ". " + c.getCourseName());
//				}
//
//			}
//
//		}

		int courseIdx = 1;
		// courseMap인 경우 - 순회 불필요
		for (String num : courseNumList) { // 강좌코드 하나씩 순회

			// map에서 강좌 데이터에 해당하는 강좌명 뽑아오기
			if (courseMap.containsKey(num)) {
				// 강좌코드가 같다면
				Course curCourse = courseMap.get(num);

				// 강좌명 출력
				System.out.println(courseIdx + ". " + curCourse.getNum() + ". " + curCourse.getCourseName());
				courseIdx++;
			}
		}
	}
//
//	private static HashMap<String, Course> makeMap(Map<String, Course> courseMap, String courseNum) {
//		HashMap<String, Course> map = new HashMap<>();
//
//		return map;
//	}

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

		while (true) {
			AdminUserView.printMemberList("검색"); // View에 추출하기

			System.out.println("0. 뒤로가기");
			System.out.println("1. 아이디로 검색");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 전화번호로 검색");
			System.out.println("-------------------------------------");
			System.out.print("번호를 입력하세요 : ");

			String sel = scan.nextLine(); // 유효화 과정 필요

			if (sel.equals("0")) {
				// 이전 화면으로 이동
				break;
			} else if (sel.equals("1")) {
				searchById();
			} else if (sel.equals("2")) {
				searchByName();
			} else if (sel.equals("3")) {
				searchByPhone();
			} else {
				System.out.print("유효하지 않은 입력입니다. 다시 입력해주세요. : ");
			}
		}

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
		boolean hasData = false;

		Scanner scan = new Scanner(System.in);

		AdminUserView.printSearchUserId();

		String inputId = scan.nextLine();

		// 입력받은 회원 아이디를 회원 리스트에서 검색하기
		ArrayList<DataMember> userList = UserDbms.getMemberAllList();

		for (DataMember m : userList) {
			System.out.println("m: " + m);
			// 있다면 - 회원 정보 보여주기
			if (m.getId().equals(inputId)) {
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

}
