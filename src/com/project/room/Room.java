package com.project.room;

import java.util.ArrayList;

/**
 * 강의실의 데이터를 저장할 클래스 입니다.
 * @author eugene
 *
 */
public class Room {
	
	private String roomNum;
	private ArrayList<String> schedule;
	
	/**
	 * 강의실 클래스를 만드는 생성자입니다.
	 * @param roomNum
	 * @param schedule
	 */
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
