package com.project.course;

public class Teacher {

	//코드, 아이디, 비번, 이름, 전번, 생년월일, 탈퇴여부
	private String teacherCode;
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	private String birthDay;
	private String out;
	
	
	
	
	public Teacher(String teacherCode, String id, String pw, String name, String phoneNum, String birthDay,
			String out) {
		super();
		this.teacherCode = teacherCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthDay = birthDay;
		this.out = out;
	}
	public String getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	
	
	
	@Override
	public String toString() {
		return "Teacher [teacherCode=" + teacherCode + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phoneNum="
				+ phoneNum + ", birthDay=" + birthDay + ", out=" + out + "]";
	}
}
