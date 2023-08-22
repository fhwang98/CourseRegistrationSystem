package com.project.admin.room;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.room.Room;
import com.project.room.RoomData;

public class RoomService {
	
	public static ArrayList<Room> availableRoom;
	
	static {
		
		availableRoom = new ArrayList<Room>();
		
	}
	
	
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

		요일을 입력해주세요.
		예시) 월
		요일 입력: 
		
		시작 시간을 입력해주세요.
		예시) 12:30
		시간 입력:
		
		[요일], [시간] 에 사용 가능한 강의실을 찾습니다.
		
		*/
		RoomView.printSearchSelectDay();
		String inputDay = scan.nextLine();
		//유효성 체크
		//월화수목금 아니면 x
		RoomView.printSearchSelectTime();
		String inputTime = scan.nextLine();
		// 유효성 체크
		// 시간:분 형식 안맞으면 x 시간이 9시 전, 22시 이후 x

		
		if ( !isValidDay(inputDay) || !isValidTime(inputTime) ) {
			return;
		}
		search(inputDay, inputTime);
	}
	
	
	private static boolean isValidTime(String inputTime) {
		inputTime = inputTime.replaceAll("(\\s||\\t|\\r\\n|\\n)", "");
		
		Pattern ptime = Pattern.compile("[0-9]{2}:[0-9]{2}");
		
		Matcher mtime = ptime.matcher(inputTime);
		
		if (!mtime.matches()) {
			return false;
		}
		if (Integer.parseInt(inputTime.substring(0, 2)) < 6
				|| Integer.parseInt(inputTime.substring(0, 2)) > 21) {
			return false;
		}
		return true;
		
	}

	private static boolean isValidDay(String inputDay) {

		inputDay = inputDay.replaceAll("(\\s||\\t|\\r\\n|\\n)", "");
		for (int i = 0; i < inputDay.length(); i++) {
			if ( !inputDay.equals("월") || !inputDay.equals("화") || !inputDay.equals("수")
					|| !inputDay.equals("목") || !inputDay.equals("금")) {
				return false;
			}
		}
		return true;
	}

	public static void search(String dayOfWeek, String time) {
		
		//RoomData.getRoomList()
		
		//새로운 리스트를 만들어
		//기존 강의실 리스트를 돌면서
		//지금 보고있는 객체를 새로운 리스트에 추가할건데
		//입력받은 스케줄이랑 일치하는지 확인해
		//일치해 ? 그럼 걔는 제외해
		
		boolean isOccupied = false;
		
		for (Room r : RoomData.getRoomList()) {
			
			for (String s : r.getSchedule()) {
				
				//공백으로 나눠
				String[] temp = s.split(" ");
				if (temp[0].contains(dayOfWeek) && temp[1].substring(0, 5).equals(time)) {
					//요일에 있으면서 시간도 일치해? 그럼 이미 사용중
					isOccupied = true;
				}
			}
			if (!isOccupied) {
				availableRoom.add(r);		
			}
		}
	}
	
//	public static void showAvailableRoom(ArrayList<Room> availableRoom) {
//		
//		// 리스트가 정렬이 되어있
//		int page = 0;
//		int lastPage = availableRoom.size() / 10 - 1;
//		
//		System.out.println("검색한 강의실 목록을 조회합니다. ");
//		AdminView.printPendingMessage(scan);
//		
//		boolean loop = true;
//		while (loop) {
//
//			RoomView.printRoomList(page);
//			RoomView.printRoomListMenu(page, lastPage);
//			
//			String input = scan.nextLine();
//			int sel = AdminUtil.isValidSel(input, 0, 2);
//			if (sel == -1) {
//				AdminView.printInvalidInputMessage(scan);
//				continue;
//			} else if (sel == 0) {
//				loop = false;
//			} else if (sel == 1) {
//				if (page == 0) {
//					//next page
//					page++;
//				} else {
//					//previous page
//					page--;
//				}
//				
//			} else if (sel == 2) {
//				if (page == 0 || page == lastPage) {
//					//invalid input
//					AdminView.printInvalidInputMessage(scan);
//				} else {
//					//next page
//					page++;
//				}
//				
//			}
//		}
//	}
	
}
