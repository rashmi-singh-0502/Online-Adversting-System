package com.cg.oas.presentation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.dto.User;
import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.service.AdvertiseService;
import com.cg.oas.service.AdvertiseServiceImpl;
import com.cg.oas.service.CategoryService;
import com.cg.oas.service.CategoryServiceImpl;
import com.cg.oas.service.UserService;
import com.cg.oas.service.UserServiceImpl;


public class OasController
{
	private static Logger logger = LogManager.getLogger(OasController.class.getName());
	AdvertiseService advertiseService = new AdvertiseServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	UserService userService=new UserServiceImpl();
	List<User> list1;

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
	
	public Category addCategory(Category category) 
	{
		logger.info("Adding Category");
		Category c=categoryService.addCategory(category);
	    return c;
	}
	

	
	public Category checkName(String categoryName) throws NameIsBlankException 
	{
		logger.info("Checking category for name: " + categoryName);
		Category category = null;
		try 
		{
			category = categoryService.checkName(categoryName);
		}
		catch(Exception  e) 
		{
			logger.error("NameIsBlankException : " + e);
			throw new NameIsBlankException (e.getMessage());
		}
		return category;
	}


	public List<User> viewAllUsers() throws ListNotDisplayedException {
		logger.info("All List of users");
		try {
			list1=userService.viewAllUsers();
			logger.info("-----------All users are-------" );
			for (User user : list1) {
				logger.info(user);
			}
		}
		catch (Exception e) {
			logger.error("ListNotDisplayedException : "+e);
			throw new ListNotDisplayedException(e.getMessage());
		}
		
		return list1;
	}

	
	public User DeleteById(int userId) throws IdNotFoundException
	{    
	logger.info("Deleting User"+ userId);
		 User user = null;
			try 
			{
				user= userService.DeleteById(userId);
			}
			catch(Exception e) 
			{
				logger.error("IdNotFoundException: " + e);
				throw new IdNotFoundException(e.getMessage());
			}
			return user;
		
	}
}
	
	

