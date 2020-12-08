package com.cg.oas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dao.AdvertiseDAO;
import com.cg.oas.dao.AdvertiseDAOImpl;
import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.utils.OasUtils;

public class AdvertiseServiceImpl implements AdvertiseService {

	private static Logger logger = LogManager.getLogger(AdvertiseServiceImpl.class.getName());
	AdvertiseDAO advertiseDao = new AdvertiseDAOImpl();
	
	public Advertise findAdvertiseById(int advertiseId) throws AdvertiseNotFoundException {
		AdvertiseEntity advertiseEntity = advertiseDao.findAdvertiseById(advertiseId);
		logger.info("AdvertiseEntity: " + advertiseEntity);
		return OasUtils.convertAdvertiseEntityIntoAdvertise(advertiseEntity);
	}
}
