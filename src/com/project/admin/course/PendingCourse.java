package com.project.admin.course;

public class PendingCourse {

	/*
	
	승인대기 강좌 관리
	클래스가 어떻게 생겼는지 
	String 강좌명 -> 이름
	String 요일 -> ‘월’
	String 시작 시간 -> (06~22)
	카테고리 -> 문화, 블럭교실, 피아노, 체육, 어린이
	수강대상 ->. 어린이, 청소년, 성인, 누구나
	강좌 내용
	현재 상태
	강사코드
	
	*/
	
	private String courseName;
	private String dayOfWeek;
	private String startTime;
	private String category;
	private String target;
	private String courseExplanation;
	private String status;
	private String teacherNum;
	
	
	public PendingCourse(String courseName, String dayOfWeek, String startTime, String category, String target,
			String courseExplanation, String status, String teacherNum) {
		this.courseName = courseName;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.category = category;
		this.target = target;
		this.courseExplanation = courseExplanation;
		this.status = status;
		this.teacherNum = teacherNum;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCourseExplanation() {
		return courseExplanation;
	}
	public void setCourseExplanation(String courseExplanation) {
		this.courseExplanation = courseExplanation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	@Override
	public String toString() {
		return courseName + "," + dayOfWeek + "," + startTime
				+ "," + category + "," + target + ","
				+ courseExplanation + "," + status +  "," + teacherNum;
	}
	
	

	
}
