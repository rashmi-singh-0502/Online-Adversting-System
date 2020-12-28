package com.cg.oas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.dto.Category;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exception.CategoryNotFoundException;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.repo.CategoryRepo;

/*
 * -------------------------------DECLARING CLASS AS SERVICE---------------------
 */
@Service
public class CategoryServiceImpl implements CategoryService
{
	
	/*
	 * -----------------------------AUTOWIRING REPO CLASS-------------------------
	 */
	@Autowired
	private CategoryRepo categoryRepo;
	//private static Logger logger = LogManager.getLogger(CategoryServiceImpl.class.getName());
	
	/*
	 * -------------------------CREATING A NEW CATEGORY-----------------------
	 */
	@Override
	public CategoryEntity createCategory(Category category) 
	{
		CategoryEntity categoryEntity = 
				categoryRepo.save(new CategoryEntity(category.getName(), category.getCategory_desc()));
		//logger.info("CategoryEntity:" + categoryEntity);
		
		return new CategoryEntity(categoryEntity.getCategory_id(), categoryEntity.getName(), categoryEntity.getCategory_desc());
	}
	
	/*
	 * -------------------------GETTING CATEGORY BY ID------------------------
	 */
	@Override
	public Category getCategoryById(int category_id) throws CategoryNotFoundException
    {
		Optional<CategoryEntity> opCategoryEntity = Optional.ofNullable(categoryRepo.findById(category_id));
		if(opCategoryEntity.isPresent()) 
		{
			CategoryEntity categoryEntity = opCategoryEntity.get();
			return new Category(categoryEntity.getCategory_id(), categoryEntity.getName(), categoryEntity.getCategory_desc());
		}
		else 
		{
			throw new CategoryNotFoundException("categoryid" + category_id);
		}
		
	}
	/*
	 * -----------------------DELETING CATEGORY BY NAME-------------------------
	 */
	@Override
	public List<Category> deleteCategory(String name) throws CategoryNotFoundException
	{
		List<CategoryEntity> categoryEntityList= categoryRepo.findByName(name);
		if(!categoryEntityList.isEmpty())
		{
			List<Category> categorys = new ArrayList<Category>();
		    for(CategoryEntity categoryEntity: categoryEntityList)
		    {
			   categorys.add(new Category(categoryEntity.getCategory_id(), categoryEntity.getName(), categoryEntity.getCategory_desc()));
			   categoryRepo.delete(categoryEntity);
		     }
		    return categorys;
		}
		else
		{
			throw new CategoryNotFoundException("Category_Name:" + name);	
		}
		
	}
	/*
	 * ---------------------DISPLAYING ALL CATEGORY-------------------------------
	 */
	@Override
	public List<Category> getAllCategory() throws RecordNotFoundException
	{
		List<CategoryEntity> categoryEntityList = categoryRepo.findAll();
		if(!categoryEntityList.isEmpty())
		  {
		    List<Category> categorys = new ArrayList<Category>();
		    for(CategoryEntity categoryEntity: categoryEntityList) 
		    {
			   categorys.add(new Category(categoryEntity.getCategory_id(), categoryEntity.getName(), categoryEntity.getCategory_desc()));
		     }
	
		   return categorys;
	      }
	    else
	     {
		   throw new RecordNotFoundException("NO RECORD FOUND");
	     }
	}
	/*
	 * ----------------------GETTING CATEGORY BY NAME------------------------
	 */
	public List<Category> getCategoryByName(String category_name) throws CategoryNotFoundException
	{
		List<CategoryEntity> categoryEntityList = categoryRepo.findByName(category_name);
		if(!categoryEntityList.isEmpty())
		 {
		  List<Category> categorys = new ArrayList<Category>();
		  for(CategoryEntity categoryEntity: categoryEntityList) 
		  {
			categorys.add(new Category(categoryEntity.getCategory_id(), categoryEntity.getName(), categoryEntity.getCategory_desc()));
		  }
		return categorys;
	    }
	   else
	   {
		throw new CategoryNotFoundException("Category_Name:" + category_name);
	   }
	}
}
