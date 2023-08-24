package com.project.course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project.courseinfo.Course;
import com.project.main.MainView;

public class CourseApplication {

	public static ArrayList<Course> courseList;

	public static ArrayList<Member> memberList;

	public static ArrayList<Teacher> teacherList;

	public static ArrayList<History> historyList;
	static {

		CourseApplication.courseList = new ArrayList<Course>();
		CourseApplication.memberList = new ArrayList<Member>();
		CourseApplication.teacherList = new ArrayList<Teacher>();
		CourseApplication.historyList = new ArrayList<History>();

	}

	public static void courseApplication() {

		courseApplicationment();

	}

	public static void courseApplicationment() {

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("=====================");
		System.out.println("수강신청");
		System.out.println("=====================");
		System.out.println("수강을 원하는 과정의 강좌코드를 입력하세요.");
		System.out.println("0.뒤로가기");
		System.out.println("---------------------");
		System.out.print("입력: ");

//전체 수강 내역에 추가
//전체 수강 내역에서 회원 코드가 같을 경우 해당 강좌 코드를 확인하고 해당 강좌의 시간을 비교하여 같을경우 수강 시간 겹친다고 멘트출력
		// 일반회원코드 > temp[0]
		// 강사회원코드 > temp[0]

		String id = "otqapf7199";

		try {

			BufferedReader readerCourse = new BufferedReader(new FileReader("data/dataCourse.txt"));
			BufferedReader readerMember = new BufferedReader(new FileReader("data/dataMember.txt"));
			BufferedReader readerTeacher = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			BufferedReader readerHistory = new BufferedReader(new FileReader("data/courseHistory.txt"));

			String line = null;

			// 회원 정보 리더
			while ((line = readerMember.readLine()) != null) {

				String[] temp = line.split(",");

				Member m = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
						temp[9]);

				memberList.add(m);
			}
			// 선생님 정보 리턴

			while ((line = readerTeacher.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				teacherList.add(t);
			}

			while ((line = readerCourse.readLine()) != null) {

				String[] temp = line.split(",");

				Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
						temp[9], temp[10], temp[11]);

				courseList.add(c);
			}

			readerCourse.close();
			readerMember.close();
			readerTeacher.close();
			readerHistory.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		boolean courseFound = false;
		String code = scan.nextLine();
		for(History history : historyList) {
			if(history.getCourseNum().equals(code)) {
				System.out.println("중복된 강좌입니다.");
				System.out.println();
				MainView.MainScreen();
			}
			
		}
		
		String startDay = null;

		loop: for (Course c : courseList) {
			if (c.getNum().equalsIgnoreCase(code)) {
				for (Teacher t : teacherList) {
					if (t.getTeacherNum().equals(c.getTeacherNum())) {
						startDay = c.getStartDay();
						courseFound = true;
						courseMent(c, t);
						break loop;//강좌 여러개 찍혀서 하나만 뽑으려고 브레이크 씀. 포문 두개라 이중포문 빠져나오는 루프 사용
					}
				}
			}
		}
		
		if (!courseFound) {
			System.out.println();
			System.out.println("\"잘못된 강좌코드 입니다.\"");
			System.out.println("\"강좌코드를 확인해 주세요.\"");
			System.out.println();
			MainView.MainScreen();
		}

		String input = scan.nextLine();

		if (input.equals("n")) {
			System.out.println("처음으로 돌아갑니다. ");
			MainView.MainScreen();
		}

		String tempValue = startDay;

		int year = Integer.parseInt(tempValue.substring(0, 4));
		int month = Integer.parseInt(tempValue.substring(4, 6));

		Calendar nowTime = Calendar.getInstance();
		Calendar courseTime = Calendar.getInstance();

		courseTime.set(year, month - 1, 1);

		long courseTimeTick = courseTime.getTimeInMillis();
		long nowTimeTick = nowTime.getTimeInMillis();

		long gap = nowTimeTick - courseTimeTick;

		if (gap > 0) {
			System.out.println();
			System.out.println("\"이미 신청이 마감된 강좌 입니다.\"");
			System.out.println("\"처음으로 이동합니다.\"");
			System.out.println();
			MainView.MainScreen();
			
		} else {
//			int num = 0;
			for (Member m : CourseApplication.memberList) {
				
				if (m.getId().equals(id)) {
//					num += 1;
					String lastNum = historyList.size() + 1 + "";
					History h = new History(lastNum, m.getNo(), code);
					historyList.add(h);
					break;// 파일 저장이 여러번씩 되어서 하나씩만 저장되도록 하려고 쓴 코드 / 왜 여러번 된지는 정확히 모르는데 id int num으로 받아서 몇번찍히는지 확인하면서 구현하다가 에라이 브레이크 했는데 성공 
				}
			}
//			System.out.println(num);
			
			try {
				BufferedWriter writerHistory = new BufferedWriter(new FileWriter("data/courseHistory.txt"));

				for (History h1 : CourseApplication.historyList) {

					writerHistory.write(
							String.format("%s,%s,%s\n", h1.getHistoryNum(), h1.getMemberNum(), h1.getCourseNum()));
				}

				writerHistory.close();

			} catch (Exception e) {
				System.out.println("at CourseApplication.courseApplicationment");
				e.printStackTrace();
			}

			System.out.println("수강신청이 완료되었습니다.");
			System.out.println("처음으로 이동합니다.");
			System.out.println();
			MainView.MainScreen();
		}

	}

	private static void courseMent(Course c, Teacher t) {
		if (c != null) {
			System.out.printf("[%s] 프로그램명 : %s\n", c.getCategory(), c.getCourseName());
			System.out.println();
			System.out.printf("강좌코드: %s\n", c.getNum());
			System.out.println();
			System.out.printf("강사코드: %s\n", t.getTeacherName());
			System.out.println();
			System.out.printf("시간: %s\n", c.getTime());
			System.out.println();
			System.out.printf("요일: %s\n", c.getDay());
			System.out.println();
			System.out.printf("대상: %s\n", c.getTarget());
			System.out.println();
			System.out.printf("수강료: %s원\n", c.getCourseFee());
			System.out.println();
			System.out.printf("신청인원: %s\n", c.getPerson());
			System.out.println();
			System.out.printf("강좌내용: %s\n", c.getContents());
			System.out.println();
			System.out.printf("강좌시작일: %s\n", c.getStartDay());
			System.out.println();
			System.out.printf("강의실 : %s호\n", c.getRoomNum());
			System.out.println("-----------------------------------------");
			System.out.println();
			System.out.println("\"신청하신 강좌가 맞습니까?(y/n)\"");
			System.out.print("입력: ");

		}

	}

}
