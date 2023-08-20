package com.project.admin.notice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import com.project.notice.Notice;
import com.project.notice.NoticeData;

public class NoticeService {
	
	private static Scanner scan;
	
	static {
		scan= new Scanner(System.in);
	}
	
	
	//공지사항 등록 구현
	public static void addNotice() {
		
		System.out.println("새로운 공지사항을 등록합니다. ");
		NoticeView.printPendingMessage();
		scan.nextLine();
		
		NoticeView.printPosting();
		
		String noticeWriter = "작성자"; //현재 로그인정보에서 가져와야함 추후 수정
		
		System.out.println("제목을 입력해 주세요.(20자 이내)");
		System.out.print("제목 입력: ");
		String inputTitle = scan.nextLine();
		if (!isValidTitle(inputTitle)) {
			System.out.println();
			System.out.println("올바르지 않은 입력입니다.");
			System.out.println("공지사항 목록으로 돌아갑니다.");
			NoticeView.printPendingMessage();
			scan.nextLine();
			return;
		}
		
		String inputContent = getContent();
		if (inputContent.equals("")) {
			
			System.out.println();
			System.out.println("올바르지 않은 입력입니다.");
			System.out.println("공지사항 목록으로 돌아갑니다.");
			NoticeView.printPendingMessage();
			scan.nextLine();
			return;
		}
		
		int no = NoticeData.getList().size() + 1;
		Calendar uploadTime = Calendar.getInstance();
		
		Notice newNotice = new Notice(no, uploadTime, noticeWriter, inputTitle, inputContent);
		
		NoticeData.getList().add(newNotice);
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("data//noticedummy.txt", true));
			writer.write(newNotice.toString());
			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			System.out.println("at NoticeService.addNotice");
			e.printStackTrace();
		}
		
	}
	
	private static boolean isValidTitle(String inputTitle) {
		//화이트 스페이스 잡아야됨
		inputTitle = inputTitle.replace(" ", "").replace("\t", "").replace("\r\n", "");
		if (inputTitle.equals("") || inputTitle.length() > 20) {
			return false;
		}
		return true;
	}

	public static void modifyNoticeTitle(int noticeNo) {
		
		System.out.println("제목을 입력해 주세요.(20자 이내)");
		System.out.print("제목 입력: ");
		String inputTitle = scan.nextLine();
		
		if (!isValidTitle(inputTitle)) {
			System.out.println();
			System.out.println("올바르지 않은 입력입니다.");
			NoticeView.printPendingMessage();
			scan.nextLine();
			return;
		}
		
		NoticeData.getList().get(noticeNo).setTitle(inputTitle);
		//파일에 작성할차례
		//걍 전체 덮어쓰기하면 안되나 ...? reader로 찾아서 한줄만 수정해야되나?????
		NoticeData.update(NoticeData.getList()); //걍 일단 덮어쓰기함
		
	}
	
	public static void modifyNoticeContent(int noticeNo) {
		
		String inputContent = getContent();
		if (inputContent.equals("")) {
			System.out.println("내용을 입력해 주세요.");
			return;
		}

		NoticeData.getList().get(noticeNo).setContent(inputContent);
		//파일에 작성할차례
		NoticeData.update(NoticeData.getList()); 
		
	}

	private static String getContent() {
		String input ="";
		while (true) {
			
			System.out.print("내용 입력:");
			String line = scan.nextLine();
			
			if (line.equals("")) {
				break;
			}
			input += line + "\\r\\n";
			
		}
		return input;
	}
	
	public static void deleteNotice(int noticeNo) {
		System.out.println("공지사항을 삭제합니다.");
		System.out.println("삭제 후 되돌릴 수 없습니다.");
		System.out.print("공지사항을 삭제하시겠습니까? [y/n]: ");
		String answer = scan.nextLine();
		if (!answer.equals("y")) {
			System.out.println("공지사항 삭제를 취소합니다.");
			NoticeView.printPendingMessage();
			scan.nextLine();
			return;
		}
		NoticeData.getList().remove(noticeNo);
		NoticeData.update(NoticeData.getList());
		
	}


	
	
}
