package com.cg.oas.presentation;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.presentation.OnlineAdvertisementController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class OnlineAdvertisementControllerTest {

	private static OnlineAdvertisementController onlineAdvertisementController;
	private static Logger logger;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(OnlineAdvertisementControllerTest.class.getName());
		onlineAdvertisementController = new OnlineAdvertisementController();
	}
	
	@Test
	public void testAdvertiseSearchSuccess() throws AdvertiseNotFoundException {
		logger.info("[START] testAdvertiseSearchSuccess()");
		assertNotNull("Advertise Found", onlineAdvertisementController.findAdvertiseById(1));
		logger.info("[END] testAdvertiseSearchSuccess()");
	}
	
	@Test(expected = AdvertiseNotFoundException.class)
	public void testAdvertiseSearchFailed() throws AdvertiseNotFoundException {
		logger.info("[START] testAdvertiseSearchFailed()");
		onlineAdvertisementController.findAdvertiseById(-2);
		logger.info("[END] testAdvertiseSearchFailed()");
	}
}
