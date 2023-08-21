package com.project.user.mypage;

public class Member {

	private String no;
	private String id;
	private String pwd;
	private String name;
	private String phoneNum;
	private String birth;
	private String discount;
	private String bank;
	private String accountNum;
	private String delete;

	public Member(String no, String id, String pwd, String name, String phoneNum, String birth, String discount,
			String bank, String accountNum, String delete) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phoneNum = phoneNum;
		this.birth = birth;
		this.discount = discount;
		this.bank = bank;
		this.accountNum = accountNum;
		this.delete = delete;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getDiscount() {
		return discount;
	}
	
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public String getBank() {
		return bank;
	}
	
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getDelete() {
		return delete;
	}
	
	public void setDelete(String delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", birth=" + birth + ", discount=" + discount + ", bank=" + bank + ", accountNum=" + accountNum
				+ ", delete=" + delete + "]";
	}

	
	
}
