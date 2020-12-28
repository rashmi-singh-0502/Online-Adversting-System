package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exception.CategoryNotFoundException;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.dto.Category;

public interface CategoryService 
{
  public CategoryEntity createCategory(Category category);
  
  public List<Category> getAllCategory() throws RecordNotFoundException;
  
  public Category getCategoryById(int category_id) throws CategoryNotFoundException;
  
  public List<Category> deleteCategory(String name) throws CategoryNotFoundException;
  
  public List<Category> getCategoryByName(String name) throws CategoryNotFoundException;
  
 }
