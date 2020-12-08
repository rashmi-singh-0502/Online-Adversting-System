package com.jpa.advertiseapp.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jpa.advertiseapp.dto.User;
import com.jpa.advertiseapp.exceptions.UserNotFoundException;
import com.jpa.advertiseapp.service.UserService;
import com.jpa.advertiseapp.service.UserServiceImpl;
public class UserController 
{
	
	private static Logger logger = LogManager.getLogger(UserController.class.getName());
	UserService userService = new UserServiceImpl();
	
	public User findByName(String name) throws UserNotFoundException {
		logger.info("Finding user with name: " + name);
		 User  user = null;
		try {
			user =userService.findByName(name);
		}
		catch(Exception e) {
			logger.error("UserNotFoundException: " + e);
			throw new UserNotFoundException(e.getMessage());
		}
		return user;
	}
}
