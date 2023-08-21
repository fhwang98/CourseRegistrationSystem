package com.project.room;

import java.util.ArrayList;

public class Room {
	
	private String roomNum;
	private ArrayList<String> schedule;
	
	
	public Room(String roomNum, ArrayList<String> schedule) {
		this.roomNum = roomNum;
		this.schedule = schedule;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public ArrayList<String> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return roomNum  + "," + schedule;
	}
	
	
}
