package com.project.admin.room;

import java.util.ArrayList;

import com.project.room.Room;

public class RoomView {
	
	public static void printRoomHead() {
		System.out.println("=============================================");
		System.out.println("\t\t강의실 관리");
		System.out.println("=============================================");
		
	}

	public static void printRoomMenu() {
		printRoomHead();
		System.out.println("  0.\t뒤로가기");
		System.out.println("  1.\t전체 강의실 조회");
		System.out.println("  2.\t강의실 검색");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력:");
	}

	public static void printRoom(int index, ArrayList<Room> list) {
		
		System.out.printf("강의실 번호:\t%s\n", list.get(index).getRoomNum());
		
		ArrayList<String> schedule = list.get(index).getSchedule();
		for (int i = 0; i < schedule.size(); i++ ) {
			
			if (i == 0) {
				System.out.printf("강의 일정\t:\t%s\n",schedule.get(i).replace("_ _ (_)", "없음"));
			} else {
				System.out.printf("\t\t%s\n",schedule.get(i));
			}
		}
		
	}
	
	public static void printRoomList(int page, ArrayList<Room> list) {
		printRoomHead();
		for (int i = 0; i < 5 ; i++) {
			System.out.println();
			printRoom(i + page * 5, list);
		}
	}
	
	public static void printRoomListMenu(int page, int lastpage) {
		System.out.println("---------------------------------------------");
		System.out.println("0. 뒤로가기");
		if (page == 0) {
			System.out.println("1. 다음 페이지");
		} else if (page == lastpage) {
			System.out.println("1. 이전 페이지");			
		} else {
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
		}
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력:");
	}

	public static void printSearchSelectDay() {

		System.out.println("사용 가능한 강의실을 찾습니다.");
		System.out.println("요일을 입력해 주세요");
		System.out.println("예시) 월");
		System.out.println("예시) 월수금");
		System.out.print("요일 입력: ");
		
	}
	
	public static void printSearchSelectTime() {
		
		System.out.println("시작 시간을 입력해 주세요");
		System.out.println("6시부터 22시 사이의 숫자를 입력해주세요.");
		System.out.println("예시) 6");
		System.out.println("예시) 12");
		System.out.println("시간 입력: ");
		
	}
	
}
