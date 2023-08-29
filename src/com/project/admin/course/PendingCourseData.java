package com.project.admin.course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * 승인 대기 중인 강좌의 데이터를 관리하는 클래스 입니다.
 * @author eugene
 *
 */
public class PendingCourseData {


	private static ArrayList<PendingCourse> list;
	
	static {
		list = new ArrayList<PendingCourse>();
	}
	
	/**
	 * 승인 대기중 강좌 데이터를 저장한 리스트를 불러올 getter입니다.
	 * @return 승인 대기 강좌 리스트
	 */
	public static ArrayList<PendingCourse> getList() {
		return list;
	}

	/**
	 * 승인 대기중 강좌를 승인상태에 따라 정렬하는 메소드 입니다.
	 */
	public static void sortList() {
		
		ArrayList<PendingCourse> sortedList = new ArrayList<PendingCourse>();
		
		for (PendingCourse p : list) {
			if (p.getStatus().equals("대기")) {
				sortedList.add(p);
			}
		}
		for (PendingCourse p : list) {
			if (p.getStatus().equals("반려")) {
				sortedList.add(p);
			}
		}
		for (PendingCourse p : list) {
			if (p.getStatus().equals("승인")) {
				sortedList.add(p);
			}
		}
		list = sortedList;
		
	}
	

	/**
	 * 승인대기 강좌의 더미데이터를 생성하는 메소드입니다.
	 */
	public static void getDummy() {
		
		String[] dow = {"월", "화", "수", "목", "금"};
		String[] category = {"문화", "블럭교실", "피아노", "체육", "어린이"};
		String[] target = {"어린이", "청소년", "성인", "누구나"};
		String[] status = {"대기", "반려"};
		
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
						, "강좌내용" + (i + 1), status[rnd.nextInt(2)] , String.format("T%03d", rnd.nextInt(100) + 1), "없음", "없음");
				writer.write(p.toString());
				writer.newLine();
			}
			writer.close();
			
		} catch (Exception e) {
			System.out.println("at PendingCourseData.getDummy");
			e.printStackTrace();
		}
	}
	
	/**
	 * 승인대기 강좌의 데이터를 파일에서 불러와 ArrayList에 저장하는 메소드 입니다.
	 */
	public static void load() {
		list = new ArrayList<PendingCourse>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/dataPendingCourse.txt"));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				list.add(new PendingCourse(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6] ,temp[7], temp[8], temp[9]));
			}
			
			PendingCourseData.sortList();

			reader.close();
		} catch (Exception e) {
			System.out.println("at PendingCourseData.load");
			e.printStackTrace();
		}
	}
	
	/**
	 * 승인 대기 강좌의 ArrayList를 파일에 저장하는 메소드 입니다.
	 */
	public static void update() { //덮어쓰기
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/dataPendingCourse.txt"));
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
	
	/**
	 * 승인대기 강좌 하나를 파일에 추가하는 메소드입니다.
	 * @param PendingCourse 객체
	 */
	public static void update(PendingCourse p) { //이어쓰기
	      try {
	         BufferedWriter writer = new BufferedWriter(new FileWriter("data\\dataPendingCourse.txt", true));
	         
	         writer.write(p.toString());
	         
	         writer.newLine();
	         
	         writer.close();
	      } catch (Exception e) {
	         System.out.println("at PendingCourseData.update");
	         e.printStackTrace();
	      }
	   }
}
