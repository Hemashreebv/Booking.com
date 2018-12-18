package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.HotelDAO;
import com.booking.model.AddHotel;
import com.booking.model.HotelFound;
import com.booking.model.HotelReview;
import com.booking.model.SearchCriteria;

@Service
public class HotelService {
	
	
	@Autowired
	HotelDAO hotelSearchDAO;
	

	public List<HotelFound> getHotel(SearchCriteria searchCriteria) {
		
		List<HotelFound> hotelFound = hotelSearchDAO.getHotel(searchCriteria);
		return hotelFound;
	}


	public Integer getHotelRating(int hotelid) {
		Integer rating = hotelSearchDAO.getHotelRating(hotelid);
		return rating;

	}


	public String addHotel(AddHotel addHotel) {
		String responceMessage =hotelSearchDAO.addHotel(addHotel);


		return responceMessage;
	}




	public String addHotelReview(HotelReview hotelReview) {
		String responceMessage =hotelSearchDAO.addHotelReview(hotelReview);


		return responceMessage;
	}


	public String deleteHotel(int deleteHotel) {
		String responceMessage =hotelSearchDAO.deleteHotel(deleteHotel);
		return responceMessage;
	}

	
	
	
	
	

}
