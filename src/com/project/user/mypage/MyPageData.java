package com.project.user.mypage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * 데이터를 불러오고 저장하기 위한 클래스입니다.
 * @author 이연섭
 *
 */
public class MyPageData {
	/**
	 * 회원 데이터를 저장하기 위한 배열입니다.
	 */
	public static ArrayList<Member> memberList;
	
	static {
		MyPageData.memberList = new ArrayList<Member>();
	}
	/**
	 * 수강 내역을 저장하기 위한 배열입니다.
	 */
	public static ArrayList<History> historyList;
	
	static {
		MyPageData.historyList = new ArrayList<History>();
	}
	/**
	 * 강좌 데이터를 저장하기 위한 배열입니다.
	 */
	public static ArrayList<Course> courseList;
	
	static {
		MyPageData.courseList = new ArrayList<Course>();
	}
	/**
	 * 강사 데이터를 저장하기 위한 배열입니다.
	 */
	public static ArrayList<Teacher> teacherList;
	
	static {
		MyPageData.teacherList = new ArrayList<Teacher>();
	}
	/**
	 * 데이터를 각 배열에 저장하기 위한 메서드입니다.
	 */
	public static void load() {
		
		try {
			
			BufferedReader memberReader = new BufferedReader(new FileReader("data/dataMember.txt"));
			BufferedReader historyReader = new BufferedReader(new FileReader("data/courseHistory.txt"));
			BufferedReader courseReader = new BufferedReader(new FileReader("data/dataCourse.txt"));			
			BufferedReader teacherReader = new BufferedReader(new FileReader("data/dataTeacher.txt"));
			
			memberList.clear();
			historyList.clear();
			courseList.clear();
			teacherList.clear();
			
			String line = null;
			
			while ((line = memberReader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Member m = new Member(temp[0]
									, temp[1]
									, temp[2]
									, temp[3]
									, temp[4]
									, temp[5]
									, temp[6]
									, temp[7]
									, temp[8]
									, temp[9]);
				
				MyPageData.memberList.add(m);
				
			}

			while ((line = historyReader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				History h = new History(temp[0]
									  , temp[1]
									  , temp[2]);
				
				MyPageData.historyList.add(h);
				
			}
			
			while ((line = courseReader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Course c = new Course(temp[0]
									, temp[1]
									, temp[2]
									, temp[3]
									, temp[4]
									, temp[5]
									, temp[6]
									, temp[7]
									, temp[8]
									, temp[9]
									, temp[10]
									, temp[11]);
				
				MyPageData.courseList.add(c);
				
			}

			while ((line = teacherReader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Teacher t = new Teacher(temp[0]
									  , temp[3]);
				
				MyPageData.teacherList.add(t);
				
			}

			
			memberReader.close();
			historyReader.close();
			courseReader.close();
			teacherReader.close();
			
		} catch (Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
		
	}

	/**
	 * 배열의 값을 데이터에 다시 덮어쓰기 위한 메서드입니다.
	 */
	public static void save() {

		
		try {

			BufferedWriter memberWriter = new BufferedWriter(new FileWriter("data/dataMember.txt"));
			BufferedWriter historyWriter = new BufferedWriter(new FileWriter("data/courseHistory.txt"));
			
			for (Member m : MyPageData.memberList) {
				
				memberWriter.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
						, m.getNo()
						, m.getId()
						, m.getPwd()
						, m.getName()
						, m.getPhoneNum()
						, m.getBirth()
						, m.getDiscount()
						, m.getBank()
						, m.getAccountNum()
						, m.getDelete()));
			}
			
			for (History m : MyPageData.historyList) {
				
				historyWriter.write(String.format("%s,%s,%s\r\n"
						, m.getHistoryNum()
						, m.getMemberNum()
						, m.getCourseNum()));
			}
			
			memberWriter.close();
			historyWriter.close();
			
		} catch (Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
		
	}
	
}
