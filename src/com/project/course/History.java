package com.project.course;

/**
 * 수강 신청 내역을 저장하기 위한 클래스입니다.
 */
public class History {

	private String historyNum;
	private String memberNum;
	private String courseNum;
	
	/**
     * 생성자로, 수강 신청 내역을 초기화합니다.
     * 
     * @param historyNum 수강 신청 내역 번호
     * @param memberNum  회원 번호
     * @param courseNum  강좌 번호
     */
	
	public History(String historyNum, String memberNum, String courseNum) {
		this.historyNum = historyNum;
		this.memberNum = memberNum;
		this.courseNum = courseNum;
	}
	/**
	 * 수강신청 내역 번호를 반환합니다.
	 * @return 수강 신청 내역 번호
	 */
	public String getHistoryNum() {
		return historyNum;
	}

	/**
	 * 수강 신청 내역 번호를 설정합니다.
	 * @param historyNum 수강 신청 내역 번호
	 */
	public void setHistoryNum(String historyNum) {
		this.historyNum = historyNum;
	}

	/**
	 * 회원 번호를 반환합니다.
	 * @return 회원 번호
	 */
	public String getMemberNum() {
		return memberNum;
	}

	/**
	 * 회원 번호를 설정합니다.
	 * @param memberNum 회원 번호
	 */
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	/**
	 * 강좌 번호를 반환합니다.
	 * @return 강좌 번호
	 */
	public String getCourseNum() {
		return courseNum;
	}

	/**
	 * 강좌 번호를 설정합니다.
	 * @param courseNum 강좌번호
	 */
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	/**
	 * 객체 정보를 문자열로 반환합니다.
	 * 
	 * @return 객체 정보 문자열
	 */
	@Override
	public String toString() {
		return "History [historyNum=" + historyNum + ", memberNum=" + memberNum + ", courseNum=" + courseNum + "]";
	}
	
	
	
}
