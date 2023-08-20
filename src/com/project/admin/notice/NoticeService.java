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
	
	
	//공지사항 등록 구현
	public static void addNotice(Scanner scan) {
		
		NoticeView.printPendingMessage();
		scan.nextLine();
		
		
		
		NoticeView.printPosting();
		
		
		String noticeWriter = "작성자"; //현재 로그인정보에서 가져와야함 추후 수정
		
		System.out.println("제목을 입력해 주세요.(20자 이내)");
		System.out.print("제목 입력: ");
		String inputTitle = scan.nextLine();
		if (!isValidTitle(inputTitle)) {
			System.out.println("유효하지 않은 제목");
			return;
		}
		
		String inputContent ="";
		boolean loop = true;
		while (loop) {
			
			System.out.print("내용 입력:");
			String line = scan.nextLine();
			
			if (line.equals("")) {
				loop = false;
				break;
			}
			inputContent += line + "\\r\\n";
		}
		if (inputContent.equals("")) {
			System.out.println("내용을 입력핫요");
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
		if (inputTitle.equals("") || inputTitle.length() > 20) {
			return false;
		}
		return true;
	}

	public static void modifyNoticeTitle(int noticeNo, Scanner scan) {
		
		System.out.println("제목을 입력해 주세요.(20자 이내)");
		System.out.print("제목 입력: ");
		String inputTitle = scan.nextLine();
		
		if (!isValidTitle(inputTitle)) {
			System.out.println("유효하지 않은 제목");
			return;
		}
		
		NoticeData.getList().get(noticeNo).setTitle(inputTitle);
		//파일에 작성할차례
		//걍 전체 덮어쓰기하면 안되나 ...? reader로 찾아서 한줄만 수정해야되나?????
		NoticeData.update(NoticeData.getList()); //걍 일단 덮어쓰기함
		
	}
	
	public static void modifyNoticeContent(int noticeNo, Scanner scan) {
		
		String inputContent ="";
		boolean loop = true;
		while (loop) {
			
			System.out.print("내용 입력:");
			String line = scan.nextLine();
			
			if (line.equals("")) {
				loop = false;
				break;
			}
			inputContent += line + "\\r\\n";
			
		}
		if (inputContent.equals("")) {
			System.out.println("내용을 입력핫요");
			return;
		}

		NoticeData.getList().get(noticeNo).setContent(inputContent);
		//파일에 작성할차례
		NoticeData.update(NoticeData.getList()); 
		
	}
	
	public static void deleteNotice(int noticeNo, Scanner scan) {
		NoticeData.getList().remove(noticeNo);
		NoticeData.update(NoticeData.getList());
		
		//NoticeData.getList().remove(no);
	}

	public static void openNotice() {
		
		System.out.println("공지사항 확인");
		System.out.println("번호: ");
		Scanner scan = new Scanner(System.in);
		String no = scan.nextLine(); //유효성 검사
		//숫자 아닌 경우, 1미만, 10초과인 경우 걸러줘야함
		scan.close();
		NoticeView.printNotice(NoticeData.getList().size() - Integer.parseInt(no) - NoticeMain.getPage() * 10);
		NoticeView.printOpenedNoticeMenu();
		
		
	}


	
}
