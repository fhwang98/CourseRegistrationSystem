package com.project.notice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class NoticeData {
	
	private static ArrayList<Notice> list;
	
	static {
		list = new ArrayList<Notice>(); 
	}
	
	public static ArrayList<Notice> getList() {
		return list;
	}

	public static void update(ArrayList<Notice> list) {
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

	public static void load() {
		
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
						//writer 이름으로 바꿔야됨 관리자, 강사 객체 필요 일단 보류
						NoticeData.list.add(new Notice(Integer.parseInt(temp[0]),c,temp[2], temp[3], temp[4]));
					}
					reader.close();
				} catch (Exception e) {
					System.out.println("at NoticeData.setList");
					e.printStackTrace();
				}
	}
	
}
