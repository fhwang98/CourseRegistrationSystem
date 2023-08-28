package com.project.user.mypage;
/**
 * 강좌 내역 생성자 클래스입니다.
 * @author 이연섭
 *
 */
public class History {

	private String historyNum;
	private String memberNum;
	private String courseNum;
	
	/**
	 * 강좌 내역 생성자입니다.
	 * @param historyNum 수강번호
	 * @param memberNum 회원번호
	 * @param courseNum 강좌번호
	 */
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
