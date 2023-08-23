package com.project.course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CourseHistoryData {

	public static ArrayList<CourseHistory> historyList;

	static {
		CourseHistoryData.historyList = new ArrayList<CourseHistory>();
	}

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
