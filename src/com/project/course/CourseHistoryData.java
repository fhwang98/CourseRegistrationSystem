package com.project.course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 수강 내역 정보를 가져오고 저장하는 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class CourseHistoryData {

	public static ArrayList<CourseHistory> historyList;

	static {
		CourseHistoryData.historyList = new ArrayList<CourseHistory>();
	}

	/**
	 * 수강 내역 정보를 파일에서 읽어와 리스트에 저장하는 메소드입니다.
	 */
	public static void load() {

		try {

			BufferedReader historyReader = new BufferedReader(new FileReader("data/courseHistory.txt"));

			String line = null;

			while ((line = historyReader.readLine()) != null) {

				String[] temp = line.split(",");

				CourseHistory h = new CourseHistory(temp[0], temp[1], temp[2]);

				CourseHistoryData.historyList.add(h);

			}

			historyReader.close();

		} catch (Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}

	}

	/**
	 * 수강 내역 정보를 저장하는 메소드입니다.
	 */
	public static void save() {

		try {

			BufferedWriter historyWriter = new BufferedWriter(
					new FileWriter("data/courseHistory.txt"));

			for (CourseHistory m : CourseHistoryData.historyList) {

				historyWriter
						.write(String.format("%s,%s,%s\r\n", m.getHistoryNum(), m.getMemberNum(), m.getCourseNum()));
			}

			historyWriter.close();

		} catch (Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}

	}

}
