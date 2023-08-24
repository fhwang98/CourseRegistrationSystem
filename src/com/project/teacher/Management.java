package com.project.teacher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.admin.course.PendingCourse;
import com.project.admin.course.PendingCourseData;
import com.project.authentication.Authentication;
import com.project.courseinfo.Course;
import com.project.courseinfo.CourseData;
import com.project.user.data.DataTeacher;
import com.project.user.login.LoginMain;

public class Management {

	public static ArrayList<Course> teacherCourseList;

	static {
		Management.teacherCourseList = new ArrayList<>();
	}

	public static void main(String[] args) {
		CourseData.allCourseList();
		System.out.println(CourseData.courseList);
	}

	public static void courseManagement() {

		Scanner scan = new Scanner(System.in);

		int input = 0;

		System.out.println("          강좌 관리");
		System.out.println("—-------------------------------------");
		System.out.println("0. 메인화면 돌아가기");
		System.out.println("1. 강좌 등록 신청");
		System.out.println("2. 강좌 등록 조회");
		System.out.println("3. 강좌 등록 수정");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();

		if (input == 0) {

			TeacherMain.LoginTeacher(null);

		} else if (input == 1) {

			Management.registration();

		} else if (input == 2) {

			Management.information();

		} else if (input == 3) {

			Management.modify();

		} else {

			System.out.println("유효하지 않는 입력값입니다.");

		}
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
		String status = "대기";

		System.out.println("          강좌등록신청");
		System.out.println("—-------------------------------------");
		System.out.println("0. 강좌관리 화면 돌아가기");
		System.out.println("신청을 계속하려면 아무번호를 입력하세요");

		input = scan.nextInt();

		if (input == 0) {

			Management.courseManagement();

		} else {

			ArrayList<PendingCourse> courseList = new ArrayList<>();

			while (true) {

				System.out.println("—-------------------------------------");
				System.out.print("시작 시간\r\n06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06): ");
				time = scan.nextLine();
				System.out.print("요일\r\n평일만 등록 가능합니다(월,화,수,목,금 중 입력): ");
				date = scan.nextLine();
				System.out.print("강좌명\r\n2~14자리 한글,영어,숫자만 가능합니다: ");
				name = scan.nextLine();
				System.out.print("카테고리\r\n문화, 블럭교실, 피아노, 체육, 어린이 중에 입력해주세요: ");
				category = scan.nextLine();
				System.out.print("수강대상\r\n어린이, 청소년, 성인, 누구나 중에 입력해주세요: ");
				age = scan.nextLine();
//		System.out.print("수강인원: ");
//		num = scan.nextLine();
				System.out.print("강좌내용\r\n100자 이내로 입력하시오: ");
				content = scan.nextLine();
				System.out.println("—-------------------------------------");
				// System.out.print("번호 입력 : ");

				if (isValid(time, date, name, category, age, content)) {

					System.out.println("가입 완료");

					LoginMain lista = new LoginMain();
					ArrayList<DataTeacher> loginList = lista.getLoginTList();

					PendingCourse pendingCourse = new PendingCourse(name, date, time, category, age, content, status,
							loginList.get(0).getTeacherCode(), "없음");// TODO 로그인한 강사 코드 넣는부분 수정
					courseList.add(pendingCourse);

					PendingCourseData.update();

					break;

				} else {

					System.out.println("가입 실패");

				}
			}

		}

	}

