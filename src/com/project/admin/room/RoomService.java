package com.project.admin.room;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.room.RoomData;

public class RoomService {
	

	public static Scanner scan;
	
	static {
		scan= new Scanner(System.in);
	}
	public static void showAll() {
		
		// 리스트가 정렬이 되어있
		int page = 0;
		int lastPage = RoomData.getRoomList().size() / 10 - 1;
		
		System.out.println("전체 강의실 목록을 조회합니다. ");
		AdminView.printPendingMessage(scan);
		
		boolean loop = true;
		while (loop) {

			RoomView.printRoomList(page);
			RoomView.printRoomListMenu(page, lastPage);
			
			String input = scan.nextLine();
			int sel = AdminUtil.isValidSel(input, 0, 2);
			if (sel == -1) {
				AdminView.printInvalidInputMessage(scan);
				continue;
			} else if (sel == 0) {
				loop = false;
			} else if (sel == 1) {
				if (page == 0) {
					//next page
					page++;
				} else {
					//previous page
					page--;
				}
				
			} else if (sel == 2) {
				if (page == 0 || page == lastPage) {
					//invalid input
					AdminView.printInvalidInputMessage(scan);
				} else {
					//next page
					page++;
				}
				
			}
		}
	}
	
	public static void searchRoom() {
		
		//강의실검색
	/*
		사용 가능한 강의실을 찾습니다.

		요일을 입력해 주세요
		전체
		월수금
		화목
		번호: 
		
		시간대를 선택해 주세요
		전체
		오전
		오후
		번호: 
		
		[요일], [시간대] 에 사용 가능한 강의실을 찾습니다.
		
		*/
		RoomView.printSearchSelectDay();
		String inputDay = scan.nextLine();
		RoomView.printSearchSelectSlot();
		String inputSlot = scan.nextLine();
		// 유효성 체크
		int selDay = AdminUtil.isValidSel(inputDay, 1, 3);
		int selSlot = AdminUtil.isValidSel(inputSlot, 1, 3);
		if (selDay == -1 | selSlot == -1) {
			AdminView.printInvalidInputMessage(scan);
			return;
		} 
		
		
		
		
	}
	
	
	public static void serch(String dayOfWeek, String time) {
		
	}
	
}
