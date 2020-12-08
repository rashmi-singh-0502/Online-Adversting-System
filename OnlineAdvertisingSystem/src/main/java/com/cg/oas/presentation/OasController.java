package com.cg.oas.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cg.oas.dto.Category;
import com.cg.oas.dto.User;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.exceptions.DescriptionIsBlankException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.service.CategoryService;
import com.cg.oas.service.CategoryServiceImpl;


public class OasController
{
	private static Logger logger = LogManager.getLogger(OasController.class.getName());
	CategoryService categoryService = new CategoryServiceImpl();

	/*
	 * public User viewUser() throws ListNotDisplayedException {
	 * logger.info("Adding Description for Category: "); User user = null; try {
	 * user= userService.viewUser(); } catch(Exception e) {
	 * logger.error("DescriptionIsBlankException: " + e); throw new
	 * ListNotDisplayedException(e.getMessage()); } }
	 */
	
	
	
	Category AddName(String categoryName) throws NameIsBlankException 
	{
		logger.info("Adding Name for category: " + categoryName);
	     Category category = null;
		try 
		{
			category= categoryService.AddName(categoryName);
		}
		catch(Exception e) 
		{
			logger.error("NameIsBlankException: " + e);
			throw new NameIsBlankException(e.getMessage());
		}
		return category;
	}
	public Category AddDescription(String categoryDesc) throws DescriptionIsBlankException 
	{
		logger.info("Adding Description for Category: " + categoryDesc);
	     Category category = null;
		try 
		{
			
			category= categoryService.AddDescription(categoryDesc);
		}
		catch(Exception e) 
		{
			logger.error("DescriptionIsBlankException: " + e);
			throw new DescriptionIsBlankException(e.getMessage());
		}
		return category;
	}
	
	
	
}
