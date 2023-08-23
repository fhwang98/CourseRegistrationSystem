package com.project.teacher;

public class PendingCourse {

	private String courseName;
	private String dayOfWeek;
	private String startTime;
	private String category;
	private String target;
	private String courseExplanation;
	private String status;
	
	@Override
	public String toString() {
		return "PendingCourse [courseName=" + courseName + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
				+ ", category=" + category + ", target=" + target + ", courseExplanation=" + courseExplanation
				+ ", status=" + status + "]";
	}

	public PendingCourse(String courseName, String dayOfWeek, String startTime, String category, String target,
			String courseExplanation, String status) {
		super();
		this.courseName = courseName;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.category = category;
		this.target = target;
		this.courseExplanation = courseExplanation;
		this.status = status;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCourseExplanation() {
		return courseExplanation;
	}
	public void setCourseExplanation(String courseExplanation) {
		this.courseExplanation = courseExplanation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
