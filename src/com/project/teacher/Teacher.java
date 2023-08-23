package com.project.teacher;
import com.project.user.login.LoginMain;
import com.project.user.login.LoginTeacher;
import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;
import com.project.auth.Auth;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {

	public static void mypage() {

		Scanner scan = new Scanner(System.in);

		int input = 0;

		System.out.println("          강사 마이페이지");
		System.out.println("—-------------------------------------");
		System.out.println("0. 메인화면 돌아가기");
		System.out.println("1. 내 정보 조회/수정");
		System.out.println("2. 회원 탈퇴");
		System.out.println("—-------------------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();

		if (input == 0) {

			// 연결시켜

		} else if (input == 1) {

			Teacher.checkInformation();

		} else if (input == 2) {

			// 방법 통일 해야함 다시 의논

		} else {

			System.out.println("잘못된 입력입니다.");
		}
	}

	public static void checkInformation() {

		Scanner scan = new Scanner(System.in);

		ArrayList<DataTeacher> list = UserDbms.getTeacherAllList();
		
		//강사 로그인 데이터 가져오기
		LoginMain lista = new LoginMain();
		ArrayList<DataTeacher> loginList = lista.getLoginTList();
		System.out.println(lista.getLoginTList());
		
	}
//		System.out.println(loginList.get(0).getId());
//		// 향상된 for 문은 writer 과정에서 오류가 날 수 있으므로 오류 발생 시 for문으로 수정해야함
//		for (DataTeacher data : list) {
//
//			if (data.getId().equals(loginList.get(0).getId())) {
//				int input = 0;
//				String name = "";
//				String phone = "";
//				
//				System.out.println("    강사 마이페이지 > 내 정보 조회 및 수정");
//				System.out.println("—-------------------------------------");
//				System.out.println("아이디: " + data.getId());
//				System.out.println("이름: " + data.getName());
//				System.out.println("전화번호: " + data.getTel());
//				System.out.println("강사코드: " + data.getTeacherCode());
//				System.out.println("0. 마이페이지 돌아가기");
//				System.out.println("1. 이름");
//				System.out.println("2. 전화번호");
//				System.out.println("—-------------------------------------");
//				System.out.print("번호 입력 : ");
//
//				input = scan.nextInt();
//
//				if (input == 0) {
//
//					Teacher.mypage();
//
//				} else if (input == 1) {
//
//					System.out.print("수정할 이름을 입력하세요: ");
//
//					name = scan.nextLine();
//
//					modifyByName(loginList.get(0), name);
//
//				} else if (input == 2) {
//
//					System.out.print("수정할 전화번호를 입력하세요: ");
//
//					phone = scan.nextLine();
//
//					modifyByPhone(loginList.get(0), phone);
//
//				} else {
//
//					System.out.println("잘못된 입력입니다.");
//
//				}
//
//			}
//
//		}
//
//	}

	private static void modifyByName(DataTeacher dataTeacher, String name) {

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataTeacher.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {
				// 현재 줄을 split
				String[] temp = line.split(",");

				String curCode = temp[0];
				String curId = temp[1];
				String curPw = temp[2];
				String curName = temp[3];
				String curTel = temp[4];
				String curBirth = temp[5];
				String curWithdrawal = temp[6];

				// 현재 줄의 강사 코드와 현재 강사 코드가 같은지 비교
				if (curCode.equals(dataTeacher)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					curName = name;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(curCode + "," + curId + "," + curPw + "," + curName + "," + curTel + "," + curBirth + ","
						+ curWithdrawal + "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

	private static void modifyByPhone(DataTeacher dataTeacher, String phone) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data\\dataTeacher.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {
				// 현재 줄을 split
				String[] temp = line.split(",");

				String curCode = temp[0];
				String curId = temp[1];
				String curPw = temp[2];
				String curName = temp[3];
				String curTel = temp[4];
				String curBirth = temp[5];
				String curWithdrawal = temp[6];

				// 현재 줄의 강사 코드와 현재 강사 코드가 같은지 비교
				if (curCode.equals(dataTeacher)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					curTel = phone;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(curCode + "," + curId + "," + curPw + "," + curName + "," + curTel + "," + curBirth + ","
						+ curWithdrawal + "\r\n");

			}

			// 파일 작성
			writer.write(sb.toString());

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

//	public void modifyInformation() {
//
//		Scanner scan = new Scanner(System.in);
//
//		int input = 0;
//		String name = "";
//		String phone = "";
//
//		System.out.println("       강사 마이페이지 > 내 정보 수정");
//		System.out.println("—-------------------------------------");
//		System.out.println("0. 마이페이지 돌아가기");
//		System.out.println("1. 이름");
//		System.out.println("2. 전화번호");
//		System.out.println("—-------------------------------------");
//		System.out.print("번호 입력 : ");
//
//		input = scan.nextInt();
//
//		if (input == 0) {	
//			
//			Teacher mypage = new Teacher();
//			mypage.mypage();
//			
//		} else if (input == 1) {
//			
//			System.out.print("수정할 이름을 입력하세요: ");
//			name = scan.nextLine();
//			
//		} else if (input == 2) {
//			
//			System.out.print("수정할 전화번호를 입력하세요: ");
//			phone = scan.nextLine();
//			
//		} else {
//			
//			System.out.println("잘못된 입력입니다.");
//		}
//		
//		
//		
//		
//	}

}// class