	private static boolean isValid(String time, String date, String name, String category, String age, String content) {

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

//		// 5. num > 수강인원 > 10명 이상 ~30명 이하만 가능합니다
//		regex = "^[0-9]{2}$";
//		p1 = Pattern.compile(regex);
//		m1 = p1.matcher(age);
//
//		if (!m1.find() || (Integer.parseInt(age) < 10 || Integer.parseInt(age) > 30)) {
//			System.out.println("10명 이상 ~30명 이하만 가능합니다");
//			return false;
//		}

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

	public static int loadCourseList() {


		int n = 1;

		String a = Authentication.loginUserCode;

		for (Course c : CourseData.courseList) {

			if (a.equals(c.getTeacherNum())) {

				teacherCourseList.add(c);

				System.out.println(n + ". " + c.getCourseName());

				n++;

			}
		}
		return teacherCourseList.size();
	}

	public static void information() {

		Scanner scan = new Scanner(System.in);

		int input = -1;

		System.out.println("        강사관리 > 강좌 정보 조회");
		System.out.println("—-------------------------------------");
		System.out.println("0. 강좌관리 화면 돌아가기");
		System.out.println("======================================");
		int curSize = loadCourseList();
		System.out.println("======================================");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력: ");

		input = scan.nextInt();
		scan.nextLine();

		if (input == 0) {

			Management.courseManagement();

		} else if (input <= curSize) {

			Course c = teacherCourseList.get(input - 1);

			System.out.println("       강좌 정보 조회");
			System.out.println("—-------------------------------------");
			System.out.println("강좌명: " + c.getCourseName());
			System.out.println("카테고리: " + c.getCategory());
			System.out.println("시간: " + c.getTime());
			System.out.println("대상 연령: " + c.getTarget());
			System.out.println("신청 인원: " + c.getPerson());
			System.out.println("강좌 내용: " + c.getContents());
			System.out.println("시작 날짜: " + c.getStartDay());
			System.out.println("—-------------------------------------");
			System.out.println("0. 마이페이지 돌아가기");
			System.out.print("번호 입력 : ");

			input = scan.nextInt();
			scan.nextLine();

			if (input == 0) {

				Management.courseManagement();

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
		int curSize = loadCourseList();
		System.out.println("======================================");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();
		scan.nextLine();

		if (input == 0) {

			Management.courseManagement();

		} else if (input <= curSize) {

			Course c = teacherCourseList.get(input - 1);

			String newName = "";
			String newTime = "";
			String newTeacherName = "";
			String newTarget = "";
			String newNum = "";
			String newContent = "";

			System.out.println("          강좌정보수정");
			System.out.println("—-------------------------------------");
			System.out.println("0. 강좌관리 돌아가기");
			System.out.println("1. 강좌명");
			System.out.println("2. 시간");
			System.out.println("3. 수강대상");
			System.out.println("4. 수강인원");
			System.out.println("5. 강좌내용");
			System.out.println("—-------------------------------------");
			System.out.print("수정할 정보의 번호를 입력 : ");

			input = scan.nextInt();
			scan.nextLine();

			if (input == 0) {

				Management.courseManagement();

			} else if (input == 1) {

				System.out.print("수정할 강좌명을 입력하세요: ");

				newName = scan.nextLine();

				Management.isValidName(newName);

				modifyCourseByName(c.getCourseName(), newName);

			} else if (input == 2) {

				System.out.print("수정할 시간을 입력하세요: ");

				newTime = scan.nextLine();
				
				if(Management.isValidTime(newTime)) {
					
					modifyCourseByTime(c.getTime(), newTime);
					
					System.out.println("수정을 완료했습니다.");
				} else {
					
					System.out.println("수정할 수 없습니다.");
				}


			} else if (input == 3) {

				System.out.print("수정할 수강대상을 입력하세요: ");

				newTarget = scan.nextLine();
				
				Management.isValidAge(newTarget);

				modifyCourseByTarget(c.getTarget(), newTarget);

			} else if (input == 4) {

				System.out.print("수강인원을 입력하세요: ");

				newNum = scan.nextLine();
				
				Management.isValidNum(newNum);

				modifyCourseByNum(c.getPerson(), newNum);

			} else if (input == 5) {

				System.out.print("수정할 강좌내용을 입력하세요: ");

				newContent = scan.nextLine();
				
				Management.isValidContent(newContent);

				modifyCourseByContent(c.getContents(), newContent);

			} else {

				System.out.println("잘못된 입력입니다.");

			}

		}

	}

	private static void modifyCourseByName(String courseNum, String newName) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data/dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

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
				if (num.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					courseName = newName;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성

			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString());
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
			String path = "data/dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

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
				if (num.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					time = newTime;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성

			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			writer.write(sb.toString());
			
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
			String path = "data/dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

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
				if (num.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					target = newTarget;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성

			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString());
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
			String path = "data/dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

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
				if (num.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					person = newNum;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성

			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString());
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

	private static void modifyCourseByContent(String courseNum, String newContets) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data/dataCourse.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

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
				if (num.equals(courseNum)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					contents = newContets;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(num + "," + category + "," + courseName + "," + time + "," + day + "," + target + ","
						+ courseFee + "," + person + "," + teacherNum + "," + contents + "," + startDay + "," + roomNum
						+ "\r\n");

			}

			// 파일 작성

			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString());
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

	private static boolean isValidName(String courseName) {

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체

		// 1. courseName > 강좌명 > 2~14자리 한글,영어,숫자만 가능합니다
		regex = "[A-Za-z0-9가-힣_]{2,14}";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(courseName);

		if (!m1.find()) {
			System.out.println("2~14자리 한글,영어,숫자만 가능합니다");
		}
		return false;
	}

	private static boolean isValidTime(String time) {

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체

		// 2. time > 시간 > 06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06)
		regex = "^[0-9]{2}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(time);

		if (!m1.find() || (Integer.parseInt(time) < 06 || Integer.parseInt(time) > 22)) {
			System.out.println("06시 ~ 22시 운영시간내에 입력하시오 (두자리 숫자 입력 ex: 06)");
			return false;
		}
		return true;
	}

	private static boolean isValidAge(String age) {
		// 3. age > 수강대상 > 어린이, 청소년, 성인, 누구나 중에 입력해주세요

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체

		regex = "^[가-힣]{2,3}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(age); // 사용자가 입력한 이름에서 패턴 검색

		if (!m1.find() || age.equals("어린이") || age.equals("청소년") || age.equals("성인") || age.equals("누구나")) {

			System.out.println("어린이, 청소년, 성인, 누구나 중에 입력해주세요");
		}
		return false;
	}

	private static boolean isValidNum(String num) {

		// 5. num > 수강인원 > 10명 이상 ~30명 이하만 가능합니다

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체
		regex = "^[0-9]{2}$";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(num);

		if (!m1.find() || (Integer.parseInt(num) < 10 || Integer.parseInt(num) > 30)) {
			System.out.println("10명 이상 ~30명 이하만 가능합니다");
		}
		return false;
	}

	private static boolean isValidContent(String content) {

		// 6. content > 강좌내용 > 100자 이내로 입력하시오

		String regex = ""; // 정규식
		Pattern p1 = null; // 정규식 객체
		Matcher m1 = null; // 결과 객체

		regex = "[A-Za-z0-9가-힣_]{0,100}";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(content);

		if (!m1.find()) {
			System.out.println("100자 이내로 입력하시오");
		}
		return false;
	}

}// class
