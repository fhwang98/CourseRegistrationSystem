package com.project.user.data;


/**
 * 
 * 강사 회원 데이터가 담긴 클래스
 *
 */

public class DataTeacher {
	private String teacherCode; 
	private String id; 
	private String password; 
	private String name; 
	private String tel; 
	private String birth;
	private int using;
	
	public DataTeacher() {
		this.teacherCode = "";
		this.id = "";
		this.password = "";
		this.name = "";
		this.tel = "";
		this.birth = "";
		this.using = 0;
	}	
	
	public DataTeacher(String[] teacherLine) {
		this.setDataTeacher(teacherLine);
	}
	
	public void setDataTeacher(String[] teacherLine) {
		this.teacherCode = teacherLine[0];
		this.id = teacherLine[1];
		this.password = teacherLine[2];
		this.name = teacherLine[3];
		this.tel = teacherLine[4];
		this.birth = teacherLine[5];
		this.using = Integer.parseInt(teacherLine[6]);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		String temp = tel.replaceAll("-","");
		this.tel = temp;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getUsing() {
		return using;
	}

	public void setUsing(int using) {
		this.using = using;
	}

	@Override
	public String toString() {
		return teacherCode + "," + id + "," + password + "," + name
				+ "," + tel + "," + birth + ","	+ using;
	}	
	
	
	
	
		
}
