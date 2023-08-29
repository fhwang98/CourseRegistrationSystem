package com.project.course;

/**
 * 강사 정보를 저장하기 위한 클래스입니다.
 * 
 */
public class Teacher {
	
	private String teacherNum;
	private String teacherName;

	/**
	 * 생성자로, 강사 정보를 초기화 합니다.
	 * @param teacherNum 강사코드
	 * @param teacherName 강사이름
	 */
	public Teacher(String teacherNum, String teacherName) {
		this.teacherNum = teacherNum;
		this.teacherName = teacherName;
	}

	/**
	 * 강사 코드를 반환합니다.
	 * @return 강사 코드
	 */
	public String getTeacherNum() {
		return teacherNum;
	}

	/**
	 * 강사 코드를 설정합니다.
	 * @param teacherNum 강사코드
	 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

	/**
	 * 강사 이름을 반환합니다.
	 * 
	 * @return 강사이름
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * 강사 이름을 설정합니다.
	 * @param teacherName 강사이름
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * 객체 정보를 문자열로 반환합니다.
	 * @return 객체 정보 문자열
	 */
	@Override
	public String toString() {
		return "Teacher [teacherNum=" + teacherNum + ", teacherName=" + teacherName + "]";
	}
	
}
