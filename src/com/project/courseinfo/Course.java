package com.project.courseinfo;

public class Course {
	
	
//강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
	
	
	
	
	private String num;
	private String category;
	private String lectureName;
	private String Time;
	private String Day;
	private String Target;
	private String lectureFee;
	private String person;
	private String teacherNum;
	private String contents;
	private String startDay;
	private String roomNum;
	
	
	
	public Course(String num, String category, String lectureName, String time, String day, String target,
			String lectureFee, String person, String teacherNum, String contents, String startDay, String roomNum) {
		super();
		this.num = num;
		this.category = category;
		this.lectureName = lectureName;
		Time = time;
		Day = day;
		Target = target;
		this.lectureFee = lectureFee;
		this.person = person;
		this.teacherNum = teacherNum;
		this.contents = contents;
		this.startDay = startDay;
		this.roomNum = roomNum;
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


	public String getLectureName() {
		return lectureName;
	}


	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}


	public String getTime() {
		return Time;
	}


	public void setTime(String time) {
		Time = time;
	}



	public String getDay() {
		return Day;
	}



	public void setDay(String day) {
		Day = day;
	}


	public String getTarget() {
		return Target;
	}


	public void setTarget(String target) {
		Target = target;
	}


	public String getLectureFee() {
		return lectureFee;
	}



	public void setLectureFee(String lectureFee) {
		this.lectureFee = lectureFee;
	}



	public String getPerson() {
		return person;
	}


	public void setPerson(String person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Corse [num=" + num + ", category=" + category + ", lectureName=" + lectureName + ", Time=" + Time
				+ ", Day=" + Day + ", Target=" + Target + ", lectureFee=" + lectureFee + ", person=" + person
				+ ", teacherNum=" + teacherNum + ", contents=" + contents + ", startDay=" + startDay + ", roomNum="
				+ roomNum + "]";
	}


	

	
}
