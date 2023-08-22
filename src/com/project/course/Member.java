package com.project.course;

public class Member {
//회원코드, 아이디, 비밀버노, 이름, 전화버노,생년월일, 할인여부, 은행명, 계좌번호, 탈퇴여부
	private String memberCode;
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	private String birthDay;
	private String discount;
	private String bankName;
	private String bankNum;
	private String out;
	
	
	
	
	public Member(String memberCode, String id, String pw, String name, String phoneNum, String birthDay,
			String discount, String bankName, String bankNum, String out) {
		super();
		this.memberCode = memberCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthDay = birthDay;
		this.discount = discount;
		this.bankName = bankName;
		this.bankNum = bankNum;
		this.out = out;
	}
	
	public String getMembercode() {
		return memberCode;
	}
	public void setMembercode(String membercode) {
		this.memberCode = membercode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}

	@Override
	public String toString() {
		return "Member [membercode=" + memberCode + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phoneNum="
				+ phoneNum + ", birthDay=" + birthDay + ", discount=" + discount + ", bankName=" + bankName
				+ ", bankNum=" + bankNum + ", out=" + out + "]";
	}
	
}
