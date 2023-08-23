package com.project.admin.course;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.courseinfo.CourseData;

public class PendingCourseMain {

	private static Scanner scan;

	
	static {
		scan = new Scanner(System.in);
	}

	
	public static void controlPendingCourse() {
		
		PendingCourseData.load();
		//승인 대기 강좌 목록 보기
		
		boolean loop = true;
		int page = 0;
		int lastpage = (PendingCourseData.getList().size() - 1 )/ 10;  
		
		while (loop) {
			//10개를 보여줌
			//1번부터 보여줌
			PendingCourseView.printPendingCourseHead();
			PendingCourseView.printPendingCourseList(page);
			PendingCourseView.printPendingCourseMenu(page, lastpage);
			String sel = scan.nextLine();
			if (!sel.matches("[0-3]{1}")) {
				AdminView.printInvalidInputMessage(scan);
				continue;
			}
			if (sel.equals("0")) {
				//뒤로가기
				loop = false;
			} else if (sel.equals("1")) {
				//다음페이지
				if (page == 0) {
					page++;
				} else {
					//이전페이지
					page--;
				}
			} else if (sel.equals("2")) {
				if (page == 0 || page == lastpage) {
					//강좌 확인
					checkingControl(page);
				} else {
					//중간일때 2번을 선택하면 
					page++;
				}
			} else if (sel.equals("3")) {
				if (page == 0 || page == lastpage) {
					AdminView.printInvalidInputMessage(scan);
					continue;
				} else {
					//강좌 확인
					checkingControl(page);
				}
			}
		}
	}
	
	public static void checkingControl(int page) {
	
		System.out.println("내용을 확인하고 싶은 대기 강좌의 번호를 입력하세요.");
		System.out.print("번호 입력: ");
		
		String no = scan.nextLine();
		
		int selCourse = AdminUtil.isValidSel(no, 1, 10);
		if (selCourse == -1) {
			AdminView.printInvalidInputMessage(scan);
			return;
		}
		
		//실제 확인할 대기강좌의 인덱스를 구함
		int index = selCourse - 1 + page * 10;
		boolean loop = true;
		
		while (loop) {
			//대기 강좌 하나의 정보를 출력하고 메뉴 0 뒤로가기 1 승인 2 반려
			PendingCourseView.printPendingCourse(index);
			
			String sel = scan.next();
			
			if (!sel.matches("[0-2]{1}")) {
				AdminView.printInvalidInputMessage(scan);
				continue;
			} else if (sel.equals("0")) {
				loop = false;
			} else if (sel.equals("1")) {
				//등록 승인 -> 상태가 바뀌고 다른 데이터들이 업데이트된다
				PendingCourseService.acceptCourse(index);
			} else if (sel.equals("2")) {
				//등록 반려 -> 삭제되지는 않고 상태가 바뀜
				scan.nextLine(); //얘가 빠지면 안됨
				System.out.print("강의 등록 신청을 반려하시겠습니까? [y/n]");
				String input = scan.nextLine();
				if (!input.matches("y")) {
					System.out.println("반려를 취소합니다.");
					continue;
				}
				PendingCourseService.rejectCourse(index);
			}
		}
		PendingCourseData.sortList();
		scan.nextLine();
		
	}
}
