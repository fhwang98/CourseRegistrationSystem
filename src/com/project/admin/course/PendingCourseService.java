package com.project.admin.course;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import com.project.courseinfo.Course;
import com.project.courseinfo.CourseData;
import com.project.room.Room;
import com.project.room.RoomData;

/**
 * 승인 대기 강좌 메뉴에서 할 수 있는 기능들을 모아놓은 클래스입니다.
 * @author eugene
 *
 */
public class PendingCourseService {

	
	/**
	 * 승인 대기중인 강좌의 강의실과 강좌코드를 배정하고
	 * 전체 강좌리스트에 추가한 뒤
	 * 상태를 승인으로 변경하는 메소드 입니다.
	 * @param index
	 */
	public static void acceptCourse(int index) {
		
		Scanner scan = new Scanner(System.in);
		CourseData.allCourseList();
		System.out.println("사용 가능한 강의실을 찾습니다.");
		scan.nextLine();
		
		//승인을 진행할 강좌
		PendingCourse p = PendingCourseData.getList().get(index);
		
		//강의를 등록하기 위해서 해야할 일들
		//일단 승인 대기 강좌에서 시작 시간과 요일을 가져와
		String dow = p.getDayOfWeek();
		String startTime = p.getStartTime();
		//요일과 시작시간에 비어있는 강의실을 찾아
		String roomNum = searchRoom(dow, startTime);
		//못찾았으면 -> 바로 반려
		if (roomNum.equals("")) {
			System.out.println("강의실을 찾지 못했습니다.");
			rejectCourse(index);
			return;
		}
		
		
		//찾았다 -> 그럼 등록할거야
		//등록 과정 -> 일단 지금 강좌의 카테고리를 확인해
		//{"문화" C, "블럭교실" B, "피아노" P, "체육"H, "어린이"K};
		String categoryCode = getCategoryCode(p.getCategory());
		
		//지금 카테고리에 강좌가 몇번까지 있는지 확인해
		//문자+번호 -> 강좌 코드 생성
		String courseCode = getCourseCode(categoryCode);
		
		// 이제 필요한 정보가 모였으니까 강좌 코드 리스트와 파일에 새로운 강좌를 추가할거야
		//강좌 데이터 형식
		
		//수강료 = 픽스
		//수강달 = 현재달 + 1
		Calendar c = Calendar.getInstance();
		int year = Calendar.YEAR;
		int month = (Calendar.MONTH) % 12 + 1;
		
		/*

			public Course(String num, String category, String courseName, String time, String day, String target,
			String courseFee, String person, String teacherNum, String contents, String startDay, String roomNum)
		
		
		*/
		//리스트에 추가
		Random rnd = new Random();
		
		
		Course pendingToCourse = new Course(courseCode, p.getCategory(), p.getCourseName(),p.getStartTime(), p.getDayOfWeek()
				, p.getTarget(), String.format("%d", (rnd.nextInt(20) + 45000)), "0", p.getTeacherNum() ,p.getCourseExplanation(), String.format("%d%02d", year, month) ,roomNum);
		CourseData.courseList.add(pendingToCourse);
		
		//파일에 추가
		//강좌코드, 카테고리, 강좌명, 시작시간, 요일, 대상, 수강료, 현재신청인원, 강좌내용, 수업하는 달, 강의실 넘버
		updateDataCourseFile(pendingToCourse);
		
		//추가가 끝났으니까 이제 승인 대기중인 강좌 리스트에서 대기 -> 승인으로 상태를 바꾸고 승인대기목록 파일을 업데이트 할거야
		p.setStatus("승인");
		p.setRoomNum(roomNum);
		p.setCourseCode(courseCode);
		PendingCourseData.update();
		
		
		System.out.println("강의실 배정이 완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력해 주세요.");
		scan.nextLine();
	}

	/**
	 * 승인후 생성된 Course 객체를 파일에 저장하는 메소드 입니다.
	 * @param Course 객체
	 */
	private static void updateDataCourseFile(Course c) {
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter("data/dataCourse.txt", true));
			//강좌코드, 카테고리, 강좌명, 시작시간, 요일, 대상, 수강료, 현재신청인원, 강좌내용, 수업하는 달, 강의실 넘버
			writer.write(c.getNum() + "," + c.getCategory() + "," + c.getCourseName() + "," + c.getTime() +":00"
			 		+ "," + c.getDay() + "," + c.getTarget() + "," + c.getCourseFee() + "," + c.getPerson() + "," + c.getTeacherNum()
			 		 + "," + c.getContents() + "," + c.getStartDay() + "," + c.getRoomNum());
			
			
			writer.newLine();
			
			
			writer.close();
		} catch (Exception e) {
			System.out.println("at PendingCourseService.acceptCourse");
			e.printStackTrace();
		}
	}
	
	/**
	 * 카테고리를 인자로 받아 기존의 강좌와 겹치지 않는 강좌코드를 생성해 반환하는 메소드입니다.
	 * @param category
	 * @return 강좌 코드
	 */
	private static String getCourseCode(String category) {
		
		
		boolean isAvailable = true;
		
		for (int i = 0; i < CourseData.courseList.size(); i++) {
			String courseCode = String.format("%s%03d", category, (i + 1));
			for (Course c : CourseData.courseList) {
				if (c.getNum().equals(courseCode)) {
					isAvailable = false;
				}
			}
			if (isAvailable) {
				return courseCode;
			}
		}
		return String.format("%s%03d", category, CourseData.courseList.size());

	}

	/**
	 * 카테고리를 입력받아 영문자로 반환하는 메소드입니다.
	 * @param category
	 * @return 카테고리 문자
	 */
	private static String getCategoryCode(String category) {
		if (category.equals("문화")) {
			return "C";
		} else if (category.equals("블럭교실")) {
			return "B";
		} else if (category.equals("피아노")) {
			return "P";
		} else if (category.equals("체육")) {
			return "H";
		} else if (category.equals("어린이")) {
			return "K";
		}
		return "";
	}

	/**
	 * 사용가능한 강의실을 찾아 강의실 번호를 반환해주는 메소드입니다.
	 * @param dow
	 * @param startTime
	 * @return 강의실 번호
	 */
	private static String searchRoom(String dow, String startTime) { //월 12 이런식으로 들어옴
		
		RoomData.load();
		boolean isAvailable = true;
		
		//전체 강의실을 돌면서 처음 만난 비어있는 강의실의 강의실 넘버를 반환할거야
		for (Room r : RoomData.getRoomList()) {
			
			for (String schedule : r.getSchedule()) {
				
				//만약에 스케줄이 겹쳐 그럼 false
				//schedule : '월 12:00'
				if (schedule.substring(0, 5).equals(dow + " " + startTime)) {
					isAvailable = false;
				}
				
			}
			//만약 지금 강의실이 available이야
			//그럼 얘의 이름을 반환해
			//false야? 다음 강의실 확인해
			if (isAvailable) {
				return r.getRoomNum();
			}
			
		}
		
		//끝까지 다 돌았는데 available이 false다? 
		//그러면 바로 리젝트를 때려
		return "";
		
	}

	/**
	 * 승인 대기 강좌를 반려상태로 변경하는 메소드 입니다.
	 * @param index
	 */
	public static void rejectCourse(int index) {
		

		PendingCourseData.getList().get(index).setStatus("반려");
		PendingCourseData.update();
		
		System.out.println("등록이 반려되었습니다.");
		System.out.println();
		//반려를 진행합시다.
	}

}


