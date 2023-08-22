package com.project.teacher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.teacher.TeacherMain;

public class Management {

	public static void courseManagement() {

		Scanner scan = new Scanner(System.in);

		int input = 0;

		System.out.println("          강좌 관리");
		System.out.println("—-------------------------------------");
		System.out.println("0. 메인화면 돌아가기");
		System.out.println("1. 공지사항 등록");
		System.out.println("2. 강좌 등록 신청");
		System.out.println("3. 강좌 등록 조회");
		System.out.println("4. 강좌 등록 수정");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();

		if (input == 0) {

			// 연결시켜

		} else if (input == 1) {

			Management.notice();

		} else if (input == 2) {

			Management.registration();

		} else if (input == 3) {

			Management.information();

		} else if (input == 4) {

			Management.modify();

		} else {

			System.out.println("유효하지 않는 입력값입니다.");

		}
	}

	// 유진이 공지사항 가져오기
	public static void notice() {

		Scanner scan = new Scanner(System.in);

		int input = 0;
		String notice = "";

		System.out.println("          공지사항 등록");
		System.out.println("—-------------------------------------");
		System.out.println("0. 강좌관리 화면 돌아가기");
		System.out.println("======================================");
		loadCourseList();
		System.out.println("======================================");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");
		input = scan.nextInt();

		if (input == 0) {

			Management.courseManagement();

		} else if (input <= courseList.size()) {

		} else {
			
			System.out.println("유효하지 않는 입력값입니다.");
			
		}

		System.out.print("공지사항 입력 : ");
		notice = scan.nextLine();

	}

	public static void registration() {

		Scanner scan = new Scanner(System.in);

		int input = 0;
		String time = "";
		String date = "";
		String name = "";
		String category = "";
		String age = "";
		String num = "";
		String content = "";

		System.out.println("          강좌등록신청");
		System.out.println("—-------------------------------------");
		System.out.print("0. 강좌관리 화면 돌아가기");
		System.out.print("강좌명: ");
		name = scan.nextLine();
		System.out.print("요일: ");
		date = scan.nextLine();
		System.out.print("시작 시간: ");
		time = scan.nextLine();
		System.out.print("카테고리: ");
		category = scan.nextLine();
		System.out.print("수강대상: ");
		age = scan.nextLine();
		System.out.print("수강인원: ");
		num = scan.nextLine();
		System.out.print("강좌내용: ");
		content = scan.nextLine();
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();

		if (input == 0) {

			Management.courseManagement();

		} else {

			System.out.println("유효하지 않는 입력값입니다.");
		}

		if (isValid(time, date, name, category, age, num, content)) {

			System.out.println("가입 완료");

		} else {

			System.out.println("가입 실패");

		}

	}

