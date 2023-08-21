package com.project.admin.room;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.room.RoomData;
import com.project.room.RoomScheduleData;

public class RoomMain {
	
	public static boolean loop;
	
	static {
		loop = true;
	}
	
	public static void controlRoom() {
		
		RoomScheduleData.load();
		RoomData.load();
		
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
			RoomView.printRoomMenu();
			
			String sel = scan.nextLine();
			if(!AdminUtil.isValidSel(sel, 0, 2)) {
				AdminView.printInvalidInputMessage();
				AdminView.printPendingMessage();
				scan.nextLine();
				continue;
			} else if (sel.equals("0")) {
				loop = false;
			} else if (sel.equals("1")) {
				//전체 보기
				RoomService.showAll();
			} else if (sel.equals("2")) {
				//검색 하기
				System.out.println("search room");
				RoomService.searchRoom();
			}
			
		}
		
	}
}
