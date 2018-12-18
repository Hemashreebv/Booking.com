package com.booking.model;

import java.sql.Date;

public class UserDetails {

	private String userName;
	private String emailid;
	private int phone;
	private String createdBy;
	private Date createdOn;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public UserDetails(String userName, String emailid, int phone, String createdBy, Date createdOn) {
		this.userName = userName;
		this.emailid = emailid;
		this.phone = phone;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
}
