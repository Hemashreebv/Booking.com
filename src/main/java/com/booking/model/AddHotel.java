package com.booking.model;

import java.util.List;

public class AddHotel {

	private String name;
	private int defaultRating;
    private String city;
    private int costPerDay;
    private List<Facilitie> facilitie;
    private String address;
    private int pincode;
    private String phone;
    private String mailId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDefaultRating() {
		return defaultRating;
	}
	public void setDefaultRating(int defaultRating) {
		this.defaultRating = defaultRating;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}
	public List<Facilitie> getFacilitie() {
		return facilitie;
	}
	public void setFacilitie(List<Facilitie> facilitie) {
		this.facilitie = facilitie;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public AddHotel(String name, int defaultRating, String city, int costPerDay, List<Facilitie> facilitie,
			String address, int pincode, String phone, String mailId) {
		this.name = name;
		this.defaultRating = defaultRating;
		this.city = city;
		this.costPerDay = costPerDay;
		this.facilitie = facilitie;
		this.address = address;
		this.pincode = pincode;
		this.phone = phone;
		this.mailId = mailId;
	}
	public AddHotel() {
		// TODO Auto-generated constructor stub
	}
    
	
}
