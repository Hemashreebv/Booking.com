package com.booking.dao;

import java.util.List;

import com.booking.model.AddHotel;
import com.booking.model.HotelFound;
import com.booking.model.HotelReview;
import com.booking.model.SearchCriteria;

public interface HotelDAO {

	List<HotelFound> getHotel(SearchCriteria searchCriteria);

	Integer getHotelRating(int hotelid);

	String addHotel(AddHotel addHotel);

	String addHotelReview(HotelReview hotelReview);

	String deleteHotel(int deleteHotel);


}
