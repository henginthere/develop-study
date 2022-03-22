package com.ssafy.ws.dto;

import java.util.Date;

public class User {
	
	private String userNo;
	private String userId;
	private String name;
	private String pwd;
	private Date joinDate;
	
	public User() {}

	public User(String userNo, String userId, String name, String pwd, Date joinDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.name = name;
		this.pwd = pwd;
		this.joinDate = joinDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userNo=").append(userNo).append(", userId=").append(userId).append(", name=").append(name)
				.append(", pwd=").append(pwd).append(", joinDate=").append(joinDate).append("]");
		return builder.toString();
	}
	
	

}
