package com.project.room;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class MakeRoomDummy {

	public static void main(String[] args) {

		mkdummy();
	}

	public static void mkdummy() {
		ArrayList<Room> list = new ArrayList<Room>(); 
		makeList(list);
		writeFile(list);
	}

	public static void writeFile(ArrayList<Room> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data//roomdummy.txt"));
			
			for (Room r : list) {
				writer.write(r.toString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void makeList(ArrayList<Room> list) {
		String[] days = {"월", "화", "수", "목", "금"};

		Random rnd = new Random();
		String[] courses = new String[20];
		for (int i = 0; i < 19; i++) {
			courses[i] = String.format("ABC%03d", i+1);
		}
		courses[19] ="empty";
		
		for (int i = 0; i < 20; i++) { //강의실 루프
			
			String name = String.format("%d호", 101 + 100*(i/5) + i%5); 
			String courseCode = courses[rnd.nextInt(20)];
			//여기서 강좌가 없음이면 다음 강의실로 넘어감
			if (courseCode.equals("empty")) {
				
				Room r = new Room(i + 1, name, "empty", "empty", courseCode); 
				list.add(r);
				continue;
			}
			
			for (int j = 0; j < rnd.nextInt(10)+1; j++) { //스케줄 루프 빈강의실 걸렀으니까 무조건 1개 이상
				
				courseCode = courses[rnd.nextInt(19)];
				String dayOfWeek = days[rnd.nextInt(5)];
				String time = String.format("%02d:00", rnd.nextInt(15) + 6);
				String schedule = i + dayOfWeek + time + courseCode;
				
				
				if (isDuplicate(schedule, list)) {
					
					i--;
					
				} else {
					
					Room r = new Room(i + 1, name, dayOfWeek, time, courseCode); 
					list.add(r);
					
				}
				
			}
		}
	}

	private static boolean isDuplicate(String schedule, ArrayList<Room> list) {
		
		for (Room r : list) {
			
			String rschedule = r.getNo()+r.getDayOfWeek()+r.getOccupiedTime();
			
			if (rschedule.equals(schedule)) {
				return true;
			}
		}
		
		return false;
	}
	
}
