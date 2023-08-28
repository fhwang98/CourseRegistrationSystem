package com.project.busstop;

/**
 * 셔틀 버스 정류장 정보를 담을 객체 클래스입니다.
 * 
 * @author 황은하
 *
 */
public class BusStop {
	private String name;
	private String num;
	private String time1;
	private String time2;
	private String time3;
	private String time4;
	private String time5;

	/**
	 * 셔틀 버스 정류장이 생성될 때 모든 값을 넣는 생성자입니다.
	 * 
	 * @param name  정류장명
	 * @param num   정류장 연번
	 * @param time1 1회차 시간
	 * @param time2 2회차 시간
	 * @param time3 3회차 시간
	 * @param time4 4회차 시간
	 * @param time5 5회차 시간
	 */
	public BusStop(String name, String num, String time1, String time2, String time3, String time4, String time5) {
		this.name = name;
		this.num = num;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.time4 = time4;
		this.time5 = time5;
	}

	/**
	 * 셔틀 버스 정류장의 이름을 가져오는 메소드입니다.
	 * 
	 * @return 정류장명
	 */
	public String getName() {
		return name;
	}

	/**
	 * 셔틀 버스 정류장의 연번을 가져오는 메소드입니다.
	 * 
	 * @return 정류장 연번
	 */
	public String getNum() {
		return num;
	}

	/**
	 * 셔틀 버스 정류장의 1회차 시간을 가져오는 메소드입니다.
	 * 
	 * @return 1회차 시간
	 */
	public String getTime1() {
		return time1;
	}

	/**
	 * 셔틀 버스 정류장의 2회차 시간을 가져오는 메소드입니다.
	 * 
	 * @return 2회차 시간
	 */
	public String getTime2() {
		return time2;
	}

	/**
	 * 셔틀 버스 정류장의 3회차 시간을 가져오는 메소드입니다.
	 * 
	 * @return 3회차 시간
	 */
	public String getTime3() {
		return time3;
	}

	/**
	 * 셔틀 버스 정류장의 4회차 시간을 가져오는 메소드입니다.
	 * 
	 * @return 4회차 시간
	 */
	public String getTime4() {
		return time4;
	}

	/**
	 * 셔틀 버스 정류장의 5회차 시간을 가져오는 메소드입니다.
	 * 
	 * @return 5회차 시간
	 */
	public String getTime5() {
		return time5;
	}

}
