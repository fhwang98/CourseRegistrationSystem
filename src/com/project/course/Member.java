package com.project.course;
/**
 * 회원 정보를 저장하기 위한 클래스입니다.
 */
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

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum
				+ ", birth=" + birth + ", discount=" + discount + ", bank=" + bank + ", accountNum=" + accountNum
				+ ", delete=" + delete + "]";
	}

	/**
	 * 생성자로, 회원정보를 초기화 합니다.
	 * 
	 * @param no 회원코드
	 * @param id 회원 아이디
	 * @param pwd 회원 비밀번호
	 * @param name 회원 이름
	 * @param phoneNum 회원 전화번호
	 * @param birth 회원 생년월일
	 * @param discount 회원 할인 정보
	 * @param bank 회원 은행 정보
	 * @param accountNum 회원 계좌번호
	 * @param delete 회원 탈퇴 여부
	 */
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
	
	/**
	 * 회원 코드를 반환합니다.
	 * @return 회원코드
	 */
	public String getNo() {
		return no;
	}
	
	/**
	 * 회원 코드를 설정합니다.
	 * @param no 회원 코드
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 회원 아이디를 반환합니다.
	 * @return 회원 아이디
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 회원 아이디를 설정합니다.
	 * @param id 회원 아이디
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 회원 비밀번호를 반환합니다.
	 * @return 회원 비밀번호
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * 회원 비밀번호를 설정합니다.
	 * @param pwd 회원 비밀번호
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * 회원 이름을 반환합니다.
	 * @return 회원 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 회원 이름을 설정합니다.
	 * @param name 회원이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 회원 전화번호를 반환합니다.
	 * @return 회원 전화번호
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * 회원 전화번호를 설정합니다.
	 * @param phoneNum 회원 전화번호
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * 회원 생년월일을 반환합니다.
	 * @return 회원 생년월일
	 */
	public String getBirth() {
		return birth;
	}
	
	/**
	 * 회원 생년월일을 설정합니다.
	 * @param birth 회원 생년월일
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	/**
	 * 회원 할인 정보를 반환합니다.
	 * @return 회원 할인 정보
	 */
	public String getDiscount() {
		return discount;
	}
	
	/**
	 * 회원 할인 정보를 설정합니다.
	 * @param discount 회원 할인 정보
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	/**
	 * 회원 은행 정보를 반환합니다.
	 * @return 회원 은행 정보
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 회원 은행 정보를 설정합니다.
	 * @param bank 회원 은행 정보
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	/**
	 * 회원 계좌 번호를 반환합니다.
	 * @return 회원 계좌번호
	 */
	public String getAccountNum() {
		return accountNum;
	}
	
	/**
	 * 회원 계좌번호를 설정합니다.
	 * 
	 * @param accountNum 회원 계좌번호
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	/**
	 * 회원 탈퇴여부를 반환합니다.
	 * 
	 * @return 회원 탈퇴여부
	 */
	public String getDelete() {
		return delete;
	}
	
	/**
	 * 회원 탈퇴여부를 설정합니다.
	 * 
	 * @param delete 회원 탈퇴여부
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	

	
	
}
