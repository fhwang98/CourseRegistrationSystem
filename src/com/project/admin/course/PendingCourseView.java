package com.project.admin.course;

import java.util.ArrayList;

import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;

public class PendingCourseView {

	
	public static void printPendingCourseHead() {
		System.out.println("=============================================");
		System.out.println("\t승인 대기 강좌");
		System.out.println("=============================================");
	}
	
	public static void printPendingCourse(int index) {
		
		/*
		
		승인대기 강좌 관리
		클래스가 어떻게 생겼는지 
		String 강좌명 -> 이름
		String 요일 -> ‘월’
		String 시작 시간 -> (06~22)
		카테고리 -> 문화, 블럭교실, 피아노, 체육, 어린이
		수강대상 ->. 어린이, 청소년, 성인, 누구나
		강좌 내용
		현재 상태
		강사코드
		강좌ㅏ 코드
		*/
		printPendingCourseHead();
		
		PendingCourse p = PendingCourseData.getList().get(index);
		
		System.out.printf("대기 번호\t:\t%s\n", index + 1);
		System.out.printf("강좌명\t:\t%s\n", p.getCourseName());
		System.out.printf("강사명\t:\t%s\n", getTeacherName(p.getTeacherNum())); 
		System.out.printf("요일\t:\t%s\n", p.getDayOfWeek());
		System.out.printf("시간\t:\t%02d:00-%02d:00\n", Integer.parseInt(p.getStartTime()), Integer.parseInt(p.getStartTime()) + 1);
		System.out.printf("카테고리\t:\t%s\n", p.getCategory());
		System.out.printf("수강 대상\t:\t%s\n", p.getTarget());
		System.out.printf("강좌 내용\t:\t%s\n", p.getCourseExplanation());
		System.out.printf("승인 여부\t:\t%s\n", p.getStatus());
		System.out.printf("강의실\t:\t%s\n", p.getRoomNum());
		System.out.printf("강좌 코드\t:\t%s\n", p.getCourseCode());
		System.out.println("---------------------------------------------");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 등록 승인");
		System.out.println("2. 등록 반려");
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력: ");
	}
	
	private static String getTeacherName(String teacherNum) {
		UserDbms list = new UserDbms();
		ArrayList<DataTeacher> allTeacherList = UserDbms.getTeacherAllList();
		
		for (DataTeacher t : allTeacherList) {
			if (t.getTeacherCode().equals(teacherNum)) {
				return t.getName();
			}
		}
		
		
		return null;
	}

	public static void printPendingCourseList(int page) {
		
		//처음부터 10개씩 보여줌

		System.out.println("[번호]\t[강좌명]\t[승인 여부]");
		int size = PendingCourseData.getList().size();
		
		for (int i = 0; i < ((size / 10 == 0) ? size % 10 : 10); i++) {
				
			System.out.printf("%4d.\t", i + 1);
			System.out.print(PendingCourseData.getList().get(i + 10 * page).getCourseName() + "\t ");
			System.out.println(PendingCourseData.getList().get(i + 10 * page).getStatus());
		}
	}
	
	
	
	public static void printPendingCourseMenu(int page, int lastpage) {
		/*
			—---------------------------------
			0. 뒤로가기
			1. 이전 페이지
			2. 다음 페이지
			3. 강좌 선택
		
		*/
		System.out.println("---------------------------------------------");
		System.out.println("0. 뒤로가기");
		if (page == 0) {
			System.out.println("1. 다음 페이지");
			System.out.println("2. 강좌 선택");
		} else if (page == lastpage) {
			System.out.println("1. 이전 페이지");
			System.out.println("2. 강좌 선택");
		} else {
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
			System.out.println("3. 강좌 선택");
		}
		System.out.println("---------------------------------------------");
		System.out.print("번호 입력 : ");
	}
}
