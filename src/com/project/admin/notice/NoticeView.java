package com.project.admin.notice;

import com.project.notice.Notice;
import com.project.notice.NoticeData;

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
		//TODO DataTeacher 에서 list 를 가져와서 n.getWriter() 와 일치하는 코드를 가진 사람의 이름을 가져온다
		System.out.printf("게시자\t:\t%s\r\n", n.getWriter()); 
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


	public static void printOpenedNoticeMenu() {
		System.out.println("=============================================");
		System.out.println("---------------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 제목 수정");
		System.out.println("2. 내용 수정");
		System.out.println("3. 삭제");
		System.out.println("---------------------------------------------");
		System.out.println("번호: ");
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
