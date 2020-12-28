
package com.cg.oas.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.oas.CgSpringOasApplication;
import com.cg.oas.exception.CategoryNotFoundException;
import com.cg.oas.service.CategoryService;
import com.cg.oas.service.CategoryServiceImpl;
import com.cg.oas.testdto.Category;

@SpringBootTest(classes = CgSpringOasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest
{
	 public Category category;
	 @Autowired
	 public CategoryService categoryService;
	 private static Logger logger= LogManager.getLogger(CategoryServiceImpl.class.getName());
	 
	 
	 
	/**
	 * ----------------------TESTING TO ADD CATGEORY TO THE DATABASE.--------------------
	 * 
	 */
     @Test
	void testAddCategory()
	{
    	 logger.info("[START] testAddCategory()");
        RestTemplate restTemplate = new RestTemplate();
		Category category = new Category(110,"party items","all party acessories");
		Category cat=restTemplate.postForObject("http://localhost:8080/cgoas/category",category,Category.class);
		assertNotNull(cat);
		logger.info("Category Created");
		logger.info("[END] testAddCategory()");
	}
     
	/**
	 * ----------------------TESTING WHETHER WE ARE GETTING THE LIST OF ALL CATEGORY----------------------	
	 */
	@Test
	public void testGetAllCategory()
	{
		 logger.info("[START] testGetAllCategory()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/category/get",Category[].class);
		assertNotNull(responseEntity);
		logger.info("All Category Dispalyed");
		logger.info("[END] testGetAllCategory()");
			
	}
	
	/**
	 * -----------------------------TESTING TO GET CATEGORY BY ID-----------------------
	 */
	@Test
	public void testFindCategoryById() 
	{
		 logger.info("[START] testFindCategoryById()");
		RestTemplate restTemplate = new RestTemplate();
		Category category=restTemplate.getForObject("http://localhost:8080/cgoas/category/search/253", Category.class);
		assertNotNull(category);
		logger.info("Category By Id Displayed");
		logger.info("[END] testFindCategoryById()");
	}
	
	/**
	 * -----------------------------TESTING TO GET CATEGORY BY WRONG ID-FAIL----------------------
	 */
	@Test
	public void testgetCatgeoryByBlankId()
	{
		logger.info("[START] testgetCategoryByBlankId()");
		assertThrows(CategoryNotFoundException.class,()->
			{
				categoryService.getCategoryById(25);
			});
		  logger.error(" testgetCategoryByBlankId(): Failed as Category Id is Invalid");
		  logger.info("[END] testFindCategoryByBlankId()");
		
	}
	
	
	/**
	 * -------------------------TESTING TO GET A CATGEORY BY NAME------------------------------
	 */
	@Test
	void testgetCategoryByName()
	{
		 logger.info("[START] testgetCategoryByName()");
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/category/Electronic",Category[].class);
		assertNotNull(responseEntity);	
		logger.info("Category By Name Displayed");
		logger.info("[END] testgetCategoryByName()");
	}
	
	/**
	 * ----------------------TEST CASE TO GET A CATEGORY BY BLANK NAME - FAIL----------------------
	 */
	@Test
	public void testgetCatgeoryByBlankName()
	{
		 logger.info("[START] testgetCategoryByBlankName()");
		assertThrows(CategoryNotFoundException.class,()->
			{
				categoryService.getCategoryByName("furn");
			});
		  logger.error(" testgetCategoryByBlankName(): Failed as Category Name is Invalid");	
		  logger.info("[END] testgetCategoryByBlankName()");
	}
	
	/**
	 * ---------------------------TEST TO DELETE A CATGEORY BY NAME----------------------------
	 */
	@Test
	void testDeleteCategoryByName() throws CategoryNotFoundException
	{
		 logger.info("[START] testDeleteCategoryByName()");
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/cgoas/category/{name}/delete","plastic");
        logger.info("Category By Name Is Deleted");
        logger.info("[END] testDeleteCategoryByName()");
		
	}

	/**
	 * ---------------------------TEST TO DELETE A CATGEORY BY BLANK NAME-FAIL----------------------------
	 */
	@Test()
	void testdeleteCategoryByNameFail()
	{
		logger.info("[START] testDeleteCategoryByNameFail()");
		assertThrows(CategoryNotFoundException.class,
				()->{
					categoryService.deleteCategory("furniture");
				    }  
				    );
		  logger.error(" testDeleteCategoryByNameFail(): Failed as Category Name is Invalid");
		  logger.info("[END] testDeleteCategoryByNameFail()");
	}

}
