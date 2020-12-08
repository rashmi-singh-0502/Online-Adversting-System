package com.jpa.advertiseapp.presentation;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;


import com.jpa.advertiseapp.exceptions.UserNotFoundException;
public class UserAddControllerTest 
{
	private static UserController userAddController;
	private static Logger logger;
	
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(AdvertiseAppControllerTest.class.getName());
		userAddController = new UserController();
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testUserAddSuccess() throws UserNotFoundException {
		logger.info("[START] testItemSearchSuccess()");
		assertNotNull("Item Found", userAddController.findByName("abc"));
		logger.info("[END] testItemSearchSuccess()");
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testUserAddFailure() throws UserNotFoundException {
		logger.info("[START] testItemSearchSuccess()");
		assertNotNull("Item Found", userAddController.findByName(""));
		logger.info("[END] testItemSearchSuccess()");
	}
	
	
	
	
	
}
