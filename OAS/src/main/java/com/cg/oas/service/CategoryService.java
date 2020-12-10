package com.cg.oas.service;

import com.cg.oas.dto.Category;
import com.cg.oas.exceptions.NameIsBlankException;



	public interface CategoryService 
	{

		Category addCategory(Category category) ;
		Category checkName(String categoryName) throws NameIsBlankException;
	
		
		
	}

	
	