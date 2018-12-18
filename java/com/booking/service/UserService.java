package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.HotelDAO;
import com.booking.dao.UserDAO;
import com.booking.model.UserDetails;

@Service
public class UserService {
	
	
	@Autowired
	UserDAO userDAO;

	public String addUser(UserDetails userDetails) {
		String responseMessage  = userDAO.addUser(userDetails);
		return responseMessage;
	}

	public String deleteUser(int userId) {
		String responseMessage  = userDAO.deleteUser(userId);
		return responseMessage;
	}

}
