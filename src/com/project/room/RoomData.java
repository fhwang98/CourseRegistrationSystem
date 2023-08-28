package com.project.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 강의실 데이터를 관리하는 클래스입니다.
 * @author eugene
 *
 */
public class RoomData {

	private static ArrayList<Room> roomList;
	
	static {
		roomList = new ArrayList<Room>();
	}
	
	/**
	 * 강의실 데이터가 담긴 리스트를 불러올 getter입니다.
	 * @return
	 */
	public static ArrayList<Room> getRoomList() {
		return roomList;
	}

	/**
	 * 강의실스케줄 파일을 불러와 강의실 리스트를 저장하는 메소드 입니다.
	 */
	public static void load() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/dataRoomSchedule.txt"));
			
			
			String line = null;
			
			//강의실 코드, 요일, 시간, 강좌 코드
			//101,월화수목금,09:00,C001
			
			while ((line = reader.readLine()) != null) {
				String temp[] = line.split(",");
				//String roomNum = temp[0];
				//강의실 넘버, 스케줄, 강좌 코드 
				String schedule = temp[1] + " " + temp[2] + " (" + temp[3] + ")";

				//강의실 번호의 인덱스를 가져와
				int idx = getIdx(temp[0]);
				ArrayList<String> scheduleList = new ArrayList<String>();
				
				if (idx == -1) {
					//인덱스를 못찾았다 = 강의실 데이터 아직 안쌓았다 
					scheduleList.add(schedule);
					roomList.add(new Room(temp[0], scheduleList));
				} else {
					roomList.get(idx).getSchedule().add(schedule);
					sortSchedule(idx);//
				}
			
			}
			reader.close();
			
			roomList.sort((Room r1, Room r2) -> r1.getRoomNum().compareTo(r2.getRoomNum()));


			
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/dataRoom.txt"));
			for (Room r : roomList) {
				writer.write(r.toString());
				writer.newLine();
			}
			writer.close();
			
		} catch (Exception e) {
			System.out.println("at RoomData.load");
			e.printStackTrace();
		}
		
	}


	private static void sortSchedule(int idx) {
//
		ArrayList<String> schedule = roomList.get(idx).getSchedule();
		ArrayList<String> sortedList = new ArrayList<String>();
		
		for (String s : schedule) {
			if (s.contains("월")) {
				sortedList.add(s);
			}
		}
		for (String s : schedule) {
			if (s.contains("화")) {
				sortedList.add(s);
			}
		}
		for (String s : schedule) {
			if (s.contains("수")) {
				sortedList.add(s);
			}
		}
		for (String s : schedule) {
			if (s.contains("목")) {
				sortedList.add(s);
			}
		}
		for (String s : schedule) {
			if (s.contains("금")) {
				sortedList.add(s);
			}
		}
		roomList.get(idx).setSchedule(sortedList);
	}


	private static int getIdx(String roomNum) {
		
		//ArrayList 를 전부 돌면서 해당 객체의 roomNum이 인자와 일치하는지 확인해
		//인덱스 반환해줄거라서 for문
		for (int i =0 ; i < roomList.size(); i++) {
			if (roomList.get(i).getRoomNum().equals(roomNum)) {
				return i;
			}
		}
		return -1;
	}
	
}
