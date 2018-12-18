package com.booking.model;

import java.util.Date;
import java.util.List;

public class SearchCriteria {
	
	private String city;;
	private Date date;
	private String noOfRoom;
	private String noOfTravellers;
	private List<Hotel> hotel;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public java.sql.Date getDate() {
		return (java.sql.Date) date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNoOfRoom() {
		return noOfRoom;
	}
	public void setNoOfRoom(String noOfRoom) {
		this.noOfRoom = noOfRoom;
	}
	public String getNoOfTravellers() {
		return noOfTravellers;
	}
	public void setNoOfTravellers(String noOfTravellers) {
		this.noOfTravellers = noOfTravellers;
	}
	public List<Hotel> getHotel() {
		return hotel;
	}
	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}
	
	
	public SearchCriteria() {
		// TODO Auto-generated constructor stub
	}
	public SearchCriteria(String city, Date date, String noOfRoom, String noOfTravellers, List<Hotel> hotel) {
		this.city = city;
		this.date = date;
		this.noOfRoom = noOfRoom;
		this.noOfTravellers = noOfTravellers;
		this.hotel = hotel;
	}
	
	

}
