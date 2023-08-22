package com.project.admin.user.test;

public class User {
	private String userNum;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String bday;
	private int discountNum;
	private String bank;
	private String accountNum;
	private int withdrawn;

	public User(String num, String id, String pw, String name, String phone, String bday, int discountNum, String bank,
			String accountNum, int withdrawn) {
		this.userNum = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.bday = bday;
		this.discountNum = discountNum;
		this.bank = bank;
		this.accountNum = accountNum;
		this.withdrawn = withdrawn;
	}

	@Override
	public String toString() {
		return "[num=" + userNum + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", bday="
				+ bday + ", discountNum=" + discountNum + ", bank=" + bank + ", accountNum=" + accountNum
				+ ", withdrawn=" + withdrawn + "]";
	}

	public String getUserNum() {
		return userNum;
	}

	public void setNum(String userNum) {
		this.userNum = userNum;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public int getDiscountNum() {
		return discountNum;
	}

	public void setDiscountNum(int discountNum) {
		this.discountNum = discountNum;
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

	public int getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(int withdrawn) {
		this.withdrawn = withdrawn;
	}

}
