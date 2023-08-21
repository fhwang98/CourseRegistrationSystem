package com.project.room;

public class RoomSchedule {

	private String roomNum;
	private String dayOfWeek;
	private String time;
	private String courseNum;
	
	
	public RoomSchedule(String roomNum, String dayOfWeek, String time, String courseNum) {
		this.roomNum = roomNum;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.courseNum = courseNum;
	}
	

	public String getRoomNum() {
		return roomNum;
	}


	public String getDayOfWeek() {
		return dayOfWeek;
	}


	public String getTime() {
		return time;
	}


	public String getCourseNum() {
		return courseNum;
	}


	@Override
	public String toString() {
		return roomNum + "," + dayOfWeek + "," + time + ","+ courseNum;
	}	
	
}
