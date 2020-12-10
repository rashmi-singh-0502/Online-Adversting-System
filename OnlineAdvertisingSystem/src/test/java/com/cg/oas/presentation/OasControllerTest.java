package com.cg.oas.presentation;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFound;

//import com.cg.oas.exceptions.IdNotFoundException;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;


public class OasControllerTest 
{
	private static OasController oasController;
	private static Logger logger;
	@BeforeClass
	public static void setUp() 
	{
		logger = LogManager.getLogger(OasControllerTest.class.getName());
		oasController = new OasController();
	}
	
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	@Test(expected = AdvertiseNotFound.class)
	public void testAdvertiseSearchSuccess() throws AdvertiseNotFound {
		logger.info("[START] testAdvertiseSearchSuccess()");
		assertNotNull("Advertise Found", oasController.findAdvertiseTitle("mixer"));
		EntityManager entityMananger = null;
		Query query = entityMananger.createQuery("Select * from Advertise ");
		List<Advertise> advertise = query.getResultList();
		for(Advertise a: advertise) {
			System.out.println(a);
		}
		
		logger.info("[END] testAdvertiseSearchSuccess()");
	}
	
	@Test(expected = AdvertiseNotFound.class)
	public void testAdvertiseSearchFailed() throws AdvertiseNotFound {
		logger.info("[START] testAdvertiseSearchFailed()");
		oasController.findAdvertiseTitle("");
		logger.info("[END] testAdvertiseSearchFailed()");
	}
}
