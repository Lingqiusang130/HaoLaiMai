/**
 * 
 */
package edu.fjnu.haolaimai.domain;

/**
 * 用户
 * 
 * @author lingqiusang
 *
 */
public class User {
	/** 用户Id*/
	private int userId;
	/** 用户名*/
	private String userName;
	/** 用户密码*/
	private String userPwd;
	/** 用户邮箱*/
	private String email;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
