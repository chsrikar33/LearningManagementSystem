package com.cts.learningmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LMSEntity {
	

	@Id
	private String userEmailId;
	private String userName;
	private String password;
	private String userRole;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public LMSEntity() {
		super();
	}
	public LMSEntity( String userName, String userEmailId, String password,String userRole) {
		super();
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.password = password;
		this.userRole=userRole;
		
	}
	
	

}
