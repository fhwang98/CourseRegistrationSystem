package com.project.admin.notice;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.notice.NoticeData;

public class NoticeMain {

	private static int page;
	private static int lastpage;
	private static boolean mainLoop;
	private static boolean checkingLoop;
	private static Scanner scan;
	
	
	static {
		page = 0;
		lastpage =NoticeData.getList().size() / 10 - 1;
		mainLoop = true;
		checkingLoop = true;
		scan = new Scanner(System.in);
	}
	
	public static int getPage() {
		return page;
	}

	public static int getLastpage() {
		return lastpage;
	}

	public static void controlNoticeMain() {
		NoticeData.load();
		 //공지사항 전체 루프
		while (mainLoop) {
			//공지사항 첫화면 출력
			NoticeView.printNoticePage(page);
			 // 뒤로가기, 이전페이지, 다음페이지, 확인, 등록
			String sel1 = scan.nextLine();
			//유효성 체크
			if (!AdminUtil.isValidSel(sel1, 0, 4)) {
				System.out.println("is invalid input");
				System.out.println("enter a new line to going back");
				scan.nextLine();
				continue;
			}  else if (sel1.equals("0")) { //뒤로가기
				mainLoop = false;
			} else if (sel1.equals("1")) {
				firstSelect1();
			} else if (sel1.equals("2")) {
				firstSelect2();
			} else if (sel1.equals("3")) {
				firstSelect3();
			}  else if (sel1.equals("4")) {
				firstSelect4();
			}
		}
		System.out.println("공지사항 종료");
		System.out.println("back to previous step");
		scan.nextLine();
	}


	private static void firstSelect4() {
		if (page == 0 || page == lastpage) {
			//잘못된 선택
			NoticeView.printInvalidInputMessage();
			NoticeView.printPendingMessage();
			scan.nextLine();
		} else {
			//공지 등록
			NoticeService.addNotice();
		}
	}

	private static void firstSelect3() {
		if (page == 0 || page == lastpage) {
			//공지 등록
			NoticeService.addNotice();
		} else {
			//공지 확인
			checkingControl();
		}
	}

	private static void firstSelect2() {
		if (page == 0 || page == lastpage) {
			//공지 확인
			checkingControl();
			
		} else {
			//다음페이지로
			page++;
		}
	}

	private static void firstSelect1() {
		if (page == 0) {
			//다음페이지로
			page++;
		}else {
			//이전페이지로
			page--;
		}
	}
	
	private static void checkingControl() {
		
		System.out.println("확인하고 싶은 공지사항의 번호를 입력해 주세요.");
		System.out.println("번호 입력: ");
		String selNotice = scan.nextLine(); //유효성 검사

		if (!AdminUtil.isValidSel(selNotice, 1, 10)) {
			System.out.println("is invalid input");
			System.out.println("enter a new line to going back");
			scan.nextLine();
			return;
		}
		
		
		//공지사항의 진짜 인덱스 = 리스트 총길이 - 입력받은 번호 - 페이지*10 
		int noticeNo = NoticeData.getList().size() - Integer.parseInt(selNotice) - page*10;
		
		while (checkingLoop) {
			
			NoticeView.printNotice(noticeNo);
			NoticeView.printOpenedNoticeMenu();
			String sel2 = scan.nextLine();
			//sel2 유효성 검사
			//유효성 체크
			if (!AdminUtil.isValidSel(sel2, 0, 3)) {
				System.out.println("is invalid input");
				System.out.println("enter a new line to going back");
				scan.nextLine();
				continue;
			}
			else if (sel2.equals("0")) {
				checkingLoop = false;
			} else if (sel2.equals("1")) {
				// 수정을 누르면 수정을 하고 다시 돌아온다
				NoticeService.modifyNoticeTitle(noticeNo);
			} else if (sel2.equals("2")) {
				//수정을 누르면 수정을 하고 다시 돌아온다
				NoticeService.modifyNoticeContent(noticeNo);
			} else if (sel2.equals("3")) {
				NoticeService.deleteNotice(noticeNo);
				checkingLoop = false;
			}
		}
	}

}
