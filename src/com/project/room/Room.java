package com.project.room;

import java.util.ArrayList;

public class Room {
	
	private String roomNum;
	private String roomName;
	private ArrayList<String> schedule;
	
	
	public Room(String roomNum, String roomName, ArrayList<String> schedule) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.schedule = schedule;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public ArrayList<String> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return roomNum + "," + roomName + "," + schedule;
	}
	
	
}
