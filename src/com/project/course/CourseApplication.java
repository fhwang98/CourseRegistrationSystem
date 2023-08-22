package com.project.course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class CourseApplication {

	public static ArrayList<CourseApplication> list;

	static {

		CourseApplication.list = new ArrayList<CourseApplication>();

	}

	public static void courseApplication() {

		courseApplicationment();

	}

	private static void courseApplicationment() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("=====================");
		System.out.println("수강신청");
		System.out.println("=====================");
		System.out.println("수강을 원하는 과정의 강좌코드를 입력하세요.");
		System.out.println("0.뒤로가기");
		System.out.println("---------------------");
		System.out.print("입력: ");
		String code = scan.nextLine();

		if (code.equals("0")) {
//			Main.mainMent();
		}

		//전체 수강 내역에 추가
		//전체 수강 내역에서 회원 코드가 같을 경우 해당 강좌 코드를 확인하고 해당 강좌의 시간을 비교하여 같을경우 수강 시간 겹친다고 멘트출력
		
		// 일반회원코드 > temp[0]
		// 강사회원코드 > temp[0]

		
		try {

			BufferedReader readerCourse = new BufferedReader(new FileReader("data/lectureList.txt"));
//			BufferedReader readerMember = new BufferedReader(new FileReader("/Users/suding/코드 저장/dataMember.txt"));
//			BufferedWriter writerCourse = new BufferedWriter(new FileWriter("/Users/suding/코드 저장/classHistory.txt"));
//			
			
//			String id = "otqapf7199";
			
			String line = null;

//			//회원 정보 리더
//			while ((line = readerMember.readLine()) != null) {
//				
//				String[] temp = line.split(",");
//				
//				Teacher t = new Teacher(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
//				
//				
//				Member m = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
//						temp[9]);
//				
//			}
			
			//강의 목록 리더
			boolean courseFound = false;

			while ((line = readerCourse.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				
				Course c = new Course(temp[0], temp[1], temp[2], temp[3], t.getName(), temp[5], temp[6], temp[7], temp[8],
						temp[9], temp[10], temp[11]);

				if (temp[0].equalsIgnoreCase(code)) {

					courseMent(c);

					String input = scan.nextLine();

					if (courseFound = true) {

						if (input.equals("y")) {
							// 여기부터

							String tempValue = temp[10];

							int year = Integer.parseInt(tempValue.substring(0, 4));
							int month = Integer.parseInt(tempValue.substring(4, 6));

							Calendar nowTime = Calendar.getInstance();
							Calendar courseTime = Calendar.getInstance();

							courseTime.set(year, month - 1, 1);

							long courseTimeTick = courseTime.getTimeInMillis();
							long nowTimeTick = nowTime.getTimeInMillis();

							long gap = nowTimeTick - courseTimeTick;

							// 여기까지

							if (gap > 0) {
								System.out.println();
								System.out.println("\"이미 신청이 마감된 강좌 입니다.\"");
								System.out.println("\"처음으로 이동합니다.\"");
								System.out.println();

							//	Main.mainMent();
								break;

							} else {
								System.out.println();
								System.out.println("\"수강신청이 완료되었습니다.\"");
								System.out.println();
							//	Main.mainMent();
								break;
							}

						} else if (input.equals("n")) {
							System.out.println();
							System.out.println("\"처음으로 이동합니다.\"");
							System.out.println();
					//		Main.mainMent();
							break;

						} else {
								System.out.println();
								System.out.println("y 혹은 n을 입력하세요.");
								System.out.println("처음으로 이동합니다.");
								System.out.println();
							//	Main.mainMent();
								
							}
						}

					
				}

			}
			if (!courseFound) {
				System.out.println();
				System.out.println("\"잘못된 강좌코드 입니다.\"");
				System.out.println("\"강좌코드를 확인해 주세요.\"");
				System.out.println();
		//		Main.mainMent();

			}

			readerCourse.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// 모든 회원 전체 수강내역에 추가
	// 개인 별 수강내역 추가

	private static void courseMent(Course c) {
		if (c != null) {
			System.out.printf("[%s] 프로그램명 : %s\n", c.getCategory(), c.getCourseName());
			System.out.printf("강좌코드: %s\n", c.getNum());
			System.out.println();
			System.out.printf("강사코드: %s\n", c.getTeacherNum());
			System.out.println();
			System.out.printf("시간: %s\n", c.getTime());
			System.out.println();
			System.out.printf("요일: %s\n", c.getDay());
			System.out.println();
			System.out.printf("대상: %s\n", c.getTarget());
			System.out.println();
			System.out.printf("수강료: %s\n", c.getCourseFee());
			System.out.println();
			System.out.printf("정원: %s\n", c.getPerson());
			System.out.println();
			System.out.printf("강좌내용: %s\n", c.getContents());
			System.out.println();
			System.out.printf("강좌시작일: %s\n", c.getStartDay());
			System.out.println();
			System.out.printf("강의실 : %s\n", c.getRoomNum());
			System.out.println("-----------------------------------------");
			System.out.println();
			System.out.println("\"신청하신 강좌가 맞습니까?\"");
			System.out.print("입력: ");
		}

	}
}