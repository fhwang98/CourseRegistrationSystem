package com.project.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 강의실 스케줄 데이터를 관리하는 클래스입니다.
 * @author eugene
 *
 */
public class RoomScheduleData {
	
	private static ArrayList<RoomSchedule> list;
	
	static {
		list = new ArrayList<RoomSchedule>();
	}

	/**
	 * 강의실 스케줄 데이터가 저장된 리스트를 불러오는 getter입니다.
	 * @return
	 */
	public static ArrayList<RoomSchedule> getList() {
		return list;
	}

	/**
	 * 강의실 스케줄 데이터를 강의실 리스트에 저장하는 메소드 입니다.
	 */
	public static void load() {
		list = new ArrayList<RoomSchedule>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/dataCourse.txt"));
			
			//강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
			
			//얘가 지금 강좌 목록에서 강의실 스케줄 리스트를 만드는 애
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				String roomNum = temp[11];
				String dayOfWeek = temp[4];
				int startTime = Integer.parseInt(temp[3].substring(0, 2));
				String time = String.format("%02d:00-%02d:00", startTime, startTime + 1);
				String courseNum = temp[0];
				list.add(new RoomSchedule(roomNum, dayOfWeek, time, courseNum));
			}
			
			//만든 스케줄 목록에 없는 강의실들(1~50) 스케줄 없는 상태 만들어서 집어넣어
			for (int i = 1; i <= 50; i++) {
				String num = String.format("%03d", i);
				if (!listContains(num)) {
					list.add(new RoomSchedule(num, "_", "_", "_"));
				}
				
			}
			list.sort((s1, s2) -> s1.getTime().compareTo(s2.getTime()));
			list.sort((s1, s2) ->s1.getDayOfWeek().length() - s2.getDayOfWeek().length());
			list.sort((s1, s2) -> s1.getRoomNum().compareTo(s2.getRoomNum()));
			
			
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/dataRoomSchedule.txt"));
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
