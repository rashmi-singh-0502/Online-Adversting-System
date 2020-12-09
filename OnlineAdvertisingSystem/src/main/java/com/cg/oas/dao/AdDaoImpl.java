package com.cg.oas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.AdEntity;
import com.cg.oas.exceptions.AdNotFoundException;

public class AdDaoImpl implements AdDao {

	private static Logger logger = LogManager.getLogger(AdDaoImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public AdEntity findAdvertiseById(int advertiseId) throws AdNotFoundException {
		AdEntity advertiseEntity = entityManager.find(AdEntity.class, advertiseId);
		logger.info("Seacrh Result : "    + advertiseEntity +   "Search Successful!!");
		if(advertiseEntity==null)
			throw new AdNotFoundException("  Wrong AdvertiseId: " + advertiseId);
		return advertiseEntity;
	}

}