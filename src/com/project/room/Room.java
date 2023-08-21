package com.project.room;

public class Room {
	
	private int no;
	private String name;
	private String dayOfWeek;
	private String occupiedTime;
	private String courseCode;
	
	public Room(int no, String name, String dayOfWeek, String occupiedTime, String courseCode) {
		this.no = no;
		this.name = name;
		this.dayOfWeek = dayOfWeek;
		this.occupiedTime = occupiedTime;
		this.courseCode = courseCode;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getOccupiedTime() {
		return occupiedTime;
	}
	public void setOccupiedTime(String occupiedTime) {
		this.occupiedTime = occupiedTime;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return String.format("%03d", no) + "," + name + "," + dayOfWeek + "," + occupiedTime
				+ "," + courseCode;
	}
	

}
