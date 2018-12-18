package com.booking.model;

import java.util.List;

public class Hotel {

	private int stars;
	private List<Facilitie> facilitie;
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public List<Facilitie> getFacilitie() {
		return facilitie;
	}
	public void setFacilitie(List<Facilitie> facilitie) {
		this.facilitie = facilitie;
	}
	public Hotel(int stars, List<Facilitie> facilitie) {
		this.stars = stars;
		this.facilitie = facilitie;
	}
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
