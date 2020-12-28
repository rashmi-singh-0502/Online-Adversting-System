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
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.service.UserService;
import com.cg.oas.testdto.User;


@SpringBootTest(classes = CgSpringOasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserControllerTest
{
	@Autowired
	public UserService userService;
	/**
	 * ---------------------TEST TO GET ALL THE LIST OF USERS----------------------
	 */
	@Test
	public void testGetAllUser()
	 {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/user",User[].class);
		assertNotNull(responseEntity);	
	}
	/**
	 * -----------------------------TESTING TO GET USER BY ID-----------------------
	 */
	@Test
	public void testFindUserById() 
	{
		RestTemplate restTemplate = new RestTemplate();
		User user=restTemplate.getForObject("http://localhost:8080/cgoas/user/search/101", User.class);
		assertNotNull(user);
	}
	
	/**
	 * -----------------------------TESTING TO GET USER BY WRONG ID-FAIL----------------------
	 */
	@Test
	public void testgetUserByBlankId()
	{

		assertThrows(UserNotFoundException.class,()->
			{
				userService.getUserById(10);
			});
		
	}
	
	/**
	 * ----------------------TEST TO GET A USER BY ITS NAME------------------------
	 */
	@Test
	void testgetUserByName()
	  {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/user/mahi",User[].class);
	    assertNotNull(responseEntity);
	   }
	
	/**
	 * ----------------------TEST CASE TO GET A USER BY BLANK NAME - FAIL----------------------
	 */
	@Test
	public void testgetUserByBlankName()
	{

		assertThrows(UserNotFoundException.class,()->
			{
				userService.getUserByName("kuku");
			});
		
	}
		
	/**
	 *-------------------------- TESTING TO CHECK USER GETS DELETED OR NOT BY ID-------------------
	 * 
	 
	@Test
	public void testDeleteById() 
	 {
		RestTemplate restTemplate = new RestTemplate();
		User user=restTemplate.getForObject("http://localhost:8080/cgoas/user/101", User.class);
		restTemplate.delete("http://localhost:8080/cgoas/user/100");
		assertNotNull(user);
		
	 }
	
	/**
	 * -----------------------TESTING TO CHECK USER GETS DELETED OR NOT BY ITS NAME------------------------
	 */
	

	}	
	

