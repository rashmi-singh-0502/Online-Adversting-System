package com.cg.oas.dao;

import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exceptions.NameIsBlankException;


public interface CategoryDAO
{
	public CategoryEntity addCategory(CategoryEntity entity) ;
	CategoryEntity checkName(String categoryName) throws NameIsBlankException;
}
