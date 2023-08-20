package com.project.admin;

import com.project.admin.notice.NoticeMain;
import com.project.notice.NoticeData;

public class AdminMain {

	public static void controlAdmin() {
		NoticeData.load();
		NoticeMain.controlNotice();

	}
	
}
