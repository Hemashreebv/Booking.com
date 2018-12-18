package com.booking.model;

public class HotelFound {
	private String hotelName;
	private int costToStay;
	private int ratingScore;
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getCostToStay() {
		return costToStay;
	}
	public void setCostToStay(int costToStay) {
		this.costToStay = costToStay;
	}
	public int getRatingScore() {
		return ratingScore;
	}
	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
	
	
	public HotelFound() {
	
		// TODO Auto-generated constructor stub
	}
	public HotelFound(String hotelName, int costToStay, int ratingScore) {
	
		this.hotelName = hotelName;
		this.costToStay = costToStay;
		this.ratingScore = ratingScore;
	}
	

}
