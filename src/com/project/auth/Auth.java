package com.project.auth;

/**
 * 
 * 모든 회원유형의 코드, 유형번호, id, 이름 데이터가 담긴 클래스
 *
 */
public class Auth {

	private String allCode;
	private String choiceCode;
	private String id;
	private String name;

	public Auth() {

		this.allCode = null;
		this.choiceCode = null;
		this.id = null;
		this.name = null;
	}

	public Auth(String[] authLine) {
		this.setAuth(authLine);
	}

	public void setAuth(String[] authLine) {
		this.allCode = authLine[0];
		this.choiceCode = authLine[1];
		this.id = authLine[2];
		this.name = authLine[3];

	}

	public String getChoiceCode() {
		return choiceCode;
	}

	public void setChoiceCode(String choiceCode) {
		this.choiceCode = choiceCode;

	}

	public String getAllCode() {
		return allCode;
	}

	public void setAllCode(String allCode) {
		this.allCode = allCode;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return allCode + "," + choiceCode + "," + id + "," + name + "\r\n";
	}

}
