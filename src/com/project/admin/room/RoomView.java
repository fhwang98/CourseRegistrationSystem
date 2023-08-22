package com.project.admin.room;

import java.util.ArrayList;

import com.project.room.RoomData;

public class RoomView {
	
	public static void printRoomHead() {
		System.out.println("=====================================");
		System.out.println("\t\t\t\t강의실 관리");
		System.out.println("=====================================");
		
	}

	public static void printRoomMenu() {
		printRoomHead();
		System.out.println("\t0.\t뒤로가기");
		System.out.println("\t1.\t전체 강의실 조회");
		System.out.println("\t2.\t강의실 검색");
		System.out.println("--------------------------------------------------");
		System.out.println("번호 입력:");
	}

	public static void printRoom(int index) {
		
		System.out.printf("강의실 번호: %s\n", RoomData.getRoomList().get(index).getRoomNum());
		
		ArrayList<String> schedule = RoomData.getRoomList().get(index).getSchedule();
		for (int i = 0; i < schedule.size(); i++ ) {
			
			if (i == 0) {
				System.out.printf("강의 일정:\t%s\n",schedule.get(i).replace("_ _ (_)", "없음").replace("-오전", "").replace("-오후", ""));
			} else {
				System.out.printf("\t\t%s\n",schedule.get(i).replace("-오전", "").replace("-오후", ""));
			}
		}
		
	}
	
	public static void printRoomList(int page) {
		printRoomHead();
		for (int i = 0; i < 10 ; i++) {
			System.out.println();
			printRoom(i + page * 10);
		}
	}
	
	public static void printRoomListMenu(int page, int lastpage) {
		System.out.println("--------------------------------------------------");
		System.out.println("0. 뒤로가기");
		if (page == 0) {
			System.out.println("1. 다음 페이지");
		} else if (page == lastpage) {
			System.out.println("1. 이전 페이지");			
		} else {
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
		}
		System.out.println("--------------------------------------------------");
		System.out.println("번호 입력:");
	}

	public static void printSearchSelectDay() {

		System.out.println("사용 가능한 강의실을 찾습니다.");
		System.out.println("요일을 선택해 주세요");
		System.out.println("--------------------------------------------------");
		System.out.println("1. 전체");
		System.out.println("2. 월수금");
		System.out.println("3. 화목");
		
	}
	
	public static void printSearchSelectSlot() {
		
		System.out.println("시간대를 선택해 주세요");
		System.out.println("--------------------------------------------------");
		System.out.println("1. 전체");
		System.out.println("2. 오전");
		System.out.println("3. 오후");
		
	}
	
}
