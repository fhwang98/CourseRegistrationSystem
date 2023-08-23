package com.project.courseinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.project.course.Teacher;


public class CourseData {

	static Scanner scan = new Scanner(System.in);
	
	public static ArrayList<Course> courseList;
	public static ArrayList<Teacher> teacherList;
	public static HashMap<String, Course> map ;
	
	static {

		CourseData.courseList = new ArrayList<Course>();
		CourseData.teacherList = new ArrayList<Teacher>();
		CourseData.map = new HashMap<String, Course>();
	}
	
//전체 강좌 ArrayList
	public static void allCourseList() {

		try {
			BufferedReader allReader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			String line = null;

			while ((line = allReader.readLine()) != null) {

				String[] temp = line.split(",");

				Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
						temp[9], temp[10], temp[11]);

				courseList.add(c);
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// 전체 강좌 HashMap
	public static void allCourseMap() {

		try {
			BufferedReader allReader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			String line = null;

			try {
				while ((line = allReader.readLine()) != null) {

					String[] temp = line.split(",");

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
							temp[8], temp[9], temp[10], temp[11]);

					map.put(temp[0], c);

				}
				System.out.println(map);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	// 수강신청

	// 개인별 강좌 추천 문화 선택
	public static void cultureRecommend() {

		try {
			Random rnd = new Random();

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[1].equals("문화")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
							temp[8], temp[9], temp[10], temp[11]);

					String tempValue = c.getStartDay();

					int year = Integer.parseInt(tempValue.substring(0, 4));
					int month = Integer.parseInt(tempValue.substring(4, 6));

					Calendar nowTime = Calendar.getInstance();
					Calendar courseTime = Calendar.getInstance();

					courseTime.set(year, month - 1, 1);

					long courseTimeTick = courseTime.getTimeInMillis();
					long nowTimeTick = nowTime.getTimeInMillis();

					long gap = nowTimeTick - courseTimeTick;

					// 여기까지

					if (gap < 0) {
						CourseData.courseList.add(c);
					}
				}
			}

			line = null;
			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			Course c = CourseData.courseList.get(rnd.nextInt(CourseData.courseList.size()));
			
			for (Teacher t : CourseData.teacherList) {
				if (t.getTeacherNum().equals(c.getTeacherNum())) {
					courseMent(c,t);
				}
			}
//			ment(rnd, reader);

			reader.close();
			reader2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//개인별 강좌 추천 체육 선택
	public static void sportsRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("체육")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					String tempValue = c.getStartDay();

					int year = Integer.parseInt(tempValue.substring(0, 4));
					int month = Integer.parseInt(tempValue.substring(4, 6));

					Calendar nowTime = Calendar.getInstance();
					Calendar courseTime = Calendar.getInstance();

					courseTime.set(year, month - 1, 1);

					long courseTimeTick = courseTime.getTimeInMillis();
					long nowTimeTick = nowTime.getTimeInMillis();

					long gap = nowTimeTick - courseTimeTick;

					// 여기까지

					if (gap < 0) {
						CourseData.courseList.add(c);
					}
				}
			}
			
			line = null;
			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			Course c = CourseData.courseList.get(rnd.nextInt(CourseData.courseList.size()));
			
			for (Teacher t : CourseData.teacherList) {
				if (t.getTeacherNum().equals(c.getTeacherNum())) {
					courseMent(c,t);
				}
			}
			//courseMent(c);
			//ment(rnd, reader);
			
			reader.close();
			reader2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//개인별 강좌 추천 피아노 선택
	public static void pianoRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				
				String[] temp = line.split(",");
				
				
				if (temp[1].equals("피아노")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					String tempValue = c.getStartDay();

					int year = Integer.parseInt(tempValue.substring(0, 4));
					int month = Integer.parseInt(tempValue.substring(4, 6));

					Calendar nowTime = Calendar.getInstance();
					Calendar courseTime = Calendar.getInstance();

					courseTime.set(year, month - 1, 1);

					long courseTimeTick = courseTime.getTimeInMillis();
					long nowTimeTick = nowTime.getTimeInMillis();

					long gap = nowTimeTick - courseTimeTick;

					// 여기까지

					if (gap < 0) {
						CourseData.courseList.add(c);
					}
				}
			}
			
