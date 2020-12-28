
package com.cg.oas.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.oas.CgSpringOasApplication;
import com.cg.oas.exception.CategoryNotFoundException;
import com.cg.oas.service.CategoryService;
import com.cg.oas.testdto.Category;

@SpringBootTest(classes = CgSpringOasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest
{
	 public Category category;
	 @Autowired
	 public CategoryService categoryService;
	 
	/**
	 * ----------------------TESTING TO ADD CATGEORY TO THE DATABASE.--------------------
	 * 
	 */
     @Test
	void testAddCategory()
	{
        RestTemplate restTemplate = new RestTemplate();
		Category category = new Category(110,"furniture","all wooden items");
		Category cat=restTemplate.postForObject("http://localhost:8080/cgoas/category",category,Category.class);
		assertNotNull(cat);
	}
     
     
	/**
	 * ----------------------TESTING WHETHER WE ARE GETTING THE LIST OF ALL CATEGORY----------------------	
	 */
	@Test
	public void testGetAllCategory()
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/category/get",Category[].class);
		assertNotNull(responseEntity);
			
	}
	
	/**
	 * -----------------------------TESTING TO GET CATEGORY BY ID-----------------------
	 */
	@Test
	public void testFindCategoryById() 
	{
		RestTemplate restTemplate = new RestTemplate();
		Category category=restTemplate.getForObject("http://localhost:8080/cgoas/category/search/254", Category.class);
		assertNotNull(category);
	}
	
	/**
	 * -----------------------------TESTING TO GET CATEGORY BY WRONG ID-FAIL----------------------
	 */
	@Test
	public void testgetCatgeoryByBlankId()
	{

		assertThrows(CategoryNotFoundException.class,()->
			{
				categoryService.getCategoryById(25);
			});
		
	}
	
	
	/**
	 * -------------------------TESTING TO GET A CATGEORY BY NAME------------------------------
	 */
	@Test
	void testgetCategoryByName()
	{
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/category/furniture",Category[].class);
		assertNotNull(responseEntity);	
	}
	
	/**
	 * ----------------------TEST CASE TO GET A CATEGORY BY BLANK NAME - FAIL----------------------
	 */
	@Test
	public void testgetCatgeoryByBlankName()
	{

		assertThrows(CategoryNotFoundException.class,()->
			{
				categoryService.getCategoryByName("furn");
			});
		
	}
	
	/**
	 * ---------------------------TEST TO DELETE A CATGEORY BY NAME----------------------------
	 *
	@Test
	void testDeleteCategoryByName()
	{
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/category/RealEstate/delete",Category[].class);
        restTemplate.delete("http://localhost:8080/cgoas/category/RealEstate/delete");
		assertNull(responseEntity);
		
	}
	/**
	 * ---------------------------TEST TO DELETE A CATGEORY BY BLANK NAME-FAIL----------------------------
	 */

}
