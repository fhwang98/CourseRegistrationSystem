package com.project.admin.notice;

import java.util.ArrayList;

import com.project.admin.Admin;
import com.project.admin.AdminData;
import com.project.authentication.Authentication;
import com.project.notice.Notice;
import com.project.notice.NoticeData;
import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;

public class NoticeView {

	public static void printInvalidInputMessage() {
		System.out.println();
		System.out.println("올바른 번호를 입력해 주세요.");
	}
	
	public static void printPendingMessage() {
		System.out.println();
		System.out.println("계속하려면 엔터를 입력해 주세요.");
	}
	
	public static void printPosting() {
		
		System.out.println("=============================================");
		System.out.println("\t\t공지사항 등록");
		System.out.println("=============================================");
		
		System.out.println("새로운 공지사항을 작성합니다.");
	}
	
	
	public static void printNotice(int index) {

		printNoticeHead();
		
		Notice n = NoticeData.getList().get(index);
		System.out.printf("제목\t:\t%s\r\n", n.getTitle());
		System.out.printf("게시일\t:\t%tF\r\n", n.getUploadTime());
		System.out.printf("게시자\t:\t%s\r\n", getWriterName(n.getWriterCode())); 
		// 여러줄일 경우 앞에 탭 3개 후 출력
		String[] lines = n.getContent().split("\\\\r\\\\n"); // 개행 \r\n이면 \\\\r\\\\n

		for (int i = 0; i < lines.length; i++) {
			if (i == 0) {
				System.out.printf("내용\t:\t%s\r\n", lines[i]);
			} else {
				System.out.println("\t\t" + lines[i]);
			}
		}

	}

	private static String getWriterName(String writerCode) {
		if (writerCode.contains("A")) {
			
			AdminData.load();
			for (Admin a : AdminData.getAdminList()) {
				if (a.getAdminNo().equals(writerCode)) {
					return a.getAdminName();
				}
			}
		}
		else {
			
			UserDbms list = new UserDbms();
			ArrayList<DataTeacher> allTeacherList = UserDbms.getTeacherAllList();
			for (DataTeacher t : allTeacherList) {
				if (t.getTeacherCode().equals(writerCode)) {
					return t.getName();
				}
			}
			
		}
	
		return null;
	}
	

	public static void printOpenedNoticeMenu() {
		System.out.println("=============================================");
		System.out.println("---------------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 제목 수정");
		System.out.println("2. 내용 수정");
		System.out.println("3. 삭제");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력: ");
	}

	public static void printNoticePage(int page) {

		printNoticeHead();

		int lastindex = NoticeData.getList().size() - 1 - page * 10;
		
		System.out.println("[번호]\t[제목]");
		for (int i = 0; i < ((lastindex / 10 == 0) ? lastindex % 10 + 1 : 10); i++) {
			System.out.printf("%4d.\t", i + 1);
			System.out.println(NoticeData.getList().get(lastindex - i).getTitle());
		}
		
		printNoticeListMenu(page);
		System.out.print("번호 입력:");
	}

	private static void printNoticeListMenu(int page) {
		System.out.println("---------------------------------------------");

				
		System.out.println("0. 뒤로가기");
		if (page == 0 || page == NoticeMain.getLastpage()) {
			if (page == 0) {
				System.out.println("1. 다음 페이지");
			} else if (page == NoticeMain.getLastpage()) {
				System.out.println("1. 이전 페이지");
			}
			System.out.println("2. 공지사항 확인");
			System.out.println("3. 공지사항 등록");
		} else {
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
			System.out.println("3. 공지사항 확인");
			System.out.println("4. 공지사항 등록");
			
		}

		System.out.println("---------------------------------------------");

	}

	private static void printNoticeHead() {
		System.out.println("=============================================");
		System.out.println("\t\t\s\s\s공지사항");
		System.out.println("=============================================");
	}

}
