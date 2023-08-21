package com.project.user.mypage;

public class Course {
	
	private String courseNum;
	private String category;
	private String courseName;
	private String time;
	private String dayOfWeek;
	private String target;
	private String tuition;
	private String numberOfPeople;
	private String teacherNum;
	private String content;
	private String startDate;
	private String roomNum;

	public Course(String courseNum, String category, String courseName, String time, String dayOfWeek, String target,
			String tuition, String numberOfPeople, String teacherNum, String content, String startDate,
			String roomNum) {
		this.courseNum = courseNum;
		this.category = category;
		this.courseName = courseName;
		this.time = time;
		this.dayOfWeek = dayOfWeek;
		this.target = target;
		this.tuition = tuition;
		this.numberOfPeople = numberOfPeople;
		this.teacherNum = teacherNum;
		this.content = content;
		this.startDate = startDate;
		this.roomNum = roomNum;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
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

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Override
	public String toString() {
		return "Course [courseNum=" + courseNum + ", category=" + category + ", courseName=" + courseName + ", time="
				+ time + ", dayOfWeek=" + dayOfWeek + ", target=" + target + ", tuition=" + tuition
				+ ", numberOfPeople=" + numberOfPeople + ", teacherNum=" + teacherNum + ", content=" + content
				+ ", startDate=" + startDate + ", roomNum=" + roomNum + "]";
	}
	
	
	
}
