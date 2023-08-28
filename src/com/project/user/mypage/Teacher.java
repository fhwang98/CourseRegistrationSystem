package com.project.user.mypage;
/**
 * 강사 생성자 클래스입니다.
 * @author 이연섭
 *
 */
public class Teacher {
	
	private String teacherNum;
	private String teacherName;
	/**
	 * 강사 생성자입니다.
	 * @param teacherNum 강사번호
	 * @param teacherName 강사명
	 */
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
