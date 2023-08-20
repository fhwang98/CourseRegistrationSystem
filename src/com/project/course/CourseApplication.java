package com.project.course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class CourseApplication {

	public static void courseApplication() {
		
		courseApplicationment();
		
	}

	private static void courseApplicationment() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("=====================");
		System.out.println("수강신청");
		System.out.println("=====================");
		System.out.println("수강을 원하는 과정의 강좌코드를 입력하세요.");
		System.out.println("0.뒤로가기");
		System.out.println("---------------------");
		System.out.print("입력: ");
		String code = scan.nextLine();
		
		
		
		if(code.equals("0")) {
		//	Main.mainMent();
		}
		
		try {

				BufferedReader reader = new BufferedReader(new FileReader("data/lectureList.txt"));

				String line = null;

				while ((line = reader.readLine()) != null) {
					
					String[] temp = line.split(",");

					String upperCode = code.toUpperCase();
					
					if (temp[0].equals((upperCode))) {

						System.out.println("수강신청이 완료되었습니다.");
						Course c = new Course(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],
								temp[9], temp[10], temp[11]);

					}
				}
		
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		
	}
}	
		
		//버퍼리더 해서 코드 같은 거 찾아보고 있으면 
		//if(code.equals(더미데이터 변수){
		//System.out.println("수강신청이 완료되었습니다.");
		//이거 또는 
		//같은 코드가 있지만 해당 데이터의 시간과 겹치는지 확인 하는메소드
		//시간이 중복되면
		//System.out.println(“이미 신청된 강좌와 중복 된 시간의 강좌입니다.”);
		//System.out.println(“처음으로 이동합니다.”);
		
}