package com.cg.oas.presentation;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;

//import com.cg.oas.exceptions.IdNotFoundException;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertFalse;
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
	
	//Delete Advertise By AdvertisementID
	@Test
	public void testAdvertiseDeleteSuccess() throws AdvertiseNotFound {
		logger.info("[START] testAdvertiseDeleteSuccess()");
		assertNotNull("Advertise Found", oasController.DeleteAdvertiseById(5));
		logger.info("[END] testAdvertiseDeleteSuccess()");
	}
	
	@Test(expected = AdvertiseNotFound.class)
	public void testAdvertiseDeleteFailed() throws AdvertiseNotFound {
		logger.info("[START] testAdvertiseDeleteFailed()");
		oasController.DeleteAdvertiseById(-2);
		logger.info("[END] testAdvertiseDeleteFailed()");
	}
	
	//testing read advertise by id
		 //this will return the advertise of particular advertise id
		@Test
		public void testAdvertiseReadSuccess() throws AdvertiseNotFoundException {
			logger.info("[START] testAdvertiseReadSuccess()");
			assertNotNull("Advertise Found", oasController.readAdvertiseById(1));
			logger.info("[END] testAdvertiseReadSuccess()");
		}
		
		//this will throw exception if advertise id is not present
		@Test(expected = AdvertiseNotFoundException.class)
		public void testAdvertiseReadFailed() throws AdvertiseNotFoundException {
			logger.info("[START] testAdvertiseReadFailed()");
			oasController.readAdvertiseById(-2);
			logger.info("[END] testAdvertiseReadFailed()");
		}
		
		//testing view all advertises
		//this will return the list of advertises, and throw exception if list is empty
		@Test 
		public void testViewAdvertisesSuccess() throws AdvertiseNotFoundException {
			logger.info("[START] testViewAdvertisesSuccess()");
			logger.info("Database fetched successfully");
			assertFalse(oasController.viewAllAdvertises().isEmpty());
			logger.info("[END] testViewAdvertisesSuccess()");
		}
		
		//testing edit advertise
		//this will edit and return the edited advertise
		@Test
		public void testAdvertiseEditSuccess() throws AdvertiseNotFoundException {
			logger.info("[START] testAdvertiseEditSuccess()");
			assertNotNull("Advertise Found", oasController.editAdvertise(1));
			logger.info("[END] testAdvertiseEditSuccess()");
		}
		
		//this will throw exception if id is not present
		@Test(expected = AdvertiseNotFoundException.class)
		public void testAdvertiseEditFailed() throws AdvertiseNotFoundException {
			logger.info("[START] testAdvertiseEditFailed()");
			oasController.editAdvertise(-4);
			logger.info("[END] testAdvertiseEditFailed()");
		}
}

