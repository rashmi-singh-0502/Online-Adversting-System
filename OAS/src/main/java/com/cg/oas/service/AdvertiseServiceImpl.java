package com.cg.oas.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dao.AdvertiseDAO;
import com.cg.oas.dao.AdvertiseDAOImpl;
import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.exceptions.InvalidDataFormatException;
import com.cg.oas.utils.OasUtils;

public class AdvertiseServiceImpl implements AdvertiseService {

	private static Logger logger = LogManager.getLogger(AdvertiseServiceImpl.class.getName());
	AdvertiseDAO advertiseDao = new AdvertiseDAOImpl();
	List<Advertise> advertises;
	
	public Advertise findAdvertiseTitle(String  advertisename) throws AdvertiseNotFound {
		AdvertiseEntity addentity = advertiseDao.findAdvertiseTitle(advertisename);
		logger.info("AdvertiseEntity: " + addentity);
		return OasUtils.convertAdvertiseEntityIntoAdvertise(addentity);
	}

	public Advertise findAdvertiseById(String advertisename) throws AdvertiseNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Delete Advertise By AdvertisementID
	public Advertise DeleteById(int advertiseId) throws AdvertiseNotFound {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
					AdvertiseEntity advertiseEntity = advertiseDao.DeleteById(advertiseId);
					logger.info("AdvertiseEntity: " + advertiseEntity);
					return OasUtils.convertAdvertiseEntityIntoAdvertise(advertiseEntity);
		}
	
	//function for reading advertise by id
		public Advertise readAdvertiseById(int advertiseId) throws AdvertiseNotFoundException {
			AdvertiseEntity advertiseEntity = advertiseDao.readAdvertiseById(advertiseId);
			logger.info("AdvertiseEntity: " + advertiseEntity);
			return OasUtils.convertAdvertiseEntityIntoAdvertise(advertiseEntity);
		}
		
		//function for editing advertise by id
		public Advertise editAdvertise(int advertiseId) throws AdvertiseNotFoundException {
			AdvertiseEntity advertiseEntity = advertiseDao.editAdvertise(advertiseId);
			logger.info("AdvertiseEntity: " + advertiseEntity);
			return OasUtils.convertAdvertiseEntityIntoAdvertise(advertiseEntity);
		}
		
		//function for reading all advertises
		public List<Advertise> viewAllAdvertises() throws AdvertiseNotFoundException {
			List<AdvertiseEntity> entities=advertiseDao.viewAllAdvertises();
			logger.info("All Advertises are:");
			advertises=OasUtils.convertAdvertiseEntityListToAdvertise(entities);
			return advertises;
		}
		public Advertise addData(AdvertiseEntity adEntity) throws InvalidDataFormatException
		{
				
				AdvertiseEntity adEntity1=advertiseDao.postNewAdvertise(adEntity);
				return OasUtils.convertAdvertiseEntityIntoAdvertise(adEntity1);
			
		}
		


	}

