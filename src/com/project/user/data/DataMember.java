package com.project.user.data;

import java.util.Arrays;

public class DataMember {

	private String memberCode;
	private String id;
	private String password;
	private String name;
	private String tel;
	private String birth;
	private int discount;
	private String refundBank;
	private String refundAccountNum;
	private int using;

	public DataMember() {
		this.memberCode = "";
		this.id = "";
		this.password = "";
		this.name = "";
		this.tel = "";
		this.birth = "";
		this.discount = 0;
		this.refundBank = "";
		this.refundAccountNum = "";
		this.using = 0;
	}

	public DataMember(String[] memberLine) {
		this.setDataMemeber(memberLine);
	}

	public void setDataMemeber(String[] memberLine) {
		System.out.println(Arrays.toString(memberLine));
		this.memberCode = memberLine[0];
		this.id = memberLine[1];
		this.password = memberLine[2];
		this.name = memberLine[3];
		this.tel = memberLine[4];
		this.birth = memberLine[5];
		this.discount = Integer.parseInt(memberLine[6]);
		this.refundBank = memberLine[7];
		this.refundAccountNum = memberLine[8];
		this.using = Integer.parseInt(memberLine[9]);
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		String temp = tel.replaceAll("-","");
		this.tel = temp;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getRefundBank() {
		return refundBank;
	}

	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	public String getRefundAccountNum() {
		return refundAccountNum;
	}

	public void setRefundAccountNum(String refundAccountNum) {
		this.refundAccountNum = refundAccountNum;
	}

	public int getUsing() {
		return using;
	}

	public void setUsing(int using) {
		this.using = using;
	}

	@Override
	public String toString() {
		return memberCode + "," + id + "," + password + "," + name + "," + tel + "," + birth + "," + discount + ","
				+ refundBank + "," + refundAccountNum + "," + using;
	}

}
