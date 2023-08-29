package com.project.admin.notice;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.notice.Notice;
import com.project.notice.NoticeData;

/**
 * 관리자의 공지사항 관련 기능을 컨트롤하는 클래스입니다.
 * @author eugene
 *
 */
public class NoticeMain {

	private static int page;
	private static int lastpage;
	private static boolean mainLoop;
	private static boolean checkingLoop;
	private static Scanner scan;
	
	
	static {
		page = 0;
		lastpage =0;
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

	/**
	 * 공지사항 페이지와 메뉴를 컨트롤하는 메소드입니다.
	 */
	public static void controlNoticeMain() {
		NoticeData.load();
		 //공지사항 전체 루프
		lastpage = (NoticeData.getList().size() - 1)/ 10;
		mainLoop = true;
		while (mainLoop) {

			
			//공지사항 첫화면 출력
			NoticeView.printNoticePage(page);
			 // 뒤로가기, 이전페이지, 다음페이지, 확인, 등록
			String input = scan.nextLine();
			
			int sel1 = AdminUtil.isValidSel(input, 0, 4);
			//유효성 체크
			if (sel1 == -1) {
				AdminView.printInvalidInputMessage(scan);
			}  else if (sel1 ==0) { //뒤로가기
				page = 0;
				mainLoop = false;
			} else if (sel1 == 1) {
				firstSelect1();
			} else if (sel1 == 2) {
				firstSelect2();
			} else if (sel1 == 3) {
				firstSelect3();
			}  else if (sel1 == 4) {
				firstSelect4();
			}
		}
	}


	private static void firstSelect4() {
		if (page == 0 || page == lastpage) {
			//잘못된 선택
			NoticeView.printInvalidInputMessage();
			NoticeView.printPendingMessage();
			scan.nextLine();
		} else {
			//공지 등록
			scan.nextLine();
			NoticeService.addNotice();
		}
	}

	private static void firstSelect3() {
		if (page == 0 || page == lastpage) {
			//공지 등록
			scan.nextLine();
			NoticeService.addNotice();
		} else {
			//공지 확인
			scan.nextLine();
			checkingControl();
		}
	}

	private static void firstSelect2() {
		if (page == 0 || page == lastpage) {
			//공지 확인
			scan.nextLine();
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
	
	/**
	 * 공지사항 글 하나를 컨트롤하는 메소드 입니다.
	 */
	private static void checkingControl() {
		
		checkingLoop = true;
		System.out.println("확인하고 싶은 공지사항의 번호를 입력해 주세요.");
		System.out.print("번호 입력: ");
		String input = scan.nextLine(); //유효성 검사

		int selNotice = AdminUtil.isValidSel(input, 1, 10);
		if (selNotice == -1) {
			AdminView.printInvalidInputMessage(scan);
			return;
		}
		scan.nextLine();
		System.out.println(selNotice+"번 공지사항의 내용을 확인합니다.");
		
		//공지사항의 진짜 인덱스 = 리스트 총길이 - 입력받은 번호 - 페이지*10 
		int noticeNo = NoticeData.getList().size() - selNotice - page*10;
		
		while (checkingLoop) {
			
			NoticeView.printNotice(noticeNo);
			NoticeView.printOpenedNoticeMenu();
			input = scan.nextLine();
			int sel2 = AdminUtil.isValidSel(input, 0, 3);
			//sel2 유효성 검사
			//유효성 체크
			scan.nextLine();
			if ( sel2  == -1) {
				AdminView.printInvalidInputMessage(scan);
				continue;
			}
			
			else if (sel2 == 0) {
				checkingLoop = false;
			} else if (sel2 == 1) {
				// 수정을 누르면 수정을 하고 다시 돌아온다
				NoticeService.modifyNoticeTitle(noticeNo);
			} else if (sel2 == 2) {
				//수정을 누르면 수정을 하고 다시 돌아온다
				NoticeService.modifyNoticeContent(noticeNo);
			} else if (sel2 == 3) {
				NoticeService.deleteNotice(noticeNo);
				checkingLoop = false;
			}
		}
	}

}
