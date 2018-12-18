package com.booking.model;

public class HotelReview {
	
	private String comments;
	private int rating;
	private int hotelId;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public HotelReview(String comments, int rating, int hotelId) {
		this.comments = comments;
		this.rating = rating;
		this.hotelId = hotelId;
	}
	public HotelReview() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
