package com.booking.model;

public class Facilitie {
	private Boolean wifi;
	private Boolean restaurantAvailable;
	private Boolean airConditioning;
	private Boolean mealsIncluded;
	public Boolean getWifi() {
		return wifi;
	}
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}
	public Boolean getRestaurantAvailable() {
		return restaurantAvailable;
	}
	public void setRestaurantAvailable(Boolean restaurantAvailable) {
		this.restaurantAvailable = restaurantAvailable;
	}
	public Boolean getAirConditioning() {
		return airConditioning;
	}
	public void setAirConditioning(Boolean airConditioning) {
		this.airConditioning = airConditioning;
	}
	public Boolean getMealsIncluded() {
		return mealsIncluded;
	}
	public void setMealsIncluded(Boolean mealsIncluded) {
		this.mealsIncluded = mealsIncluded;
	}
	public Facilitie(Boolean wifi, Boolean restaurantAvailable, Boolean airConditioning, Boolean mealsIncluded) {
		this.wifi = wifi;
		this.restaurantAvailable = restaurantAvailable;
		this.airConditioning = airConditioning;
		this.mealsIncluded = mealsIncluded;
	}
	public Facilitie() {
		// TODO Auto-generated constructor stub
	} 

	
	
}
