package com.project.admin.notice;

import java.util.Scanner;

import com.project.notice.NoticeData;

public class NoticeMain {

	private static int page;
	private static int lastpage;
	
	static {
		NoticeMain.page = 0;
		NoticeMain.lastpage =NoticeData.getList().size() / 10 ; 
	}
	
	public static int getPage() {
		return page;
	}

	public static int getLastpage() {
		return lastpage;
	}

	public static void controlNotice() {
		 //공지사항 전체 루프
		Scanner scan = new Scanner(System.in);
		while (true) {
			
			//공지사항 첫화면 출력
			NoticeView.printNoticePage(page);
			
			System.out.print("번호 입력:"); // 뒤로가기, 이전페이지, 다음페이지, 확인, 등록
			String firstInput = scan.nextLine(); //유효성 체크 해야함
			if (firstInput.equals("0")) { //뒤로가기
				break;
			} else if (firstInput.equals("1")) {
				firstSelect1();
			} else if (firstInput.equals("2")) {
				firstSelect2(scan);
			} else if (firstInput.equals("3")) {
				firstSelect3(scan);
			}  else if (firstInput.equals("4")) {
				firstSelect4(scan);
			} else {
				break;
			}
			
			
		}
		
		scan.close();
		System.out.println("종료");
	}

	private static void firstSelect4(Scanner scan) {
		if (page == 0 || page == lastpage) {
			//잘못된 선택
			System.out.println("잘못된 선탣");
		} else {
			//공지 등록
			NoticeService.addNotice(scan);
		}
	}

	private static void firstSelect3(Scanner scan) {
		if (page == 0 || page == lastpage) {
			//공지 등록
			NoticeService.addNotice(scan);
		} else {
			//공지 확인
			checkingControl(scan);
		}
	}

	private static void firstSelect2(Scanner scan) {
		if (page == 0 || page == lastpage) {
			//공지 확인
			checkingControl(scan);
			
		} else {
			//다음페이지로
			page++;
		}
	}

	private static void checkingControl(Scanner scan) {
		
		System.out.println("공지사항 확인");
		System.out.println("번호: ");
		String inputNo = scan.nextLine(); //유효성 검사
		int no = Integer.parseInt(inputNo);
		int noticeNo = NoticeData.getList().size() - no - page*10;
		
		//숫자 아닌 경우, 1미만, 10초과인 경우 걸러줘야함
		while (true) {
			NoticeView.printNotice(NoticeData.getList().size() - no - NoticeMain.getPage() * 10);
			NoticeView.printOpenedNoticeMenu();
			System.out.println("번호: ");
			String secondInput = scan.nextLine();
			if (secondInput.equals("0")) {
				return;
			} else if (secondInput.equals("1")) {
				//수정을 누르면 수정을 하고 다시 이 글을 본다
				NoticeService.modifyNoticeTitle(noticeNo, scan);
				continue;
			} else if (secondInput.equals("2")) {
				//수정을 누르면 수정을 하고 다시 이 글을 본다
				NoticeService.modifyNoticeContent(noticeNo, scan);
				continue;
			} else if (secondInput.equals("3")) {
				NoticeService.deleteNotice(noticeNo, scan);
				return;
			} else {
				System.out.println("잘못된 번호 입력");
				return;
			}
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
	// 뒤로가기, 이전페이지, 다음페이지, 확인, 등록	
}
