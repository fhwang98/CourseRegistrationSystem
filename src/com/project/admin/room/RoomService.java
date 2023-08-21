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
		
		boolean loop = true;
		while (loop) {

			System.out.println("전체 강의실 목록을 조회합니다. ");
			AdminView.printPendingMessage();
			scan.nextLine();
			
			RoomView.printRoomList(page);
			RoomView.printRoomListMenu(page, lastPage);
			
			String sel = scan.nextLine();
			if (!AdminUtil.isValidSel(sel, 0, 2)) {
				AdminView.printInvalidInputMessage();
				AdminView.printPendingMessage();
				scan.nextLine();
				continue;
			} else if (sel.equals("0")) {
				loop = false;
			} else if (sel.equals("1")) {
				if (page == 0) {
					//next page
					page++;
				} else {
					//previous page
					page--;
				}
				
			} else if (sel.equals("2")) {
				if (page == 0 || page == lastPage) {
					//invalid input
					AdminView.printInvalidInputMessage();
					AdminView.printPendingMessage();
					scan.nextLine();
				} else {
					//next page
					page++;
				}
				
			}
		}
	}
	
	public static void searchRoom() {
		
	}
	
}
