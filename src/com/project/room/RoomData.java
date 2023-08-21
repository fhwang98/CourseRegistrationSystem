package com.project.room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RoomData {

	private static ArrayList<Room> list;

	static {
		list = new ArrayList<Room>();
	}

	
	public static ArrayList<Room> getList() {
		return list;
	}


	public static void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data\\roomdummy.txt"));
			String line = null;
			int n = 1;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				RoomData.list.add(new Room(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]));
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("at RoomData.load");
			e.printStackTrace();
		}
	}

}
