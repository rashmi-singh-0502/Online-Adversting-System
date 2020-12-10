package com.cg.oas.dao;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFound;



public class AdvertiseDAOImpl implements AdvertiseDAO {

	private static Logger logger = LogManager.getLogger(AdvertiseDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public AdvertiseEntity findAdvertiseTitle(String  title) throws AdvertiseNotFound {
	
		//Query query = (Query) entityManager.createQuery("select title from advertise where ad_id=?");
		Query query = (Query) entityManager.createNamedQuery("select title from advertise where ad_id=1");
		Object addentity = ((javax.persistence.Query) query).getSingleResult();
		//for(AdTitleDao ad: addlist) {
			//System.out.println("ad");
			
		//}
		return (AdvertiseEntity) addentity;
		
		//AdvertiseEntity advertiseEntity = ((Object) entityManager).query(AdvertiseEntity.class,"select title from advertise where ad_id=?");
		//logger.info("Seacrh Result : "    + advertiseEntity +   "Search Successful!!");
		//if(advertiseEntity==null)
			//throw new AdTitleNotFoundException("  Wrong AdvertiseId: " +  title);
		//return advertiseEntity;
	}

}