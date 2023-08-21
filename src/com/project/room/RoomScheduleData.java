package com.project.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RoomScheduleData {
	
	private static ArrayList<RoomSchedule> list;
	
	static {
		list = new ArrayList<RoomSchedule>();
	}

	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data//dataCourse.txt"));
			
			//강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				String roomNum = temp[11];
				String dayOfWeek = temp[4];
				String time = temp[3];
				String courseNum = temp[0];
				list.add(new RoomSchedule(roomNum, dayOfWeek, time, courseNum));
			}
			
			for (int i = 1; i < 1000; i++) {
				String num = String.format("%03d", i);
				if (!listContains(num)) {
					list.add(new RoomSchedule(num, "_", "_", "_"));
				}
				
			}
			list.sort((s1, s2) -> s1.getTime().compareTo(s2.getTime()));
			list.sort((s1, s2) ->s1.getDayOfWeek().length() - s2.getDayOfWeek().length());
			list.sort((s1, s2) -> s1.getRoomNum().compareTo(s2.getRoomNum()));
			
			
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter("data//dataRoomSchedule.txt"));
			for (RoomSchedule s : list) {
				writer.write(s.toString());
				writer.newLine();
			}
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println("at RoomScheduleData.load");
			e.printStackTrace();
		}
	}

	private static boolean listContains(String num) {
		// TODO Auto-generated method stub
		
		for (RoomSchedule s : list) {
			if (s.getRoomNum().equals(num)) {
				return true;
			}
		}
		return false;
		
	}
	
	
}
