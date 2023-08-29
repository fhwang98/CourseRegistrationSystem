package com.project.authentication;
/**
 * 로그인 한 회원의 코드를 저장하는 클래스입니다.
 */
public class Authentication {
	public static String loginUserCode;
	
	static {
		Authentication.loginUserCode = null;
	}
}
