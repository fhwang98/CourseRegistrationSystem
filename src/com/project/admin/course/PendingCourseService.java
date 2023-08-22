package com.project.admin.course;

import com.project.room.Room;
import com.project.room.RoomData;

public class PendingCourseService {

	
	//승인할거니 ? > 강의실 찾아 
	//강의실을 찾는데 필요한것 요일, 시간
	//TODO 반환값 room?? void?? String??
	public static Room searchRoom(String dayOfWeek, String startTime) {

		boolean isAvailable = true;
		
		for (Room r : RoomData.getRoomList()) {
			
			for (String s : r.getSchedule()) {
				
				//공백으로 나눠
				String[] temp = s.split(" ");
				if (temp[0].contains(dayOfWeek) && temp[1].substring(0, 5).equals(startTime)) {
					//요일 시간 일치해? 그럼 이미 사용중
					isAvailable = false;
				}
			}
			if (isAvailable) {
				return r;
			}
			
		}
		return null;
	}	
}

//강의실을 찾는데 성공하면
//대기 강좌에서 강의실을 추가한 강좌 데이터를 만들고 > 강좌 리스트 추가 > 강좌 파일 수정
//강의실 스케줄에 업데이트
//강의실에 업데이트



