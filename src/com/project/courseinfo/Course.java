package com.project.courseinfo;

public class Course {
	
	
//강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
	
	
	
	
	private String num;
	private String category;
	private String courseName;
	private String time;
	private String day;
	private String target;
	private String courseFee;
	private String person;
	private String teacherNum;
	private String contents;
	private String startDay;
	private String roomNum;
	
	
	public Course(String num, String category, String courseName, String time, String day, String target,
			String courseFee, String person, String teacherNum, String contents, String startDay, String roomNum) {
		
		this.num = num;
		this.category = category;
		this.courseName = courseName;
		this.time = time;
		this.day = day;
		this.target = target;
		this.courseFee = courseFee;
		this.person = person;
		this.teacherNum = teacherNum;
		this.contents = contents;
		this.startDay = startDay;
		this.roomNum = roomNum;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public String getCourseFee() {
		return courseFee;
	}


	public void setCourseFee(String courseFee) {
		this.courseFee = courseFee;
	}


	public String getPerson() {
		return person;
	}


	public void setPerson(String person) {
		this.person = person;
	}


	public String getTeacherNum() {
		return teacherNum;
	}


	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getStartDay() {
		return startDay;
	}


	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}


	public String getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}


	@Override
	public String toString() {
		return "Course [num=" + num + ", category=" + category + ", courseName=" + courseName + ", time=" + time
				+ ", day=" + day + ", target=" + target + ", courseFee=" + courseFee + ", person=" + person
				+ ", teacherNum=" + teacherNum + ", contents=" + contents + ", startDay=" + startDay + ", roomNum="
				+ roomNum + "]";
	}
	
	
}
	
	
	
	