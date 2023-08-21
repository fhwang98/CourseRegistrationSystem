package com.project.courseinfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CourseData {

	static Scanner scan = new Scanner(System.in);
	
	public static ArrayList<Course> list;

	static {

		CourseData.list = new ArrayList<Course>();

	}

	//수강신청

	// 개인별 강좌 추천 문화 선택
	public static void cultureRecommend() {

		try {
			Random rnd = new Random();

			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[1].equals("문화")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.list.add(c);
				}
			}
			
			Course c = CourseData.list.get(rnd.nextInt(CourseData.list.size()));
			
			courseMent(c);
//			ment(rnd, reader);

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//개인별 강좌 추천 체육 선택
	public static void sportsRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("체육")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
					
				}
			}
			
			Course c = CourseData.list.get(rnd.nextInt(CourseData.list.size()));
			
			courseMent(c);
			//ment(rnd, reader);
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//개인별 강좌 추천 피아노 선택
	public static void pianoRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				
				String[] temp = line.split(",");
				
				
				if (temp[1].equals("피아노")) {
//					System.out.println("temp0 = " + temp[0]);
//					System.out.println("temp1 = " + temp[1]);
//					System.out.println("temp2 = " + temp[2]);
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
					
				}
			}
			
//			for(int i=0; i <CourseData.list.size(); i++) {
//				System.out.println("data1 =" + CourseData.list.get(i));
//			}
			
			Course c = CourseData.list.get(rnd.nextInt(CourseData.list.size()));
			
//			System.out.println("Category  ="+c.getCategory());
			
			courseMent(c);
			//ment(rnd, reader);

			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//개인별 강좌 추천 어린이 선택
	public static void kidsRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("어린이")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
//					System.out.println(c);
				}
			}

			
			Course c = CourseData.list.get(rnd.nextInt(CourseData.list.size()));
			
			courseMent(c);
			//ment(rnd, reader);

			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//개인별 강좌 추천 블럭교실 선택
	public static void blockRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("블럭교실")) {
					// 강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
					// System.out.println(c);
				}
			}

			Course c = CourseData.list.get(rnd.nextInt(CourseData.list.size()));
			
			courseMent(c);
			//ment(rnd, reader);
			

			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//강좌 전체 목록
	public static void allList() {

		try {
			Random rnd = new Random();

			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));

			String line = null;

			System.out.println("===================================");
			System.out.println("전체 강좌");
			System.out.println("===================================");
			
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				Course l = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
						temp[9], temp[10], temp[11]);

				CourseData.list.add(l);

				courseMent(l);
			}

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//강좌 카테고리별 목록
	public static void cultureList() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));

			String line = null;

			
			System.out.println("===================================");
			System.out.println("문화");
			System.out.println("===================================");
			
			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");

				if (temp[1].equals("문화")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

//					CourseData.list.add(c);
					courseMent(c);
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void pianoList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("피아노");
			System.out.println("===================================");
			
			while ((line = reader.readLine()) != null) {
				
				line = line.replace("\"", "");
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("피아노")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
//					CourseData.list.add(c);
					courseMent(c);
				
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void sportsList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("체육");
			System.out.println("===================================");
			
			while ((line = reader.readLine()) != null) {
				
				line = line.replace("\"", "");
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("체육")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
//					CourseData.list.add(c);
					
					courseMent(c);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void kidsList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("어린이");
			System.out.println("===================================");
			
			while ((line = reader.readLine()) != null) {
				
				line = line.replace("\"", "");
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("어린이")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
//					CourseData.list.add(c);
					
					courseMent(c);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void blockList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("블럭교실");
			System.out.println("===================================");
			
			while ((line = reader.readLine()) != null) {
				
				line = line.replace("\"", "");
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("블럭교실")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
//					CourseData.list.add(c);
					

					courseMent(c);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//요일 시간별 강좌목록
	public static void mondayAmTime() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("월")) {
	                amMethod(temp);
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void mondayPmTime() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("월")) {
	                pmMethod(temp);
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void tuesdayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("화")) {
					amMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void tuesdayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("화")) {
					pmMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void wednesdayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("수")) {
					amMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void wednesdayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("수")) {
					pmMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void thursdayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("목")) {
					amMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void thursdayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("목")) {
					pmMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void fridayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("금")) {
					amMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void fridayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[4].equals("금")) {
					pmMethod(temp);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 연령층별 강좌목록
	public static void child() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[5].equals("어린이")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.list.add(c);

					courseMent(c);
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void teenager() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[5].equals("청소년")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
					
					courseMent(c);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void adult() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[5].equals("성인")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
					
					courseMent(c);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void everyone() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/suding/코드 저장/course_new.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[5].equals("누구나")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					CourseData.list.add(c);
					
					courseMent(c);
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//오전 오후 시간 메소드
	private static void amMethod(String[] temp) {
		String startTime = temp[3].substring(0, 5);
		
		int startHour = Integer.parseInt(startTime.substring(0, 2));
		
		if (startHour >= 1 && startHour < 12) {
			
			Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
					temp[8], temp[9], temp[10], temp[11]);
			
			CourseData.list.add(c);
			courseMent(c);
		}
	}
	
	private static void pmMethod(String[] temp) {
		String startTime = temp[3].substring(0, 5);
		
		int startHour = Integer.parseInt(startTime.substring(0, 2));
		
		if (startHour >= 12 && startHour < 24) {
			
		    Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
		            temp[8], temp[9], temp[10], temp[11]);

		    CourseData.list.add(c);
		    courseMent(c);
		}
	}
	private static void courseMent(Course c) {
		if (c != null) {
			System.out.printf("[%s] 프로그램명 : %s\n", c.getCategory(), c.getLectureName());
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
			System.out.printf("수강료: %s\n", c.getLectureFee());
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
		}
		
		CourseData.list.clear();
	}
//	private static void goBackMent() {
//		System.out.println();
//		System.out.println("0. 뒤로가기 ");
//		System.out.print(">  ");
//	}
//
//	//개인 별 강좌 추천 랜덤으로 뽑는 멘트
//	private static void ment(Course c) {
//
//		//Corse c = CorseData.list.get(rnd.nextInt(CorseData.list.size()));
//		// System.out.println(b);
//		if (c != null) {
//
//			System.out.printf("[%s] 프로그램명 : %s\n", c.getCategory(), c.getLectureName());
//			System.out.printf("강좌코드: \s\n", c.getNum());
//			System.out.println();
//			System.out.printf("강사코드: %s\n", c.getTeacherNum());
//			System.out.println();
//			System.out.printf("시간: %s\n", c.getTime());
//			System.out.println();
//			System.out.printf("요일: %s\n", c.getDay());
//			System.out.println();
//			System.out.printf("대상: %s\n", c.getTarget());
//			System.out.println();
//			System.out.printf("수강료: %s\n", c.getLectureFee());
//			System.out.println();
//			System.out.printf("정원: %s\n", c.getPerson());
//			System.out.println();
//			System.out.printf("강좌내용: %s\n", c.getContents());
//			System.out.println();
//			System.out.printf("강좌시작일: %s\n", c.getStartDay());
//			System.out.println();
//			System.out.printf("강의실 : %s", c.getRoomNum());
//			System.out.println();
//
//		}
//
//	}
}