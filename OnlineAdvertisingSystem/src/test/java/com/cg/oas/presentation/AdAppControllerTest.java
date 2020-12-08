package com.cg.oas.presentation;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.oas.entity.AdEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public class AdAppControllerTest {

	private static Logger logger; 
	private static AdController adController;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		logger=LogManager.getLogger(AdAppControllerTest.class.getName());
		adController=new AdController();
		
	}

	@Test
	public void testValidPostAdvertiseSuccess() throws InvalidDataFormatException {
		logger.info("[START] testValidPostAdvertiseSuccess()");
		assertNotNull("New Advertise Posted Successfully", adController.addData(new AdEntity(1,"abc","vehicle",120,"desc")));
		logger.info("[END] testValidPostAdvertiseSuccess()");
	}
	

}

