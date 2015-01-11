/**
 * 
 */
package edu.fjnu.haolaimai.domain;

/**
 * 管理员
 * 
 * @author lingqiusang
 *
 */
public class Admin {
	/** 管理员ID*/
	private int admindId;
	/** 管理员用户名*/
	private String adminName;
	/** 管理员密码*/
	private String adminPwd;
	/** 管理员级别*/
	private int adminGrade;
	/** 管理员名字*/
	private String adminNickName;
	
	public String getAdminNickName() {
		return adminNickName;
	}
	public void setAdminNickName(String adminNickName) {
		this.adminNickName = adminNickName;
	}
	public int getAdmindId() {
		return admindId;
	}
	public void setAdmindId(int admindId) {
		this.admindId = admindId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getAdminGrade() {
		return adminGrade;
	}
	public void setAdminGrade(int adminGrade) {
		this.adminGrade = adminGrade;
	}
	@Override
	public String toString() {
		return "Admin [admindId=" + admindId + ", adminName=" + adminName
				+ ", adminPwd=" + adminPwd + ", adminGrade=" + adminGrade + "]";
	}	
}
