package com.project.notice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

/** 
 * 공지사항 데이터를 관리하는 클래스입니다.
 * @author eugene
 *
 */
public class NoticeData {
	
	private static ArrayList<Notice> list;
	
	static {
		list = new ArrayList<Notice>(); 
	}
	
	public static ArrayList<Notice> getList() {
		return list;
	}

	/**
	 * ArrayList에 저장된 공지사항 데이터를 파일에 저장하는 메소드입니다.
	 * @param list
	 */
	public static void update(ArrayList<Notice> list) {
		 NoticeData.list = new ArrayList<>();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/dataNotice.txt"));
			
			for (Notice n : list) {
				writer.write(n.toString());
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("at NoticeData.undate");
			e.printStackTrace();
		}
	}

	/** 
	 * 공지사항 데이터 파일을 불러와 ArrayList에 저장하는 메소드 입니다.
	 */
	public static void load() {
		 NoticeData.list = new ArrayList<>();
				try {
					BufferedReader reader = new BufferedReader(new FileReader("data/dataNotice.txt"));
					String line = null;
					while ((line = reader.readLine()) != null) {
						String[] temp = line.split("✡");
						Calendar c = Calendar.getInstance();
						int year = Integer.parseInt(temp[1].substring(0, 4));
						int month = Integer.parseInt(temp[1].substring(5, 7));
						int date = Integer.parseInt(temp[1].substring(8, 10));
						int hour = Integer.parseInt(temp[1].substring(11, 13));
						int min = Integer.parseInt(temp[1].substring(14, 16));
						int sec = Integer.parseInt(temp[1].substring(17, 19));
						c.set(year, month - 1, date, hour, min, sec);
						NoticeData.list.add(new Notice(Integer.parseInt(temp[0]),c,temp[2], temp[3], temp[4]));
					}
					reader.close();
				} catch (Exception e) {
					System.out.println("at NoticeData.setList");
					e.printStackTrace();
				}
	}
	
	/**
	 * 공지사항 더미파일을 만드는 메소드 입니다.
	 */
	public void getDummy() {
		ArrayList<Notice> list = new ArrayList<Notice>();

		//ArrayList 안에 객체들을 만들어서 집어넣음
		makeList(list);

		// 날짜순으로 정렬
		Collections.sort(list, (o1, o2) -> o1.getUploadTime().compareTo(o2.getUploadTime()));

		// 지금 정렬 순서대로 setNo넘버링 다시함
		int num = 1;
		for (Notice n : list) {
			n.setNo(num);
			n.setTitle(String.format("제목%05d", num));
			num++;
		}

		update(list);
	}


	private static void makeList(ArrayList<Notice> list) {
		// 관리자 50명 + 강사 150명
		String[] writerarr = new String[200];
		for (int i = 0; i < 50; i++) {
			writerarr[i] = "A" + String.format("%03d", i + 1);
		}
		for (int i = 0; i < 150; i++) {
			writerarr[i + 50] = "T" + String.format("%03d", i + 1);
		}

		Random rnd = new Random();

		for (int i = 0; i < 50; i++) {

			// 게시 날짜(올해 0101~오늘) 게시 시간(9시 ~ 18시) 난수로 생성
			Calendar c = Calendar.getInstance();
			int todayDayOfYear = c.get(Calendar.DAY_OF_YEAR);
			c.set(Calendar.DAY_OF_YEAR, rnd.nextInt(todayDayOfYear) + 1);
			c.set(Calendar.HOUR_OF_DAY, rnd.nextInt(9) + 9);
			c.set(Calendar.MINUTE, rnd.nextInt(60));

			Notice n = new Notice((i + 1), c, writerarr[rnd.nextInt(70)], "제목입니다.", "내용입니다.\\r\\n여러줄입니다.");
			list.add(n);
		}

	}

	
	
}
