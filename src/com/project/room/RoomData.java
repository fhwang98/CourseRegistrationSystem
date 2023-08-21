package com.project.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RoomData {

	private static ArrayList<Room> roomList;
	
	static {
		roomList = new ArrayList<Room>();
	}
	
	
	public static ArrayList<Room> getRoomList() {
		return roomList;
	}


	public static void load() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data//dataRoomSchedule.txt"));
			String line = null;
			//강의실 코드, 요일, 시간, 강좌 코드
			//101,월화수목금,09:00,C001
			while ((line = reader.readLine()) != null) {
				String temp[] = line.split(",");
				//String roomNum = temp[0];
				String schedule = temp[1] + " " + temp[2] + " (" + temp[3] + ")";

				int idx = getIdx(temp[0]);
				
				if (idx == -1) {
					ArrayList<String> scheduleList = new ArrayList<String>();
					scheduleList.add(schedule);
					roomList.add(new Room(temp[0], "", scheduleList));
				} else {
					roomList.get(idx).getSchedule().add(schedule);
				}
			
			}
			reader.close();
			
			roomList.sort((Room r1, Room r2) -> r1.getRoomNum().compareTo(r2.getRoomNum()));
			
			int n = 101;
			for(Room r : roomList) {
				r.setRoomName(String.format("%d호", n++));
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("data//dataRoom.txt"));
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


	private static int getIdx(String roomNum) {
		for (int i =0 ; i < roomList.size(); i++) {
			if (roomList.get(i).getRoomNum().equals(roomNum)) {
				return i;
			}
		}
		return -1;
	}
	
}
