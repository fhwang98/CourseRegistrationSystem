package com.project.course;

/**
 * 수강 내역 정보를 담은 클래스입니다. 수강내역연번, 일반회원번호, 강좌번호가 들어있습니다.
 * 
 * @author 황은하
 *
 */
public class CourseHistory {

	private String historyNum;
	private String memberNum;
	private String courseNum;

	/**
	 * 수강 내역 객체를 만드는 생성자입니다.
	 * @param historyNum 수강내역연번
	 * @param memberNum 일반회원번호
	 * @param courseNum 강좌번호
	 */
	public CourseHistory(String historyNum, String memberNum, String courseNum) {
		this.historyNum = historyNum;
		this.memberNum = memberNum;
		this.courseNum = courseNum;
	}

	/**
	 * 수강 내역 변호를 가져오는 메소드입니다.
	 * @return 수강 내역 번호
	 */
	public String getHistoryNum() {
		return historyNum;
	}

	/**
	 * 수강 내역 번호를 설정하는 메소드입니다.
	 * @param historyNum 수강 내역 번호
	 */
	public void setHistoryNum(String historyNum) {
		this.historyNum = historyNum;
	}

	/**
	 * 일반회원번호를 가져오는 메소드입니다.
	 * @return 일반회원번호
	 */
	public String getMemberNum() {
		return memberNum;
	}

	/**
	 * 일반회원번호를 설정하는 메소드입니다.
	 * @param memberNum 일반회원번호
	 */
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	/**
	 * 강좌번호를 가져오는 메소드입니다.
	 * @return 강좌번호
	 */
	public String getCourseNum() {
		return courseNum;
	}

	/**
	 * 강좌번호를 설정하는 메소드입니다.
	 * @param courseNum 강좌번호
	 */
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	/**
	 * 수강 내역을 문자로 출력하는 메소드입니다.
	 */
	@Override
	public String toString() {
		return "History [historyNum=" + historyNum + ", memberNum=" + memberNum + ", courseNum=" + courseNum + "]";
	}

}
