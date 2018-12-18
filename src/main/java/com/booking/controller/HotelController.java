package com.booking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.AddHotel;
import com.booking.model.HotelFound;
import com.booking.model.HotelReview;
import com.booking.model.SearchCriteria;
import com.booking.service.HotelService;
import com.booking.util.CommonUtil;



@CrossOrigin
@RequestMapping(value = "/hotel")
@RestController
public class HotelController {
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService hotelService;

	
	@RequestMapping(value = "find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<HotelFound>> getHotel(@RequestBody SearchCriteria searchCriteria){	
		try {
			logger.info(CommonUtil.ENTERED + new Object() {}.getClass().getEnclosingMethod().getName());
			 List <HotelFound> hotelFounds =  hotelService.getHotel(searchCriteria);
		    logger.info(CommonUtil.EXITING + new Object() {}.getClass().getEnclosingMethod().getName());
			return new  ResponseEntity<List <HotelFound>> ( hotelFounds, HttpStatus.OK);
		}catch (Exception exception) {
			logger.info(CommonUtil.EXCEPTION_IN + new Object() {}.getClass().getEnclosingMethod().getName() + exception);
			return new  ResponseEntity<List <HotelFound>> (HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
	

	@RequestMapping( value = "rating/{hotelid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Integer> getHotelRating(@PathVariable ("hotelid") int hotelid){	
		try {
			logger.info(CommonUtil.ENTERED + new Object() {}.getClass().getEnclosingMethod().getName());
			Integer rating =  hotelService.getHotelRating(hotelid);
		    logger.info(CommonUtil.EXITING + new Object() {}.getClass().getEnclosingMethod().getName());
			return new  ResponseEntity<Integer> ( rating, HttpStatus.OK);
		}catch (Exception exception) {
			logger.info(CommonUtil.EXCEPTION_IN + new Object() {}.getClass().getEnclosingMethod().getName() + exception);
			return new  ResponseEntity<Integer> (HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getHotel(@RequestBody AddHotel addHotel){	
		try {
			logger.info(CommonUtil.ENTERED + new Object() {}.getClass().getEnclosingMethod().getName());
			String responceMessage =  hotelService.addHotel(addHotel);
		    logger.info(CommonUtil.EXITING + new Object() {}.getClass().getEnclosingMethod().getName());
			return new  ResponseEntity<String> ( responceMessage, HttpStatus.OK);
		}catch (Exception exception) {
			logger.info(CommonUtil.EXCEPTION_IN + new Object() {}.getClass().getEnclosingMethod().getName() + exception);
			return new  ResponseEntity <String> (HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
	
	@RequestMapping(value = "add/review", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> addHotelReview(@RequestBody HotelReview hotelReview){	
		try {
			logger.info(CommonUtil.ENTERED + new Object() {}.getClass().getEnclosingMethod().getName());
			String responceMessage =  hotelService.addHotelReview(hotelReview);
		    logger.info(CommonUtil.EXITING + new Object() {}.getClass().getEnclosingMethod().getName());
			return new  ResponseEntity<String> ( responceMessage, HttpStatus.OK);
		}catch (Exception exception) {
			logger.info(CommonUtil.EXCEPTION_IN + new Object() {}.getClass().getEnclosingMethod().getName() + exception);
			return new  ResponseEntity <String> (HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
	
	
	@RequestMapping( value = "delete/{hotelid}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> deleteHotel(@PathVariable ("hotelid") int hotelid){	
		try {
			logger.info(CommonUtil.ENTERED + new Object() {}.getClass().getEnclosingMethod().getName());
			String responseMessage =  hotelService.deleteHotel(hotelid);
		    logger.info(CommonUtil.EXITING + new Object() {}.getClass().getEnclosingMethod().getName());
			return new  ResponseEntity<String> ( responseMessage, HttpStatus.OK);
		}catch (Exception exception) {
			logger.info(CommonUtil.EXCEPTION_IN + new Object() {}.getClass().getEnclosingMethod().getName() + exception);
			return new  ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
	
}
