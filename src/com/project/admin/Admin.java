package com.project.admin;

/**
 * 관리자의 회원정보를 저장할 클래스입니다.
 * @author eugene
 *
 */
public class Admin {

	private String adminNo;
	private String adminId;
	private String adminPwd;
	private String adminName;
	private String adminPhone;
	private String adminbirth;
	private String adminDelete;
	
	/**
	 * 관리자 클래스를 만드는 생성자입니다.
	 * @param adminNo
	 * @param adminId
	 * @param adminPwd
	 * @param adminName
	 * @param adminPhone
	 * @param adminbirth
	 * @param adminDelete
	 */
	public Admin(String adminNo, String adminId, String adminPwd, String adminName, String adminPhone,
			String adminbirth, String adminDelete) {
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminPhone = adminPhone;
		this.adminbirth = adminbirth;
		this.adminDelete = adminDelete;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminbirth() {
		return adminbirth;
	}

	public void setAdminbirth(String adminbirth) {
		this.adminbirth = adminbirth;
	}

	public String getAdminDelete() {
		return adminDelete;
	}

	public void setAdminDelete(String adminDelete) {
		this.adminDelete = adminDelete;
	}

	@Override
	public String toString() {
		return "adminInfo [adminNo=" + adminNo + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminName="
				+ adminName + ", adminPhone=" + adminPhone + ", adminbirth=" + adminbirth + ", adminDelete="
				+ adminDelete + "]";
	}
	
	
}
