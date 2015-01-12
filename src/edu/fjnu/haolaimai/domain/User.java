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
	/** 真实姓名*/
	private String tureName;
	/** 出生日期*/
	private String birthday;
	/** 用户邮箱*/
	private String email;
	/** 电话号码*/
	private String phoneNumber;
	/** 地址*/
	private String address;
	/** 邮编*/
	private int zipCode;
	/** 用户状态*/
	private int userStatus;
	
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
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public String getTureName() {
		return tureName;
	}
	public void setTureName(String tureName) {
		this.tureName = tureName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
