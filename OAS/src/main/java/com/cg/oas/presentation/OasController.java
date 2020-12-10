package com.cg.oas.presentation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dto.Advertise;



import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
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
	
	public Advertise readAdvertiseById(int advertiseId) throws AdvertiseNotFoundException {
		logger.info("Finding advertise for id: " + advertiseId);
		Advertise ad;
		try {
			ad = advertiseService.readAdvertiseById(advertiseId);
		}
		catch(Exception e) {
			logger.error("AdvertiseNotFoundException: " + e);
			throw new AdvertiseNotFoundException(e.getMessage());
		}
		return ad;
	}
	
	public Advertise editAdvertise(int advertiseId) throws AdvertiseNotFoundException {
		logger.info("Finding advertise for id: " + advertiseId);
		Advertise ad2;
		try {
			ad2 = advertiseService.editAdvertise(advertiseId);
		}
		catch(Exception e) {
			logger.error("Advertise id does not exist or is invalid");
			throw new AdvertiseNotFoundException();
		}
		return ad2;
	}
	
	public List<Advertise> viewAllAdvertises() throws AdvertiseNotFoundException {
		logger.info("All advertises");
		List<Advertise> list1;
		try {
			list1=advertiseService.viewAllAdvertises();
			logger.info("List of advertises:");
			for (Advertise advertise : list1) {
				logger.info(advertise);
			}
		}
		catch (Exception e) {
			logger.error("AdvertiseNotFoundException : "+e);
			throw new AdvertiseNotFoundException(e.getMessage());
		}
		return list1;
	}
	
	
}
