package com.project.notice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

public class MakeNoticeDummy {

	public void mkDummy() {
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

		writeFile(list);
	}

	public static void writeFile(ArrayList<Notice> list) {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("data//dataNotice.txt"));

			for (Notice n : list) {
				writer.write(n.toString());
				writer.write("\r\n");
			}

			writer.close();

		} catch (Exception e) {
			System.out.println("at Modifying.main");
			e.printStackTrace();
		}
	}

	public static void makeList(ArrayList<Notice> list) {
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
