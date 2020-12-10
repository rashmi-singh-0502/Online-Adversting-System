package com.cg.oas.presentation;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.InvalidDataFormatException;
import com.cg.oas.exceptions.InvalidUserFormatException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.UserAddNotFoundException;
import com.cg.oas.exceptions.UserIdNotFoundException;

//import com.cg.oas.exceptions.IdNotFoundException;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;
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
	/*
	 * Runs at the beginning only once
	 */
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
		//Mahima's code
		@Test
		public void addCategorySuccess() 
		{
			logger.info("[START] addCategorySuccess()");
			Category cate=new Category("Clothes","Fashionable Item");
			Category cate1=oasController.addCategory(cate);
			String s=cate1.getCategory_name();
			assertEquals(cate.getCategory_name(),s);
			logger.info("[END] addCandidateSuccess()");
		
		}

		
		//Test to check categoryName is not blank 

		@Test
		public void testCategoryName() throws NameIsBlankException
		{
			
			logger.info("[START] testCategoryName()");
			Category cate=new Category("Hardware","Hardware items");
			String name= oasController.addCategory(cate).getCategory_name();
			assertNotNull("Category_Name is not null", oasController.checkName(name));
			logger.info("[END] testCategoryName");
		}
		

		//Test to give exception while deleting user who do not exists
		
		@Test(expected = IdNotFoundException.class)
		public void testDeleteByIdFailed() throws IdNotFoundException 
		{
			logger.info("[START]  testDeleteByIdFailed()");
			oasController.DeleteById(104);
			logger.info("[END]  testDeleteByIdFailed()");
		}
		
		//Test to delete user from database successfully
		@Test
		public void testDeleteByIdSuccess() throws IdNotFoundException
		{
			logger.info("[START] testDeleteUser()");
			assertNotNull("UserEntity", oasController.DeleteById(102));
			logger.info("[END] testDeleteByIdSuccess()");
		}
		
		//Test to view UserList successfully!
		@Test
		public void testViewUsersSuccess() throws ListNotDisplayedException
		{
			logger.info("[START] testViewUsersSuccess()");
			logger.info("Database fetched successfully");
			assertFalse(oasController.viewAllUsers().isEmpty());
			logger.info("[END] testViewUsersSuccess()");
		}
		//Mahima's code ended
		
		
		
	// view user details by id	
		@Test
		public void testUserSearchSuccess() throws UserIdNotFoundException {
			logger.info("[START] testUserSearchSuccess()");
			assertNotNull("User Found", oasController.findById(1));
			logger.info("[END] testUserSearchSuccess()");
		}
		
		@Test(expected = UserIdNotFoundException.class)
		public void testUserSearchFailed() throws UserIdNotFoundException {
			logger.info("[START] testUserSearchFailed()");
			oasController.findById(2);
			logger.info("[END] testUserSearchFailed()");
		}
		
		//Test to Post new Advertise
		@Test(expected = InvalidDataFormatException.class)//all data is in valid format
		public void testValidPostAdvertiseSuccess() throws InvalidDataFormatException {
			logger.info("[START] testValidPostAdvertiseSuccess()");
			assertNotNull("New Advertise Posted Successfully", oasController.addData(new AdvertiseEntity(5,"abc","vehicle","desc",120,"open")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}
		
		//Test to Post new Advertise
		@Test(expected = InvalidDataFormatException.class)//category is null
		public void testValidPostAdvertiseFailure() throws InvalidDataFormatException {
			logger.info("[START] testValidPostAdvertiseSuccess()");
			assertNotNull("New Advertise Post Failed", oasController.addData(new AdvertiseEntity(3,"abc","","desc",120,"open")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}
		//Test to Post new Advertise
		@Test(expected = InvalidDataFormatException.class)//email id is in invalid format
		public void testValidPostAdvertiseFailure1() throws InvalidDataFormatException {
			logger.info("[START] testValidPostAdvertiseSuccess()");
			assertNotNull("New Advertise Post Failed", oasController.addData(new AdvertiseEntity(3,"abc","vehicle","desc",120,"@#$")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}	
		
		//Test to register new user
		@Test(expected = InvalidUserFormatException.class)//all info is in valid format
		public void testValidRegisterUserSuccess() throws InvalidUserFormatException {
			logger.info("[START] testValidPostAdvertiseSuccess()");
			assertNotNull("New User Registered Successfully", oasController.addData(new UserEntity(1,"abc","pune",12345,"abc@gmail.com")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}
		
		//Test to register new user
		@Test(expected = InvalidUserFormatException.class)//all info is in valid format
		public void testValidRegisterUserSuccess1() throws InvalidUserFormatException {
			logger.info("[START] testValidPostAdvertiseSuccess()");
			assertNotNull("New User Registered Successfully", oasController.addData(new UserEntity(2,"abc","pune",0123456,"abc@gmail.com")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}
		
		//Test to register new user
		@Test(expected = InvalidUserFormatException.class)//user name is in invalid format
		public void testValidRegisterUserFailure() throws InvalidUserFormatException {
			logger.info("[START] testValidegisterUserFailure()");
			assertNotNull("New User Registration Failed", oasController.addData(new UserEntity(2,"abc123","pune",0,"abc@gmail.com")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}
		@Test(expected = InvalidUserFormatException.class)//address is blank
		public void testValidRegisterUserFailure1() throws InvalidUserFormatException {
			logger.info("[START] testValidRegisterUserFailure()");
			assertNotNull("New  Successfully", oasController.addData(new UserEntity(2,"abc","",124589,"abc@gmail.com")));
			logger.info("[END] testValidPostAdvertiseSuccess()");
		}
		
}

