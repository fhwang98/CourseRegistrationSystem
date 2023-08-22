package com.project.admin.room;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.room.RoomData;
import com.project.room.RoomScheduleData;

public class RoomMain {
	

	public static void controlRoom() {
		
		RoomScheduleData.load();
		RoomData.load();
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
			RoomView.printRoomMenu();
			
			String input = scan.nextLine();
			int sel = AdminUtil.isValidSel(input, 0, 2); 
			if(sel == -1) {
				AdminView.printInvalidInputMessage(scan);
				continue;
			} else if (sel == 0) {
				loop = false;
			} else if (sel == 1) {
				//전체 보기
				RoomService.showAll();
			} else if (sel == 2) {
				//검색 하기
				System.out.println("search room");
				RoomService.searchRoom();
			}
			
		}
		
	}
}
