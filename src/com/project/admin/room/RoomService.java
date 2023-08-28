package com.project.admin.room;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.admin.AdminUtil;
import com.project.admin.AdminView;
import com.project.room.Room;
import com.project.room.RoomData;

/**
 * 강의실과 관련한 기능을 컨트롤하는 클래스입니다.
 * @author eugene
 *
 */
public class RoomService {
	
	/**
	 * 해당되는 시간에 사용 가능한 강의실만 저장한 리스트입니다.
	 */
	public static ArrayList<Room> availableRoom;
	
	static {
		
		availableRoom = new ArrayList<Room>();
		
	}
	
	public static ArrayList<Room> getAvailableRoom() {
		return availableRoom;
	}

	public static Scanner scan;
	
	static {
		scan= new Scanner(System.in);
	}
	
	/**
	 * 전체 강의실 목록을 조회하는 메소드 입니다.
	 * @param list
	 */
	public static void showAll(ArrayList<Room> list) {
		
		// 리스트가 정렬이 되어있
		int page = 0;
		int lastPage = list.size() / 5 - 1; //5개단위로 페이지 쪼개자
		
		System.out.println("강의실 목록을 조회합니다. ");
		AdminView.printPendingMessage(scan);
		
		boolean loop = true;
		while (loop) {

			RoomView.printRoomList(page, list);
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
	
	/**
	 *검색할 강의실의 시간과 요일을 입력받는 메소드 입니다.
	 */
	public static void searchRoom() {
		
		//강의실검색
	   /*
		사용 가능한 강의실을 찾습니다.

		요일을 입력해주세요.
		예시) 월
		요일 입력: 
		
		시작 시간을 입력해주세요.
		예시) 12
		예시) 09
		시간 입력:
		
		[요일], [시간] 에 사용 가능한 강의실을 찾습니다.
		
		*/
		RoomView.printSearchSelectDay();
		String inputDay = scan.nextLine();
		//유효성 체크
		//월화수목금 아니면 x
		RoomView.printSearchSelectTime();
		String inputTime = scan.nextLine();

		//유효하지 않으면 바로 리턴때려
		if ( !inputDay.matches("[월화수목금]") || !isValidTime(inputTime)/*!inputTime.matches("[0-9]{1,2}")*/ ) {
			AdminView.printInvalidInputMessage(scan);
			return;
		}
		//숫자가 그냥 8 이렇게만 들어왔을 수도 있으니까 08로 바꾸는 작업 필요함
		inputTime = String.format("%02d", Integer.parseInt(inputTime));
		search(inputDay, inputTime);
	}
	

	private static boolean isValidTime(String inputTime) {
		if (!inputTime.matches("[0-9]{1,2}")) {
			return false;
		}
		if (Integer.parseInt(inputTime) < 6 || Integer.parseInt(inputTime) > 9) {
			return false;
			
		}
		return true;
	}

	/**
	 * 입력받은 시간에 사용 가능한 강의실을 검색하는 메소드입니다.
	 * @param dayOfWeek
	 * @param time
	 */
	public static void search(String dayOfWeek, String time) {
		
		//RoomData.getRoomList()
		
		//새로운 리스트를 만들어
		//기존 강의실 리스트를 돌면서
		//지금 보고있는 객체를 새로운 리스트에 추가할건데
		//입력받은 스케줄이랑 일치하는지 확인해
		//일치해 ? 그럼 걔는 제외해
		
		
		for (Room r : RoomData.getRoomList()) {
			
			boolean isAvailable = true;
			
			for (String s : r.getSchedule()) {
				
				//공백으로 나눠
				String[] temp = s.split(" ");
				//인풋 형식 요일 : 월, 시간 : 12
				if (temp[0].contains(dayOfWeek) && temp[1].contains(time)) {
					//유효성 검사 이미 했음
					//12:00 에서 11 찾을거니까 contains로 찾아도 됨
					//요일에 있으면서 시간도 일치해? 그럼 이미 사용중
					isAvailable = false;
				}
			}//스케줄루프
			
			if (isAvailable) {
				availableRoom.add(r);
			}
			
		}//강의실 루프

		showAll(availableRoom);
	}


	

	
}
