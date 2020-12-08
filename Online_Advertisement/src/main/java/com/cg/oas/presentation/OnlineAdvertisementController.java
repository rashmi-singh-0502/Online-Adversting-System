package com.cg.oas.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.service.AdvertiseService;
import com.cg.oas.service.AdvertiseServiceImpl;
import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.service.AdvertiseService;
import com.cg.oas.service.AdvertiseServiceImpl;

public class OnlineAdvertisementController {
	
	private static Logger logger = LogManager.getLogger(OnlineAdvertisementController.class.getName());
	AdvertiseService advertiseService = new AdvertiseServiceImpl();
	
	public Advertise findAdvertiseById(int advertiseId) throws AdvertiseNotFoundException {
		logger.info("Finding advertise for id: " + advertiseId);
		Advertise ad = null;
		try {
			ad = advertiseService.findAdvertiseById(advertiseId);
		}
		catch(Exception e) {
			logger.error("AdvertiseNotFoundException: " + e);
			throw new AdvertiseNotFoundException(e.getMessage());
		}
		return ad;
	}

}