	private static boolean isValid(String time, String date, String name, String category, String age, String num,
			String content) {

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체

		// 1. time > 시간 > 06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06)
		regex = "^[0-9]{2}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(time);

		if (!m1.find() || (Integer.parseInt(time) < 06 || Integer.parseInt(time) > 22)) {
			System.out.println("06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06)");
			return false;
		}

		// 중복되는 요일 유효성 검사 필요함
		// 2. date > 요일 > 평일만 등록 가능합니다(월,화,수,목,금 중 입력)
		regex = "^[가-힣]{1,5}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(date); // 사용자가 입력한 이름에서 패턴 검색

		if (!m1.find() || !(date.equals("월") || date.equals("화") || date.equals("수") || date.equals("목")
				|| date.equals("금"))) {
			System.out.println("평일만 등록 가능합니다");
			return false;
		}

		// 3. name > 강좌명 > 2~14자리 한글,영어,숫자만 가능합니다
		regex = "^[A-Za-z0-9가-힣_]{2,14}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(name);

		if (!m1.find()) {
			System.out.println("2~14자리 한글,영어,숫자만 가능합니다");
			return false;
		}

		// 4. category > 카테고리 > 문화, 블럭교실, 피아노, 체육, 어린이 중에 입력해주세요
		regex = "^[가-힣]{2,4}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(category); // 사용자가 입력한 이름에서 패턴 검색

		if (!m1.find() || !(category.equals("문화") || category.equals("블럭교실") || category.equals("피아노")
				|| category.equals("체육") || category.equals("어린이"))) {
			System.out.println("문화, 블럭교실, 피아노, 체육, 어린이 중에 입력해주세요");
			return false;
		}

		// 5. age > 수강대상 > 어린이, 청소년, 성인, 누구나 중에 입력해주세요

		regex = "^[0-9]{2,3}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age);

		regex = "^[가-힣]{2,3}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age); // 사용자가 입력한 이름에서 패턴 검색

		if (!m1.find() || !(age.equals("어린이") || age.equals("청소년") || age.equals("성인") || age.equals("누구나"))) {
			System.out.println("어린이, 청소년, 성인, 누구나 중에 입력해주세요");
			return false;
		}

		// 5. num > 수강인원 > 10명 이상 ~30명 이하만 가능합니다
		regex = "^[0-9]{2}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age);

		if (!m1.find() || (Integer.parseInt(age) < 10 || Integer.parseInt(age) > 30)) {
			System.out.println("10명 이상 ~30명 이하만 가능합니다");
			return false;
		}

		// 6. content > 강좌내용 > 100자 이내로 입력하시오
		regex = "^[A-Za-z0-9가-힣_]{0,100}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(content);

		if (!m1.find()) {
			System.out.println("100자 이내로 입력하시오");
			return false;
		}

		return true;
	}

	public static void loadCourseList() {

		ArrayList<Data> list = new ArrayList<>();

		String teacherCode = "강사의 코드";

		try {

			BufferedReader reader = new BufferedReader(
					new FileReader("C:\\Users\\juju8\\OneDrive\\바탕 화면\\내프로젝트\\06.데이터\\dataCourse.txt"));

			String line = null;

			line = reader.readLine();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				// 강좌조회시 보여줄 항목들 모두 담아야함 temp[2]말고 추가로 더
				Data data = new Data(temp[2], temp[3], temp[4], temp[5], temp[6]);

				list.add(data);

			}

			reader.close();

		} catch (Exception e) {

		}

		int n = 1;

		ArrayList<Course> courseList = new ArrayList<>();

