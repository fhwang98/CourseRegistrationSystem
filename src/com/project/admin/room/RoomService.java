package com.project.admin.room;

public class RoomService {
	
//
//	public static Scanner scan;
//	
//	static {
//		scan= new Scanner(System.in);
//	}
//	public static void showAll() {
//		
//		// 리스트가 정렬이 되어있
//		int page = 0;
//		int lastPage = RoomScheduleData.getList().size() / 5 - 1;
//		boolean loop = true;
//		while (loop) {
//
//			
//			System.out.println("전체 조회"); // RoomView -> print
//			RoomView.printRoomHead();
//			RoomView.printRoomList(page);
//			RoomView.printRoomListMenu(page, lastPage);
//			
//			String sel = scan.nextLine();
//			if (!AdminUtil.isValidSel(sel, 0, 2)) {
//				System.out.println("is invalid input");
//				System.out.println("enter a new line to going back");
//				scan.nextLine();
//				continue;
//			} else if (sel.equals("0")) {
//				loop = false;
//			} else if (sel.equals("1")) {
//				if (page == 0) {
//					//next page
//					page++;
//				} else {
//					//previous page
//					page--;
//				}
//				
//			} else if (sel.equals("2")) {
//				if (page == 0 || page == lastPage) {
//					//invalid input
//					System.out.println("invalid input");
//				} else {
//					//next page
//					page++;
//				}
//				
//			}
//		}
//	}
//	
//	public static void searchRoom() {
//		
//	}
//	
}
