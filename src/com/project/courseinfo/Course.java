package com.project.courseinfo;

/**
 * 강좌 정보를 저장하기 위한 클래스입니다.
 * 
 */
public class Course {
	
	
//강좌코드, 카테고리, 강좌명, 강좌시작시간, 요일, 대상, 수강료, 정원, 강사코드, 강좌내용, 강좌시작일, 강의실
	
	
	
	
	private String num;
	private String category;
	private String courseName;
	private String time;
	private String day;
	private String target;
	private String courseFee;
	private String person;
	private String teacherNum;
	private String contents;
	private String startDay;
	private String roomNum;

	/**
	 * 생성자로, 강좌 정보를 초기화 합니다. 
	 * @param num 강좌코드
	 * @param category 강좌 카테고리
	 * @param courseName 강좌명
	 * @param time 강좌 시작시간
	 * @param day 강좌수강요일
	 * @param target 강좌 대상
	 * @param courseFee 강좌 수강료
	 * @param person 강좌 신청인원
	 * @param teacherNum 강사코드
	 * @param contents 강좌내용
	 * @param startDay 강좌시작일
	 * @param roomNum 강좌 강의실번호
	 */
	
	public Course(String num, String category, String courseName, String time, String day, String target,
			String courseFee, String person, String teacherNum, String contents, String startDay, String roomNum) {
		
		this.num = num;
		this.category = category;
		this.courseName = courseName;
		this.time = time;
		this.day = day;
		this.target = target;
		this.courseFee = courseFee;
		this.person = person;
		this.teacherNum = teacherNum;
		this.contents = contents;
		this.startDay = startDay;
		this.roomNum = roomNum;
	}

/**
 * 강좌코드를 반환 합니다.
 * 
 * @return 강좌코드
 */
	public String getNum() {
		return num;
	}

/**
 * 강좌 코드를 설정 합니다.
 * 
 * @param num 강좌코드
 */
	public void setNum(String num) {
		this.num = num;
	}

/**
 * 강좌 카테고리를 반환합니다.
 * 
 * @return 강좌 카테고리
 */
	public String getCategory() {
		return category;
	}

/**
 * 강좌 카테고리를 설정합니다.
 * 
 * @param category 강좌 카테고리
 */
	public void setCategory(String category) {
		this.category = category;
	}

/**
 * 강좌명을 반환합니다.
 * 
 * @return 강좌명
 */
	public String getCourseName() {
		return courseName;
	}

/**
 * 강좌명을 설정합니다.
 * @param courseName 강좌명
 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

/**
 * 강좌 시작시간을 반환합니다.
 * @return 강좌 시작시간
 */
	public String getTime() {
		return time;
	}

/**
 * 강좌 시작시간을 설정합니다.
 * @param time 강좌 시작시간 
 */
	public void setTime(String time) {
		this.time = time;
	}

/**
 * 강좌수강요일을 반환합니다.
 * 
 * @return 강좌수강요일
 */
	public String getDay() {
		return day;
	}

/** 강좌 수강요일을 설정합니다.
 *
 * @param day 강좌수강요일 
 */
	public void setDay(String day) {
		this.day = day;
	}

/**
 * 강좌 대상을 반환합니다.
 * @return 강좌 대상 
 */
	public String getTarget() {
		return target;
	}

/**
 * 강좌 대상을 설정합니다.
 * 
 * @param target 강좌대상
 */
	public void setTarget(String target) {
		this.target = target;
	}

/**
 *  강좌 수강료를 반환합니다.
 * @return 강좌 수강료
 */
	public String getCourseFee() {
		return courseFee;
	}

/**
 * 강좌 수강료를 설정합니다.
 * @param courseFee 강좌수강료
 */
	public void setCourseFee(String courseFee) {
		this.courseFee = courseFee;
	}

/**
 * 강좌 신청인원을 반환합니다.
 * @return 강좌 신청인원
 */
	public String getPerson() {
		return person;
	}

/**
 * 강좌 신청인원을 설정합니다.
 * @param person 강좌 신청인원 
 */
	public void setPerson(String person) {
		this.person = person;
	}

/**
 * 강사코드를 반환합니다.
 * @return 강사코드
 */
	public String getTeacherNum() {
		return teacherNum;
	}

/**
 * 강사코드를 설정합니다.
 * @param teacherNum 강사코드
 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}

/**
 * 강좌 내용을 반환합니다.
 * @return 강좌 내용
 */
	public String getContents() {
		return contents;
	}

/**
 * 강좌 내용을 설정합니다.
 * @param contents 강좌 내용 
 */
	public void setContents(String contents) {
		this.contents = contents;
	}

/**
 * 강좌 시작일을 반환합니다.
 * @return 강좌 시작일
 */
	public String getStartDay() {
		return startDay;
	}
/**
 * 강좌 시작일을 설정합니다.
 * @param startDay 강좌 시작알
 */

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

/**
 * 강좌 강의실을 반환합니다.
 * @return 강좌 강의실
 */
	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * 강좌 강의실을 설정합니다. 
	 * @param roomNum 강좌 강의실
	 */

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	/**
	 * 객체 정보를 문자열로 반환합니다.
	 * 
	 * @return 객체 정보 문자열
	 */
	@Override
	public String toString() {
		return "Course [num=" + num + ", category=" + category + ", courseName=" + courseName + ", time=" + time
				+ ", day=" + day + ", target=" + target + ", courseFee=" + courseFee + ", person=" + person
				+ ", teacherNum=" + teacherNum + ", contents=" + contents + ", startDay=" + startDay + ", roomNum="
				+ roomNum + "]";
	}
	
	
}
	
	
	
	