		for (Course c : list) {

			if (teacherCode.equals(c.getCode())) {

				courseList.add(c);

				System.out.println(n + ". " + c.getName());

				n++;

			}

			else {

				System.out.println("일치하는 강사 코드가 없습니다.");

			}

		}

	}

	public static void information() {

		Scanner scan = new Scanner(System.in);

		int input = 0;

		System.out.println("        강사관리 > 강좌 정보 조회");
		System.out.println("—-------------------------------------");
		System.out.println("0. 강좌관리 화면 돌아가기");
		System.out.println("======================================");
		loadCourseList();
		System.out.println("======================================");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력: ");
		scan.nextInt();

		if (input == 0) {

			Management.courseManagement();

		} else if (input <= courseList.size()) {

			Course c = courseList.get(input - 1);

			System.out.println("       강사 마이페이지 > 내 정보 조회");
			System.out.println("—-------------------------------------");
			System.out.println("강좌명: " + c.getId());
			System.out.println("카테고리: " + c.getName());
			System.out.println("기간: " + c.getPhone());
			System.out.println("시간: " + c.getCode());
			System.out.println("강사명: " + c.getCode());
			System.out.println("대상 연령: " + c.getCode());
			System.out.println("수강 인원: " + c.getCode());
			System.out.println("강좌 내용: " + c.getCode());
			System.out.println("—-------------------------------------");
			System.out.println("0. 마이페이지 돌아가기");
			System.out.print("번호 입력 : ");

			input = scan.nextInt();

			if (input == 0) {

				Teacher.mypage();

			}

		}

		else {

			System.out.println("유효하지 않는 입력값입니다.");

		}

	}

	public static void modify() {

		Scanner scan = new Scanner(System.in);

		int input = 0;

		System.out.println("        강사관리 > 강좌 정보 수정");
		System.out.println("—-------------------------------------");
		System.out.println("0. 강좌관리 화면 돌아가기");
		System.out.println("======================================");
		loadCourseList();
		System.out.println("======================================");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();

		if (input == 0) {

			Management.courseManagement();

		} else if (input <= courseList.size()) {

			Course c = courseList.get(input - 1);

			String newName = "";
			String newTime = "";
			String newTeacherName = "";
			String newTarget = "";
			String newNum = "";
			String newContent = "";

			System.out.println("          강좌정보수정");
			System.out.println("—-------------------------------------");
			System.out.print("0. 강좌관리 돌아가기");
			System.out.print("1. 강좌명");
			System.out.print("2. 시간");
			System.out.print("3. 강사명");
			System.out.print("4. 수강대상");
			System.out.print("5. 수강인원");
			System.out.print("6. 강좌내용");
			System.out.println("—-------------------------------------");
			System.out.print("수정할 정보의 번호를 입력 : ");

			input = scan.nextInt();

			if (input == 0) {

				Management.courseManagement();

			} else if (input == 1) {

				System.out.print("수정할 강좌명을 입력하세요: ");

				newName = scan.nextLine();

				modifyCourseByName(c.getNum, newName);

			} else if (input == 2) {

				System.out.print("수정할 시간을 입력하세요: ");

				newTime = scan.nextLine();

				modifyCourseBytime(c.getNum, newTime);

			} else if (input == 3) {

				System.out.print("수정할 강사명을 입력하세요: ");

				newTeacherName = scan.nextLine();

				modifyCourseByTeacherName(c.getNum, newTeacherName);

			} else if (input == 4) {

				System.out.print("수정할 수강대상을 입력하세요: ");

				newTarget = scan.nextLine();

				modifyCourseByTarget(c.getNum, newTarget);

			} else if (input == 5) {

				System.out.print("수강인원을 입력하세요: ");

				newNum = scan.nextLine();

				modifyCourseByNum(c.getNum, newNum);

			} else if (input == 6) {

				System.out.print("수정할 강좌내용을 입력하세요: ");

				newContent = scan.nextLine();

				modifyCourseByContent(c.getNum, newContent);

			} else {

				System.out.println("잘못된 입력입니다.");

			}

			if (isValid(newName, newTime, newTeacherName, newTarget, newNum, newContent)) {
				System.out.println("가입 완료");
			} else {
				System.out.println("가입 실패");
			}
		}

	}

	private static void modifyCourseByName(String courseNum, String newName) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String num = temp[0];
				String category = temp[1];
				String courseName = temp[2];
				String time = temp[3];
				String day = temp[4];
				String target = temp[5];
				String courseFee = temp[6];
				String person = temp[7];
				String teacherNum = temp[8];
				String contents = temp[9];
				String startDay = temp[10];
				String roomNum = temp[11];

				// 현재 줄의 강좌 코드와 현재 강좌 코드가 같은지 비교
				if (c.getNum.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newName;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

	private static void modifyCourseByTime(String courseNum, String newTime) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String num = temp[0];
				String category = temp[1];
				String courseName = temp[2];
				String time = temp[3];
				String day = temp[4];
				String target = temp[5];
				String courseFee = temp[6];
				String person = temp[7];
				String teacherNum = temp[8];
				String contents = temp[9];
				String startDay = temp[10];
				String roomNum = temp[11];

				// 현재 줄의 강좌 코드와 현재 강좌 코드가 같은지 비교
				if (c.getNum.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newTime;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}
	
	private static void modifyCourseByTeacherName(String courseNum, String newTeacherName) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String num = temp[0];
				String category = temp[1];
				String courseName = temp[2];
				String time = temp[3];
				String day = temp[4];
				String target = temp[5];
				String courseFee = temp[6];
				String person = temp[7];
				String teacherNum = temp[8];
				String contents = temp[9];
				String startDay = temp[10];
				String roomNum = temp[11];

				// 현재 줄의 강좌 코드와 현재 강좌 코드가 같은지 비교
				if (c.getNum.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newTeacherName;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}
	
	private static void modifyCourseByTarget(String courseNum, String newTarget) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String num = temp[0];
				String category = temp[1];
				String courseName = temp[2];
				String time = temp[3];
				String day = temp[4];
				String target = temp[5];
				String courseFee = temp[6];
				String person = temp[7];
				String teacherNum = temp[8];
				String contents = temp[9];
				String startDay = temp[10];
				String roomNum = temp[11];

				// 현재 줄의 강좌 코드와 현재 강좌 코드가 같은지 비교
				if (c.getNum.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newTarget;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}
	
	private static void modifyCourseByNum(String courseNum, String newNum) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String num = temp[0];
				String category = temp[1];
				String courseName = temp[2];
				String time = temp[3];
				String day = temp[4];
				String target = temp[5];
				String courseFee = temp[6];
				String person = temp[7];
				String teacherNum = temp[8];
				String contents = temp[9];
				String startDay = temp[10];
				String roomNum = temp[11];

				// 현재 줄의 강좌 코드와 현재 강좌 코드가 같은지 비교
				if (c.getNum.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newNum;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}
	
	private static void modifyCourseByContent(String courseNum, String newContetn) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String num = temp[0];
				String category = temp[1];
				String courseName = temp[2];
				String time = temp[3];
				String day = temp[4];
				String target = temp[5];
				String courseFee = temp[6];
				String person = temp[7];
				String teacherNum = temp[8];
				String contents = temp[9];
				String startDay = temp[10];
				String roomNum = temp[11];

				// 현재 줄의 강좌 코드와 현재 강좌 코드가 같은지 비교
				if (c.getNum.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newContetn;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

	private static boolean isValid(String courseName, String time, String teacherName, String age, String num,
			String content) {

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체

		// 1. courseName > 강좌명 > 2~14자리 한글,영어,숫자만 가능합니다
		regex = "[A-Za-z0-9가-힣_]{2,14}";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(courseName);

		if (!m1.find()) {
			System.out.println("2~14자리 한글,영어,숫자만 가능합니다");
			return false;
		}

		// 2. time > 시간 > 06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06)
		regex = "^[0-9]{2}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(time);

		if (!m1.find() || (Integer.parseInt(time) < 06 || Integer.parseInt(time) > 22)) {
			System.out.println("06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06)");
			return false;
		}

		// 3. teacherName > 강사명 > 2~4자리 한글만 가능합니다
		regex = "^[가-힣]{2,4}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(teacherName); // 사용자가 입력한 이름에서 패턴 검색

		if (!m1.find()) {
			System.out.println("2~4자리 한글만 가능합니다");
			return false;
		}

		// 4. age > 수강대상 > 어린이, 청소년, 성인, 누구나 중에 입력해주세요

		regex = "^[0-9]{2,3}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age);

		regex = "^[가-힣]{2,3}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age); // 사용자가 입력한 이름에서 패턴 검색

		if (!m1.find() || age.equals("어린이") || age.equals("청소년") || age.equals("성인") || age.equals("누구나")) {
			System.out.println("어린이, 청소년, 성인, 누구나 중에 입력해주세요");
			return false;
		}

		// 5. num > 수강인원 > 10명 이상 ~30명 이하만 가능합니다
		regex = "^[0-9]{2}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age);

		if (!m1.find() || (Integer.parseInt(age) < 10 || Integer.parseInt(age) > 30)) {
			System.out.println("10명 이상 ~30명 이하만 가능합니다");
			return false;
		}

		// 6. content > 강좌내용 > 100자 이내로 입력하시오
		regex = "[A-Za-z0-9가-힣_]{0,100}";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(content);

		if (!m1.find()) {
			System.out.println("100자 이내로 입력하시오");
			return false;
		}

		return true;
	}

}// class
