package com.cg.oas.presentation;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public class AdAppControllerTest {

	private static Logger logger; 
	private static AdController adController;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		logger=LogManager.getLogger(AdAppControllerTest.class.getName());
		adController=new AdController();
		
	}

	@Test(expected = InvalidDataFormatException.class)
	public void testValidPostAdvertiseSuccess() throws InvalidDataFormatException {
		logger.info("[START] testValidPostAdvertiseSuccess()");
		assertNotNull("New Advertise Posted Successfully", adController.addData(new AdvertiseEntity(3,"abc","vehicle","desc",120,"open")));
		logger.info("[END] testValidPostAdvertiseSuccess()");
	}
	

}

