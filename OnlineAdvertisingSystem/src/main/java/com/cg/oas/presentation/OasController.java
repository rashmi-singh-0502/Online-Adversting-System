package com.cg.oas.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dto.Ad;



import com.cg.oas.exceptions.AdNotFoundException;


import com.cg.oas.service.AdService;
import com.cg.oas.service.AdServiceImpl;


public class OasController
{
	private static Logger logger = LogManager.getLogger(OasController.class.getName());
	
	AdService advertiseService = new AdServiceImpl();

	/*
	 * public User viewUser() throws ListNotDisplayedException {
	 * logger.info("Adding Description for Category: "); User user = null; try {
	 * user= userService.viewUser(); } catch(Exception e) {
	 * logger.error("DescriptionIsBlankException: " + e); throw new
	 * ListNotDisplayedException(e.getMessage()); } }
	 */
	

	public Ad findAdvertiseById(int advertiseId) throws AdNotFoundException {
		logger.info("Finding advertise for id: " + advertiseId);
		Ad ad = null;
		try {
			ad = advertiseService.findAdvertiseById(advertiseId);
		}
		catch(Exception e) {
			logger.error("AdvertiseNotFoundException: " + e);
			throw new AdNotFoundException(e.getMessage());
		}
		return ad;
	}
	
}
