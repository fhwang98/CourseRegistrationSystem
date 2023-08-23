package com.project.admin.course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class PendingCourseData {

	
	private static ArrayList<PendingCourse> list;
	
	static {
		list = new ArrayList<PendingCourse>();
	}
	

	public static ArrayList<PendingCourse> getList() {
		return list;
	}
	
	/*
		private String courseName;
		private String dayOfWeek;
		private String startTime; 숫자 2개만 받음 06~22
		private String category;
		private String target;
		private String capacity; 수강정원 ... 안하기로했는데.... 신청인원...?
		private String courseExplanation;
	
	*/
	
	public static void getDummy() {
		
		String[] dow = {"월", "화", "수", "목", "금"};
		String[] category = {"문화", "블럭교실", "피아노", "체육", "어린이"};
		String[] target = {"어린이", "청소년", "성인", "누구나"};
		
		Random rnd = new Random();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/dataPendingCourse.txt"));

			
			for (int i = 0; i < 30; i++) {
				
				//강좌명, 요일, 시작 시간, 카테고리, 대상, 강좌내용, 상태
				//강좌명1,목,13,블럭교실,청소년,강좌내용1,승인
				//시간은 두자리 숫자 문자열로 받음
				//수강 정원 없음
				PendingCourse p = new PendingCourse("강좌명" +( i + 1)
						, dow[rnd.nextInt(4)], String.format("%02d", rnd.nextInt(15) + 6)
						, category[rnd.nextInt(4)], target[rnd.nextInt(3)]
						, "강좌내용" + (i + 1), "대기", String.format("T%03d", rnd.nextInt(100) + 1));
				writer.write(p.toString());
				writer.newLine();
			}
			writer.close();
			
		} catch (Exception e) {
			System.out.println("at PendingCourseData.getDummy");
			e.printStackTrace();
		}
	}
	
	public static void load() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/dataPendingCourse.txt"));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				list.add(new PendingCourse(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6] ,temp[7]));
			}
			
			
			reader.close();
		} catch (Exception e) {
			System.out.println("at PendingCourseData.load");
			e.printStackTrace();
		}
	}
	
	public static void update() { //덮어쓰기
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/dataPendingCourse"));
			for (PendingCourse p : list) {
				writer.write(p.toString());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("at PendingCourseData.update");
			e.printStackTrace();
		}
	}
	
	
}
