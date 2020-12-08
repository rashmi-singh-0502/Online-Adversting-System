package com.cg.oas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.service.AdvertiseServiceImpl;

public class AdvertiseDAOImpl implements AdvertiseDAO {

	private static Logger logger = LogManager.getLogger(AdvertiseDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public AdvertiseEntity findAdvertiseById(int advertiseId) throws AdvertiseNotFoundException {
		AdvertiseEntity advertiseEntity = entityManager.find(AdvertiseEntity.class, advertiseId);
		logger.info("Database returned AdvertiseEntity: " + advertiseEntity);
		if(advertiseEntity==null)
			throw new AdvertiseNotFoundException("AdvertiseId: " + advertiseId);
		return advertiseEntity;
	}

}