			line = null;
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
			
			}

			Course c = CourseData.courseList.get(rnd.nextInt(CourseData.courseList.size()));
			
			for (Teacher t : CourseData.teacherList) {
				if (t.getTeacherNum().equals(c.getTeacherNum())) {
					courseMent(c,t);
				}
			}
			//courseMent(c);
			//ment(rnd, reader);

			reader.close();
			reader2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//개인별 강좌 추천 어린이 선택
	public static void kidsRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("어린이")) {
					
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					String tempValue = c.getStartDay();

					int year = Integer.parseInt(tempValue.substring(0, 4));
					int month = Integer.parseInt(tempValue.substring(4, 6));

					Calendar nowTime = Calendar.getInstance();
					Calendar courseTime = Calendar.getInstance();

					courseTime.set(year, month - 1, 1);

					long courseTimeTick = courseTime.getTimeInMillis();
					long nowTimeTick = nowTime.getTimeInMillis();

					long gap = nowTimeTick - courseTimeTick;

					// 여기까지

					if (gap < 0) {
						CourseData.courseList.add(c);
					}
				}
			}
			line = null;
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
			
			}
			
			Course c = CourseData.courseList.get(rnd.nextInt(CourseData.courseList.size()));
			
			for (Teacher t : CourseData.teacherList) {
				if (t.getTeacherNum().equals(c.getTeacherNum())) {
					courseMent(c,t);
				}
			}
			//courseMent(c);
			//ment(rnd, reader);

			reader.close();
			reader2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//개인별 강좌 추천 블럭교실 선택
	public static void blockRecommend() {
		
		try {
			Random rnd = new Random();
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (temp[1].equals("블럭교실")) {
					// 강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);
					
					String tempValue = c.getStartDay();

					int year = Integer.parseInt(tempValue.substring(0, 4));
					int month = Integer.parseInt(tempValue.substring(4, 6));

					Calendar nowTime = Calendar.getInstance();
					Calendar courseTime = Calendar.getInstance();

					courseTime.set(year, month - 1, 1);

					long courseTimeTick = courseTime.getTimeInMillis();
					long nowTimeTick = nowTime.getTimeInMillis();

					long gap = nowTimeTick - courseTimeTick;

					// 여기까지

					if (gap < 0) {
						CourseData.courseList.add(c);
					}
				}
			}
			
			line = null;
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
			
			}
			
			Course c = CourseData.courseList.get(rnd.nextInt(CourseData.courseList.size()));
			
			for (Teacher t : CourseData.teacherList) {
				if (t.getTeacherNum().equals(c.getTeacherNum())) {
					courseMent(c,t);
				}
			}
			//courseMent(c);
			//ment(rnd, reader);
			

			reader.close();
			reader2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//강좌 전체 목록
	public static void allList() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;

			System.out.println("===================================");
			System.out.println("전체 강좌");
			System.out.println("===================================");
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
			}
			
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
						temp[9], temp[10], temp[11]);

				CourseData.courseList.add(c);

				for (Teacher t : CourseData.teacherList) {
					if (t.getTeacherNum().equals(c.getTeacherNum())) {
						courseMent(c,t);
					}
				}
			}
			
