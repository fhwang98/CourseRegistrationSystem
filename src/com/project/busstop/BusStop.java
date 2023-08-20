package com.project.busstop;

public class BusStop {
	private String name;
	private String num;
	private String time1;
	private String time2;
	private String time3;
	private String time4;
	private String time5;

	@Override
	public String toString() {
		return "BusStop [name=" + name + ", num=" + num + ", time1=" + time1 + ", time2=" + time2 + ", time3=" + time3
				+ ", time4=" + time4 + ", time5=" + time5 + "]";
	}

	public BusStop(String name, String num, String time1, String time2, String time3, String time4, String time5) {
		this.name = name;
		this.num = num;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.time4 = time4;
		this.time5 = time5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTime3() {
		return time3;
	}

	public void setTime3(String time3) {
		this.time3 = time3;
	}

	public String getTime4() {
		return time4;
	}

	public void setTime4(String time4) {
		this.time4 = time4;
	}

	public String getTime5() {
		return time5;
	}

	public void setTime5(String time5) {
		this.time5 = time5;
	}

}
