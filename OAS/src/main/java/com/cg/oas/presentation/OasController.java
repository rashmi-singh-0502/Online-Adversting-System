package com.cg.oas.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dto.Advertise;



import com.cg.oas.exceptions.AdvertiseNotFound;


import com.cg.oas.service.AdvertiseService;
import com.cg.oas.service.AdvertiseServiceImpl;


public class OasController
{
	private static Logger logger = LogManager.getLogger(OasController.class.getName());
	
	AdvertiseService advertiseService = new AdvertiseServiceImpl();

	public Advertise findAdvertiseTitle(String  title) throws AdvertiseNotFound {
		logger.info("Finding advertise for : " + title);
		Advertise ad = null;
		try {
			ad = advertiseService.findAdvertiseTitle(title);
		}
		catch(Exception e) {
			logger.error("AdvertiseNotFoundException: " + e);
			throw new AdvertiseNotFound(e.getMessage());
		}
		return ad;
	}
	
  //Delete Advertise By AdvertisementID
	public Advertise DeleteAdvertiseById(int advertiseId) throws AdvertiseNotFound {
		logger.info("deleting advertise for id: " + advertiseId);
		Advertise ad = null;
		try {
			ad = advertiseService.DeleteById(advertiseId);
		}
		catch(Exception e) {
			logger.error("AdvertiseNotFoundException: " + e);
			throw new AdvertiseNotFound(e.getMessage());
		}
		return ad;
	
}
	
}