//			line = null;
			
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//강좌 카테고리별 목록
	
	//카테고리 문화 선택 시 
	public static void cultureList() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;

			
			System.out.println("===================================");
			System.out.println("문화");
			System.out.println("===================================");
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
			}	

			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");

				if (temp[1].equals("문화")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
					
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
//					courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//카테고리 피아노 선택시
	public static void pianoList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("피아노");
			System.out.println("===================================");
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
			}	

			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");

				if (temp[1].equals("피아노")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
					
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
//					courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//카테고리 스포츠 선택시
	public static void sportsList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("체육");
			System.out.println("===================================");
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
			}	

			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");

				if (temp[1].equals("체육")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
					
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
//					courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//카테고리 어린이 선택시
	public static void kidsList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("어린이");
			System.out.println("===================================");
			
			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
			}	

			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");

				if (temp[1].equals("어린이")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
					
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
//					courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//카테고리 블럭 선택시
	public static void blockList() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;
			
			System.out.println("===================================");
			System.out.println("블럭교실");
			System.out.println("===================================");
			
while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
			}	

			while ((line = reader.readLine()) != null) {


				String[] temp = line.split(",");

				if (temp[1].equals("블럭교실")) {

					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
					
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
//					courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//요일 시간별 강좌목록
	//월요일 오전 선택시
	public static void mondayAmTime() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("월")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 1 && startHour < 12) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//월요일 오후 선택시
	public static void mondayPmTime() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("월")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 12 && startHour < 24) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						// CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void tuesdayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("화")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 1 && startHour < 12) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static void tuesdayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("화")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 12 && startHour < 24) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						// CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public static void wednesdayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("수")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 1 && startHour < 12) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void wednesdayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("수")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 12 && startHour < 24) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						// CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


		
	}
	public static void thursdayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("목")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 1 && startHour < 12) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void thursdayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("목")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 12 && startHour < 24) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						// CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void fridayAmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("금")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 1 && startHour < 12) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void fridayPmTime() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));

			String line = null;

			while ((line = reader2.readLine()) != null) {

				String[] temp = line.split(",");

				Teacher t = new Teacher(temp[0], temp[3]);

				CourseData.teacherList.add(t);

			}
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[4].equals("금")) {

					String startTime = temp[3].substring(0, 5);

					int startHour = Integer.parseInt(startTime.substring(0, 2));

					if (startHour >= 12 && startHour < 24) {

						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
								temp[8], temp[9], temp[10], temp[11]);

						CourseData.courseList.add(c);

						// CourseData.courseList.add(c);

						for (Teacher t : CourseData.teacherList) {
							if (t.getTeacherNum().equals(c.getTeacherNum())) {
								courseMent(c, t);
							}
						}
					}
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 연령층별 강좌목록
	
	//어린이 선택 시
	public static void child() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;

			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
				
			}	

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[5].equals("어린이")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
				
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
					//courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//연령층별  청소년 선택시
	public static void teenager() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;

			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
				
			}	

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[5].equals("청소년")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
				
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
					//courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//연령층별 성인 선택시
	public static void adult() {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;

			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
				
			}	

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[5].equals("성인")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
				
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
					//courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	//연령층별 누구나 선택 시
	public static void everyone() {
		try {
			

			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			String line = null;

			while ((line = reader2.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0], temp[3]);
				
				CourseData.teacherList.add(t);
				
				
			}	

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[5].equals("누구나")) {
					Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
							temp[9], temp[10], temp[11]);

					CourseData.courseList.add(c);
				
					for (Teacher t : CourseData.teacherList) {
						if (t.getTeacherNum().equals(c.getTeacherNum())) {
							courseMent(c,t);
						}
					}
					//courseMent(c);
				}
			}
			reader.close();
			reader2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//오전 시간 메소드
//	private static void amMethod(String[] temp) {
//		String startTime = temp[3].substring(0, 5);
//		
//		int startHour = Integer.parseInt(startTime.substring(0, 2));
//		
//		if (startHour >= 1 && startHour < 12) {
//			
//			Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
//					temp[8], temp[9], temp[10], temp[11]);
//			
//			CourseData.courseList.add(c);
//			courseMent(c);
//		}
//	}
	
	//오후 시간 메소드
//	private static void pmMethod(String[] temp) {
//		String startTime = temp[3].substring(0, 5);
//		
//		int startHour = Integer.parseInt(startTime.substring(0, 2));
//		
//		if (startHour >= 12 && startHour < 24) {
//			
//		    Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
//		            temp[8], temp[9], temp[10], temp[11]);
//
//		    CourseData.courseList.add(c);
//		    courseMent(c);
//		}
//	}
	
	private static void courseMent(Course c, Teacher t) {
		if (c != null) {
			System.out.printf("[%s] 프로그램명 : %s\n", c.getCategory(), c.getCourseName());
			System.out.println();
			System.out.printf("강좌코드: %s\n", c.getNum());
			System.out.println();
			System.out.printf("강사명: %s\n", t.getTeacherName());
			System.out.println();
			System.out.printf("시간: %s\n", c.getTime());
			System.out.println();
			System.out.printf("요일: %s\n", c.getDay());
			System.out.println();
			System.out.printf("대상: %s\n", c.getTarget());
			System.out.println();
			System.out.printf("수강료: %s\n", c.getCourseFee());
			System.out.println();
			System.out.printf("신청인원: %s\n", c.getPerson());
			System.out.println();
			System.out.printf("강좌내용: %s\n", c.getContents());
			System.out.println();
			System.out.printf("강좌시작일: %s\n", c.getStartDay());
			System.out.println();
			System.out.printf("강의실 : %s\n", c.getRoomNum());
			System.out.println("-----------------------------------------");
			System.out.println();
		}
		
		CourseData.courseList.clear();
	}



}