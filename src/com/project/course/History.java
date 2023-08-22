package com.project.course;

public class History {

	private String historyNum;
	private String memberNum;
	private String courseNum;
	
	public History(String historyNum, String memberNum, String courseNum) {
		this.historyNum = historyNum;
		this.memberNum = memberNum;
		this.courseNum = courseNum;
	}

	public String getHistoryNum() {
		return historyNum;
	}

	public void setHistoryNum(String historyNum) {
		this.historyNum = historyNum;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	@Override
	public String toString() {
		return "History [historyNum=" + historyNum + ", memberNum=" + memberNum + ", courseNum=" + courseNum + "]";
	}
	
	
	
}
