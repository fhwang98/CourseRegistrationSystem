package com.project.notice;

import java.util.Calendar;

public class Notice {

	private int no;
	private Calendar uploadTime;
	private String writerCode;
	private String title;
	private String content;
	
	
	public Notice(int no, Calendar writeDateAndTime, String writer, String title, String content) {
		this.no = no;
		this.uploadTime = writeDateAndTime;
		this.writerCode = writer;
		this.title = title;
		this.content = content;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Calendar getUploadTime() {
		return uploadTime;
	}


	public void setUploadTime(Calendar writeDateAndTime) {
		this.uploadTime = writeDateAndTime;
	}


	public String getWriterCode() {
		return writerCode;
	}


	public void setWriter(String writer) {
		this.writerCode = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return String.format("%03d✡%tF-%tT✡%s✡%s✡%s", no,uploadTime,uploadTime,writerCode,title,content);
	}
	


	
}
