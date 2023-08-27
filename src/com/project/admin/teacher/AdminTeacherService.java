package com.project.admin.teacher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.admin.user.AdminUserService;
import com.project.admin.user.AdminUserView;
import com.project.courseinfo.Course;
import com.project.courseinfo.CourseData;
import com.project.user.data.DataMember;
import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;

/**
 * 관리자의 강사 회원 관리 기능을 담당하는 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class AdminTeacherService {

	/**
	 * 강사 회원의 리스트를 보여주는 메소드입니다.
	 */
	public static void showTeacherList() {

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

			AdminTeacherView.printTeacherListLabel("조회");

			for (int i = 0; i < 10; i++) { // 10개씩 출력
				if (index == UserDbms.getTeacherAllList().size()) { // 멈춰야 한다! 다 출력함
					break;
				}

				// 강사 회원 객체 가져오기
				DataTeacher t = UserDbms.getTeacherAllList().get(index);

				// 강사 회원 데이터 출력
				AdminTeacherService.printTeacherData(t);

				index++;
			}

			// 페이지 이동 안내 라벨 출력
			AdminTeacherView.printMovePage();

			while (inLoop) {

				sel = scan.nextLine();
				System.out.println();

				if (sel.equals("0")) {
					printGoToBeforePage(scan);

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
					if (index == UserDbms.getTeacherAllList().size()) {
						System.out.print("마지막 페이지 입니다. 다시 입력하세요. : ");
						continue;
					}
					inLoop = false;

				} else {
					System.out.print("잘못된 입력입니다. 다시 입력하세요. : ");
				}
			}

		}

		AdminTeacherView.printLine();
	}

	/**
	 * 이전 화면으로 이동한다는 안내를 출력하고 엔터를 입력받는 메소드입니다.
	 * 
	 * @param scan
	 */
	private static void printGoToBeforePage(Scanner scan) {
		System.out.println("이전 화면으로 이동합니다.");
		System.out.println("계속 하시려면 엔터키를 입력해주세요.");
		scan.nextLine();
	}

	/**
	 * 강사 회원 세부 정보를 보여주는 메소드입니다.
	 * 
	 * @param t 강사 회원 객체
	 */
	private static void printTeacherData(DataTeacher t) {
		System.out.println("회원번호: " + t.getTeacherCode());
		System.out.println("이름: " + t.getName());
		System.out.println("아이디: " + t.getId());
		System.out.println("생년월일: " + t.getBirth());
		System.out.println("전화번호: " + t.getTel());

		// 전체 수강 내역 읽고 강사 코드와 일치하는 강좌명만 보여주기 (추가할 것)
		System.out.println("개설강좌: ");

		AdminTeacherService.printTeacherCourse(t.getTeacherCode());

		String withdrawal = (t.getUsing() == 0) ? "X" : "O";
		System.out.println("탈퇴 여부: " + withdrawal);

		AdminTeacherView.printLine();
	}

	/**
	 * 현재 강ㅇ사 회원이 개설하거나 개설했던 강좌를 출력하는 메소드입니다.
	 * 
	 * @param teacherCode 강사 회원 번호
	 */
	private static void printTeacherCourse(String teacherCode) {

		// 현재 강사가 열었던 강좌 코드들을 담은 리스트
		ArrayList<String> courseNumList = new ArrayList<>();

		// courseList 순회
		for (Course c : CourseData.courseList) {

			// 강사코드 같은 강좌 찾기
			if (c.getTeacherNum().equals(teacherCode)) {
				// 같은 경우
				// 강좌리스트에 강좌코드 넣기
				courseNumList.add(c.getNum());
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

	/**
	 * 강사 회원 검색 기능을 구현하는 메소드입니다.
	 */
	public static void searchTeacher() {

		Scanner scan = new Scanner(System.in);

		boolean outLoop = true;
		boolean innerLoop = true;

		while (outLoop) {
			innerLoop = true;

			AdminTeacherView.printTeacherListLabel("검색");
			AdminTeacherView.printTeacherSearchBy();

			while (innerLoop) {

				String sel = scan.nextLine(); // 유효화 과정 필요
				System.out.println();

				if (sel.equals("0")) { // 뒤로가기
					printGoToBeforePage(scan);

					// 이전 화면으로 이동
					innerLoop = false;
				} else if (sel.equals("1")) { // 아이디로 검색
					searchById();

					innerLoop = false;
					outLoop = false;

				} else if (sel.equals("2")) { // 이름으로 검색
					searchByName();

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

	/**
	 * 강사 회원을 이름으로 검색하는 기능을 하는 메소드입니다.
	 */
	private static void searchByName() {
		// 회원 이름 검색 문자열 출력
		AdminTeacherView.printSearchTeacherName();

		Scanner scan = new Scanner(System.in);

		String inputName = scan.nextLine();

		AdminTeacherView.printLine();

		// 이름과 동일한 일반 회원 객체가 담겨있는 리스트 가져오기
		ArrayList<DataTeacher> curTeacherList = getTeacherObjectByName(inputName);

		// 없다면 - 검색결과가 없습니다. 계속하려면 엔터를 입력해주세요. -> 회원 검색 화면(이전 화면)으로 돌아가기
		if (curTeacherList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			System.out.println("계속 하려면 엔터를 입력해주세요.");
			scan.nextLine();
			AdminTeacherView.printLine();
			return;
		}

		for (DataTeacher t : curTeacherList) {
			// 찾은 회원 객체 데이터 출력
			printTeacherData(t);
		}

		// 페이지 이동 라벨 출력
		AdminTeacherView.printTeacherSearch();

		while (true) {
			boolean inLoop = true;
			// 새 이름 입력
			String inputSearch = scan.nextLine();

			if (inputSearch.equals("0")) { // 이전 메인 화면으로 이동
				printGoToBeforePage(scan);
				return;
			} else if (inputSearch.equals("1")) { // 수정
				if (curTeacherList.size() == 1) {
					// 동명이인이 없을 경우
					modifyTeacher(curTeacherList.get(0)); // 첫 번째인 유일한 회원 객체 바로 수정
				} else {
					// 동명이인이 있을 경우
					// 해당 유저의 코드 받기
					System.out.print("수정할 회원번호를 입력해주세요. : ");

					while (inLoop) {
						String curTeacherNum = scan.nextLine();

						DataTeacher modifyTeacher = getTeacherByNum(curTeacherList, curTeacherNum);

						// 코드가 일치하는지 검사
						if (modifyTeacher != null) {
							// 코드가 일치하는 경우 수정하기
							modifyTeacher(modifyTeacher);

							inLoop = false;
						} else {
							// 코드가 일치하지 않는 경우 다시 입력받기
							System.out.print("해당 회원이 존재하지 않습니다. 다시 입력해주세요. : ");
						}
					}
				}

				return;

			} else if (inputSearch.equals("2")) { // 삭제

				curTeacherList = getTeacherObjectByName(inputName); // 변경된 데이터 리로드
				DataTeacher deleteTeacher = null;

				if (curTeacherList.size() == 1) {
					// 동명이인이 없을 경우
					deleteTeacher = curTeacherList.get(0);
				} else {
					// 동명이인이 있을 경우
					// 해당 유저의 코드 받기
					System.out.print("수정할 회원번호를 입력해주세요. : ");

					while (inLoop) {
						String curTeacherNum = scan.nextLine();

						deleteTeacher = getTeacherByNum(curTeacherList, curTeacherNum);

						// 코드가 일치하는지 검사
						if (deleteTeacher != null) {
							// 코드가 일치하는 경우 객체를 찾아 나오기

							inLoop = false;
						} else {
							// 코드가 일치하지 않는 경우 다시 입력받기
							System.out.print("해당 회원이 존재하지 않습니다. 다시 입력해주세요. : ");
						}
					}
				}

				// 회원 객체 찾아오기
				// 해당 회원이 탈퇴한 경우
				if (deleteTeacher.getUsing() == 1) { // 이미 탈퇴한 회원인 경우
					System.out.println("이미 탈퇴한 회원입니다.");
					System.out.print("번호를 다시 입력해주세요. : ");
					continue;
				}

				// 해당 회원이 탈퇴하지 않은 경우
				// 탈퇴하지 않은 회원인 경우
				deleteTeacher(deleteTeacher);

				return;
			} else {
				AdminTeacherView.printInvalidInput(); // 다시 입력받기
			}
		}
	}

	/**
	 * 같은 이름의 강사 회원 리스트에서 회원 번호를 검색하여 해당 회원 번호를 가진 회원 객체를 반환하는 메소드입니다.
	 * 
	 * @param curTeacherList 같은 이름을 가진 강사 회원 리스트
	 * @param curTeacherNum  강사 회원 번호
	 * @return 해당 번호를 가진 강사 회원 객체
	 */
	private static DataTeacher getTeacherByNum(ArrayList<DataTeacher> curTeacherList, String curTeacherNum) {
		for (DataTeacher t : curTeacherList) {
			if (t.getTeacherCode().equals(curTeacherNum)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * 이름으로 강사 회원 객체를 찾아 리스트에 넣고 반환하는 메소드입니다.
	 * 
	 * @param inputName 강사 회원 이름
	 * @return 해당 이름을 가진 강사 회원들의 객체가 담긴 리스트
	 */
	private static ArrayList<DataTeacher> getTeacherObjectByName(String inputName) {
		ArrayList<DataTeacher> teacherList = UserDbms.getTeacherAllList();

		ArrayList<DataTeacher> sameNameTeacherList = new ArrayList<>();

		for (DataTeacher t : teacherList) {
			// 있다면 - 해당 회원 객체 뽑아오기
			if (t.getName().equals(inputName)) {
				sameNameTeacherList.add(t);
			}
		}

		return sameNameTeacherList;
	}

	/**
	 * 강사 회원을 아이디로 검색하는 기능을 하는 메소드입니다.
	 */
	private static void searchById() {
		// 회원 아이디 검색 문자열 출력
		AdminTeacherView.printSearchTeacherId();

		Scanner scan = new Scanner(System.in);

		String inputId = scan.nextLine();

		AdminTeacherView.printLine();

		// 입력받은 강사 아이디를 강사 리스트에서 검색하기

		DataTeacher curTeacher = AdminTeacherService.getTeacherObjectById(inputId);

		// 없다면 - 검색결과가 없습니다. 계속하려면 엔터를 입력해주세요. -> 회원 검색 화면(이전 화면)으로 돌아가기
		if (curTeacher == null) {
			System.out.println("검색 결과가 없습니다.");
			System.out.println("계속 하려면 엔터를 입력해주세요.");
			scan.nextLine();
			AdminTeacherView.printLine();
			return;
		}

		// 찾은 회원 객체 데이터 출력
		AdminTeacherService.printTeacherData(curTeacher);

		// 페이지 이동 라벨 출력
		AdminTeacherView.printTeacherSearch();

		while (true) {

			String inputSearch = scan.nextLine();

			if (inputSearch.equals("0")) { // 이전 메인 화면으로 이동
				printGoToBeforePage(scan);
				return;
			} else if (inputSearch.equals("1")) { // 수정
				AdminTeacherService.modifyTeacher(curTeacher);

				// 바뀐 일반 회원의 정보 보여줌
				AdminTeacherView.printTeacherListLabel("조회");
				DataTeacher changedTeacher = getTeacherObjectById(inputId);
				printTeacherData(changedTeacher);

				return;

			} else if (inputSearch.equals("2")) { // 삭제
				curTeacher = getTeacherObjectById(inputId); // 변경된 데이터 리로드

				if (curTeacher.getUsing() == 1) { // 이미 탈퇴한 회원인 경우
					System.out.println("이미 탈퇴한 회원입니다.");
					System.out.print("번호를 다시 입력해주세요. : ");
					continue;
				}

				// 탈퇴하지 않은 회원인 경우
				deleteTeacher(curTeacher);

				AdminTeacherView.printTeacherListLabel("조회");
				DataTeacher changedTeacher = getTeacherObjectById(inputId);
				printTeacherData(changedTeacher);

				return;

			} else {
				AdminTeacherView.printInvalidInput(); // 다시 입력받기
			}
		}
	}

	/**
	 * 강사 회원을 지우는 기능을 하는 메소드입니다.
	 * 
	 * @param t 강사 회원 객체
	 */
	private static void deleteTeacher(DataTeacher t) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			AdminTeacherView.printTeacherDeleteLabel();

			System.out.println("회원번호: " + t.getTeacherCode());
			System.out.println("이름: " + t.getName());
			System.out.println("아이디: " + t.getId());
			AdminTeacherView.printLine();
			System.out.println("회원의 상태를 탈퇴 회원으로 변경합니다.");
			System.out.print("변경하시겠습니까? (y/n) : ");

			String input = scan.nextLine();

			input = changeValidInput(input);

			if (input.equals("Y")) {
				// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
				changeTeacherUsingFile(t.getTeacherCode());

				System.out.println();
				System.out.println("수정이 완료되었습니다.");
				System.out.println("계속하려면 엔터를 입력해주세요.");
				scan.nextLine();

				break;
			} else if (input.equals("N")) {
				System.out.println("취소를 선택했습니다.");
				printGoToBeforePage(scan);

				break;
			} else {
				AdminTeacherView.printInvalidInput();
			}
		}
	}

	/**
	 * 강사 회원이 탈퇴처리 되었을 때 파일에 변경하여 저장하는 메소드입니다.
	 * 
	 * @param teacherCode 강사 회원 번호
	 */
	private static void changeTeacherUsingFile(String teacherCode) {
		try {
			String path = "data/dataTeacher.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");

				String curTeacherCode = temp[0];

				// 찾았다면
				if (curTeacherCode.equals(teacherCode)) {

					// 찾으면 유저의 using을 1로 수정하기
					temp[temp.length - 1] = "1";
				}

				DataTeacher changeTeacher = new DataTeacher(); // 새로운 객체 생성

				changeTeacher.setDataTeacher(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식

				sb.append(changeTeacher.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장

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

	/**
	 * 강사 회원의 정보를 수정하는 메소드입니다.
	 * 
	 * @param t 변경할 강사 회원 객체
	 */
	private static void modifyTeacher(DataTeacher t) {
		AdminTeacherView.printTeacherDataModify();

		Scanner scan = new Scanner(System.in);

		while (true) {

			String sel = scan.nextLine();

			if (sel.equals("0")) {
				break;

			} else if (sel.equals("1")) { // 이름 수정
				boolean isInValid = modifyTeacherName(t, scan);
				if (isInValid) {
					continue;
				}
				break;

			} else if (sel.equals("2")) { // 전화번호
				boolean isInValid = modifyTeacherTel(t, scan);
				if (isInValid) {
					continue;
				}
				break;

			} else {
				AdminTeacherView.printInvalidInput();
			}
		}

	}

	/**
	 * 강사 회원의 전화번호를 변경하는 메소드입니다.
	 * 
	 * @param t    변경할 강사 회원 객체
	 * @param scan 스캐너
	 * @return 메소드 실행 성공 여부
	 */
	private static boolean modifyTeacherTel(DataTeacher t, Scanner scan) {
		boolean invalid = false;

		String input;
		System.out.print("아이디(" + t.getId() + ") 회원의 전화번호를 수정하시겠습니까? (y/n) : ");
		input = scan.nextLine();
		input = changeValidInput(input); // trim + upperCase

		if (input.equals("Y")) { // 수정할 경우
			AdminTeacherView.printLine();

			System.out.println("새로운 전화번호을 입력해주세요.");
			System.out.print("전화번호: ");

			input = scan.nextLine();

			input = changeInputTrim(input); // trim + 추가 한글인지 유효성 검사 하는 작업 필요

			// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
			AdminTeacherService.changeTeacherTelFile(t.getTeacherCode(), input);

			System.out.println();
			System.out.println("수정이 완료되었습니다.");
			System.out.println("계속하려면 엔터를 입력해주세요.");
			scan.nextLine();

		} else if (input.equals("N")) {// 수정하지 않을 경우
			// 회원 아이디 검색 화면으로 이동 (이전 페이지)
			// 작성하기
			System.out.println("취소를 선택했습니다.");
			printGoToBeforePage(scan);

		} else { // 유효하지 않은 입력
			AdminTeacherView.printInvalidInput();
			invalid = true;
		}
		return invalid;
	}

	/**
	 * 강사 회원의 전화번호가 바뀌었을 때 파일에 저장하는 메소드입니다.
	 * 
	 * @param teacherCode 강사 회원 번호
	 * @param input       새 전화번호
	 */
	private static void changeTeacherTelFile(String teacherCode, String input) {
		try {
			String path = "data/dataTeacher.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");
				String curTeacherCode = temp[0];

				// 찾았다면
				if (curTeacherCode.equals(teacherCode)) {

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[4] = input;
				}

				DataTeacher changeTeacher = new DataTeacher(); // 새로운 객체 생성
				changeTeacher.setDataTeacher(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식
				sb.append(changeTeacher.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장
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

	/**
	 * 강사 회원의 이름을 변경하는 메소드입니다.
	 * 
	 * @param t    변경할 강사 회원 객체
	 * @param scan 스캐너
	 * @return 성공 여부
	 */
	private static boolean modifyTeacherName(DataTeacher t, Scanner scan) {
		boolean invalid = false;

		String sel;
		System.out.print("아이디(" + t.getId() + ") 회원의 이름을 수정하시겠습니까? (y/n) : ");
		sel = scan.nextLine();
		sel = changeValidInput(sel); // trim + upperCase

		if (sel.equals("Y")) { // 수정할 경우
			AdminTeacherView.printLine();

			System.out.println("새로운 이름을 입력해주세요.");
			System.out.print("이름: ");

			sel = scan.nextLine();

			sel = changeInputTrim(sel); // trim + 추가 한글인지 유효성 검사 하는 작업 필요

			// 파일 수정 -> 저장 -> 바뀐 데이터로 리로드
			AdminTeacherService.changeTeacherNameFile(t.getTeacherCode(), sel);

			System.out.println();
			System.out.println("수정이 완료되었습니다.");
			System.out.println("계속하려면 엔터를 입력해주세요.");
			scan.nextLine();

		} else if (sel.equals("N")) {// 수정하지 않을 경우
			// 회원 아이디 검색 화면으로 이동 (이전 페이지)
			// 작성하기
			System.out.println("취소를 선택했습니다.");
			printGoToBeforePage(scan);

		} else { // 유효하지 않은 입력
			AdminTeacherView.printInvalidInput();
			invalid = true;
		}
		return invalid;
	}

	/**
	 * 강사 회원의 이름이 변경되었을 때 파일을 변경하여 저장하는 메소드입니다.
	 * 
	 * @param teacherCode 강사 회원 번호
	 * @param newName     새 이름
	 */
	private static void changeTeacherNameFile(String teacherCode, String newName) {

		try {

			String path = "data\\dataTeacher.txt";

			// 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			StringBuffer sb = new StringBuffer();

			// 한 줄씩 읽기
			while ((line = reader.readLine()) != null) {

				// 해당 유저 코드 찾기
				String[] temp = line.split(",");

				String curTeacherCode = temp[0];

				// 찾았다면
				if (curTeacherCode.equals(teacherCode)) {

					// 찾으면 유저의 이름을 새 이름으로 바꾸기
					temp[3] = newName;
				}

				DataTeacher changeTeacher = new DataTeacher(); // 새로운 객체 생성

				changeTeacher.setDataTeacher(temp); // 클래스 내의 toString 메소드 사용 - 저장할 파일 내용의 양식

				sb.append(changeTeacher.toString() + "\r\n"); // 한 줄씩 읽은 내용을 StringBuilder에 계속 추가 저장

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

	/**
	 * 적합한 입력값으로 변경하는 메소드입니다.
	 * 
	 * @param sel 입력값
	 * @return 변경된 입력값
	 */
	private static String changeValidInput(String sel) {
		sel = changeInputTrim(sel);
		return changeInputUpper(sel);
	}

	/**
	 * 입력값을 대문자로 변경하는 메소드입니다.
	 * 
	 * @param sel 입력값
	 * @return 대문자로 변경된 입력값
	 */
	private static String changeInputUpper(String sel) {
		return sel.toUpperCase();
	}

	/**
	 * 입력값의 공백문자를 제거해주는 메소드입니다.
	 * 
	 * @param sel 입력값
	 * @return 공백이 사라진 입력값
	 */
	private static String changeInputTrim(String sel) {
		return sel.trim();
	}

	/**
	 * 아이디로 강사 회원 객체를 찾아 반환하는 메소드입니다.
	 * 
	 * @param inputId 강사 회원 아이디
	 * @return 해당 아이디를 가진 강사 회원 객체
	 */
	private static DataTeacher getTeacherObjectById(String inputId) {
		ArrayList<DataTeacher> teacherList = UserDbms.getTeacherAllList();

		DataTeacher curTeacher = null;

		for (DataTeacher t : teacherList) {
			// 있다면 - 해당 강사 객체 뽑아오기
			if (t.getId().equals(inputId)) {
				curTeacher = t;
				break;
			}
		}

		return curTeacher;
	}

}
