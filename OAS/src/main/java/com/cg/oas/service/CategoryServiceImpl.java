package com.cg.oas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cg.oas.dao.CategoryDAO;
import com.cg.oas.dao.CategoryDAOImpl;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exceptions.NameIsBlankException;
import com.cg.oas.service.CategoryServiceImpl;
import com.cg.oas.utils.OasUtils;

public class CategoryServiceImpl implements CategoryService
{   
	private static Logger logger = LogManager.getLogger(CategoryServiceImpl.class.getName());
	CategoryDAO categoryDao = new CategoryDAOImpl();
	
	public Category addCategory(Category category) 
	{
		CategoryEntity categoryEntity = categoryDao.addCategory(OasUtils.convertCategoryIntoCategoryEntity(category));
		logger.info("CategoryEntity: " + categoryEntity);
		return OasUtils.convertCategoryEntityIntoCategory(categoryEntity);
	}
	
	//calling DAO service for name
	public Category checkName(String categoryName) throws NameIsBlankException
	{
		CategoryEntity categoryEntity = categoryDao.checkName(categoryName);
		logger.info("ItemEntity: " + categoryEntity);
		return OasUtils.convertCategoryEntityIntoCategory(categoryEntity);
	}
	


	
}	
	
	
	
	

