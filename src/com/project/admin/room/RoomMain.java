package com.project.admin.room;

import java.util.Scanner;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.room.RoomData;
import com.project.room.RoomScheduleData;

/**
 * 관리자의 강의실 관련 기능을 컨트롤하는 클래스 입니다.
 * @author eugene
 *
 */
public class RoomMain {
	
	/**
	 * 관리자의 강의실 관련 메뉴를 컨트롤하는 메소드 입니다.
	 */
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
				RoomService.showAll(RoomData.getRoomList());
			} else if (sel == 2) {
				//검색 하기
				RoomService.searchRoom();
			}
			
		}
		
	}
}
