package com.project.auth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class AuthDbms {
	private final static String dataAuthPath = "../data/authData.txt"; // 상대경로 설정

	public ArrayList<Auth> selectAuth() {
		
		//Auth 객체 담는 ArrayList 변수 선언
		ArrayList<Auth> authList = new ArrayList<Auth>();
		
		//파일 객체생성
		File f = new File(dataAuthPath);
		
		
		if (f.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(f.getPath()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] authLine = line.split(",");	//읽은 라인 split 함수써서 구분자 ,로 자른다
					Auth a = new Auth(authLine);	//Auth 객체 선언해서 스플릿 한배열넣어서 초기화한다
					authList.add(a); //반환할 ArrayList 객체에 담는다
				}
				reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		return authList;

	}
	
	//selectAuth 오버라이딩
	public Auth selectAuth(String allCode) {	//파라미터 String allCode
		Auth auth = null;	//리턴 Auth 초기화
		for (Auth a : selectAuth()) {	//selectAuth 메서드로 얻은 Auth 객체들 중 일치하는 allCode찾기
			if (a.getAllCode().equals(allCode)) {	
				auth = a;	// 일치하는 객체를 auth 변수에 저장
			}
		}
		return auth;	// 찾은 일치하는 객체를 반환
	}
	
	//selectAuth 오버라이딩
	public Auth selectAuth(Auth auth) {	//파라미터는 Auth auth
		
		 // Auth 객체의 getAllCode() 메서드로 얻은 allCode 값을 사용하여
	    // selectAuth 메서드를 호출하여 반환된 값을 반환
		return this.selectAuth(auth.getAllCode());	//
	}
	
	/**
     * Auth 객체를 authList에 추가
     *
     * @param auth에 추가할 Auth 객체
     * @param append true인 경우 리스트의 마지막에 추가
     * 
     */	
	public void insertAuth(Auth auth, boolean append) {
		File authFile = new File(dataAuthPath);
		try {
			 // BufferedWriter를 생성하여 authFile에 데이터를 기록
		    // append 값에 따라 덮어쓰기 또는 이어쓰기 모드로 파일열기
			BufferedWriter bw = new BufferedWriter(new FileWriter(authFile, append));
			bw.write(auth.toString());	// auth 객체의 문자열 표현을 파일에 기록
			bw.flush();	//버퍼를 비워주고 
			bw.close(); //파일을 닫습니다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertAuth(Auth auth) {
		//selectAuth 메서드로 주어진 Auth 객체와 일치하는지 확인
		if (selectAuth(auth) == null) {
		  // 일치하는 Auth 객체가 없는 경우에만 insertAuth 메서드를 호출하여 추가
			this.insertAuth(auth, true);
		}
	}
	
	//로그아웃할때 사용
	public void deleteAuth(Auth auth) {
		ArrayList<Auth> list = selectAuth();// selectAuth 메서드로 Auth 객체 리스트를 받아옴
		if (selectAuth(auth) != null) {	//주어진 Auth 객체가 존재하는지 확인
			int i = 0;
			
			// Auth 객체 리스트 중 주어진 Auth 객체와 다른 객체를 찾아서 처리
			for (Auth a : list) {
				if (!a.getAllCode().equals(auth.getAllCode())) {
					if (i == 0) {
						 // 첫 번째 객체는 덮어쓰기 모드 추가
						insertAuth(a, false);
					} else {
						// 그 외 객체들은 이어쓰기 모드 추가
						insertAuth(a, true);
					}
					i++;	  // 주어진 Auth 객체와 같은 경우 제외하고 나머지 객체를 추가
				}
			}
		}
	}

	public void printAuthList() {
		for (Auth a : selectAuth()) {
			System.out.print(a.toString());
		}
	}
}
