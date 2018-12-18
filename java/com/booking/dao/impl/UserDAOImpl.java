package com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.booking.dao.UserDAO;
import com.booking.model.UserDetails;

public class UserDAOImpl  implements UserDAO{
	
	
	
	public static final String  INSERT_USER_DEATILS ="insert into USER_DEATILS (NAME,emailid,phone,createdBy,createdOn) values (?,?,?,?,?)";
	public static final String DELETE_USER ="delete from USER where user_id =?";
	@Autowired
	DataSource dataSource;
	@Override
	public String addUser(UserDetails userDetails) {
		try (Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_DEATILS)) {
			pstmt.setString(1, userDetails.getUserName());
			pstmt.setString(2, userDetails.getEmailid());
			pstmt.setInt(3, userDetails.getPhone());
			pstmt.setString(4, "Test user");
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));


			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;

}
	@Override
	public String deleteUser(int userId) {


		String responseMessage = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DELETE_USER)) {
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
			responseMessage ="Deleted Sucessfully";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		responseMessage ="Try Once more";

	}
		
		return responseMessage;

	
	}
	
}
