package com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.booking.controller.HotelController;
import com.booking.dao.HotelDAO;
import com.booking.model.AddHotel;
import com.booking.model.HotelFound;
import com.booking.model.HotelReview;
import com.booking.model.SearchCriteria;


@Repository
public class HotelDAOImpl implements HotelDAO {
	
	public static final String GET_HOTELLIST_DETAILS = "SELECT HOTEL_NAME,RATING,COST_PER_DAY FROM HOTEL_DETAILS WHERE CITY =? AND FILLED_TILL =? AND TRAVELLERS_NO =? AND RATING=  AND WIFI=? AND RESTAURANT_AVAILABEL AND AIR_CONDITION =? AND MEAL =?";
	public static final String GET_HOTEL_RATING ="SELECT RATING  FROM HOTEL_DETAILS WHERE HOTEL_ID =?";
	public static final String  INSERT_HOTEL_DETAILS ="insert into  HOTEL_DETAILS (name,defaultRating,city,costPerDay,wifi,restaurantAvailable,airConditioning,mealsIncluded,address,pincode,phone,mailId,createdDate,CreatedBy) \\r\\n\"\r\n" + 
			"			+ \"values (? ,? ,? ,? ,? ,? ,?,?,?,?,?,?,? )\"";
	public static final String DELETE_HOTEL ="delete from HOTEL WHERE HOTEL_ID = ?";
	
	
	public static final String INSERT_HOTEL_REVIEW = "insert into  HOTEL_REVIEW(hotelId,comments,rating) values (?,?,?)"; 
	private static final Logger logger = LoggerFactory.getLogger(HotelDAOImpl.class);

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<HotelFound> getHotel(SearchCriteria searchCriteria) {
		logger.info("inside getHotel");
		List<HotelFound> hotelFound = new ArrayList<HotelFound>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_HOTELLIST_DETAILS)) {
			pstmt.setString(1, searchCriteria.getCity());
			pstmt.setDate(2, searchCriteria.getDate());
			pstmt.setString(3, searchCriteria.getNoOfTravellers());
			searchCriteria.getHotel().stream().forEach((hotel)->{
				try {
					pstmt.setInt(4, hotel.getStars());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hotel.getFacilitie().stream().forEach((facility)->{
					try {
						pstmt.setBoolean(5, facility.getWifi());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						pstmt.setBoolean(6, facility.getRestaurantAvailable());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						pstmt.setBoolean(7, facility.getAirConditioning());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						pstmt.setBoolean(7, facility.getMealsIncluded());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				});
				
			});
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				hotelFound.add(new HotelFound(rs.getString("HOTEL_NAME"), rs.getInt("RATING"), rs.getInt("COST_PER_DAY")));
			}
		} catch (SQLException e) {
			logger.error("exception while executing query "+e);
			throw new InternalError("Exception while getting connection or executing query", e);
		}
		logger.info("exiting getActionDetails method");
	    return hotelFound;
	
		
		
	}

	@Override
	public Integer getHotelRating(int hotelid) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_HOTEL_RATING)) {
			pstmt.setInt(1, hotelid);
			ResultSet rs = pstmt.executeQuery();
			hotelid = rs.getInt("RATING");
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return hotelid;

}

	@Override
	public String addHotel(AddHotel addHotel) {
      String responceMessage = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_HOTEL_DETAILS)) {
			pstmt.setString(1, addHotel.getName());
			pstmt.setInt(2, addHotel.getDefaultRating());
			pstmt.setString(3, addHotel.getCity());
			pstmt.setInt(4, addHotel.getCostPerDay());
			addHotel.getFacilitie().stream().forEach((facility)->{
				try {
					pstmt.setBoolean(5, facility.getWifi());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					pstmt.setBoolean(6, facility.getRestaurantAvailable());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					pstmt.setBoolean(7, facility.getAirConditioning());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					pstmt.setBoolean(8, facility.getMealsIncluded());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			pstmt.setString(9, addHotel.getAddress());
			pstmt.setInt(10, addHotel.getPincode());

			pstmt.setString(11, addHotel.getPhone());
			pstmt.setString(12, addHotel.getMailId());
			//created by hardcode as if now
			pstmt.setString(13, "Test User");

			pstmt.setTimestamp(13, new Timestamp(System.currentTimeMillis()));

//			pstmt.setString(5, addHotel.getFacilitie().stream().forEach(hotel)->{
//				
//			}););



			ResultSet rs = pstmt.executeQuery();
			responceMessage ="Sucessfully Created";

	} catch (SQLException e) {
		e.printStackTrace();
		responceMessage ="Opp try once more";
	}
		return responceMessage;


	}

	@Override
	public String addHotelReview(HotelReview hotelReview) {
		String responseMessage = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT_HOTEL_REVIEW)) {
			pstmt.setString(1, hotelReview.getComments());
			pstmt.setInt(2, hotelReview.getRating());
			pstmt.executeQuery();
			responseMessage ="Sucessfully Saved";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		responseMessage ="Try Once more";

	}
		
		return responseMessage;
}

	@Override
	public String deleteHotel(int deleteHotel) {

		String responseMessage = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DELETE_HOTEL)) {
			pstmt.setInt(1, deleteHotel);
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
