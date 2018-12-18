package com.booking.dao;

import com.booking.model.UserDetails;

public interface UserDAO {

	String addUser(UserDetails userDetails);

	String deleteUser(int userId);

}
