package com.project.course;

public class Teacher {
	
	private String teacherNum;
	private String teacherName;

	public Teacher(String teacherNum, String teacherName) {
		this.teacherNum = teacherNum;
		this.teacherName = teacherName;
	}

	public String getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Teacher [teacherNum=" + teacherNum + ", teacherName=" + teacherName + "]";
	}
	
}
