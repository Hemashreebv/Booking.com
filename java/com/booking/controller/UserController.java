package com.booking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.AddHotel;
import com.booking.model.UserDetails;
import com.booking.service.HotelService;
import com.booking.service.UserService;
import com.booking.util.CommonUtil;

@CrossOrigin
@RequestMapping(value = "/hotel")
@RestController
public class UserController {
	
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@RequestMapping(value = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getHotel(@RequestBody UserDetails userDetails){	
		try {
			logger.info(CommonUtil.ENTERED + new Object() {}.getClass().getEnclosingMethod().getName());
			String responceMessage =  userService.addUser(userDetails);
		    logger.info(CommonUtil.EXITING + new Object() {}.getClass().getEnclosingMethod().getName());
			return new  ResponseEntity<String> ( responceMessage, HttpStatus.OK);
		}catch (Exception exception) {
			logger.info(CommonUtil.EXCEPTION_IN + new Object() {}.getClass().getEnclosingMethod().getName() + exception);
			return new  ResponseEntity <String> (HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}

}
