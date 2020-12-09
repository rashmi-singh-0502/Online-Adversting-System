package com.cg.oas.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;
import com.cg.oas.presentation.AdController;
import com.cg.oas.service.AdService;
import com.cg.oas.service.AdServiceImpl;

public class AdController {


	private static Logger logger=LogManager.getLogger(AdController.class.getName());
	AdService adService=new AdServiceImpl();
	public Advertise addData(AdvertiseEntity adEntity) throws InvalidDataFormatException  {
		logger.info("Posting new advertisement");
		Advertise ad;
		try {
			ad = adService.addData(adEntity);
		}
		catch(Exception e) {
			logger.error("InvalidDataFormatException : " + e);
			throw new InvalidDataFormatException(e.getMessage());
		}
		return ad;
	}
	

}
