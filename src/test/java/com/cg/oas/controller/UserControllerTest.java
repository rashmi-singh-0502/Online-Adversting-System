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
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.service.UserService;
import com.cg.oas.service.UserServiceImpl;
import com.cg.oas.testdto.User;


@SpringBootTest(classes = CgSpringOasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserControllerTest
{
	@Autowired
	public UserService userService;
	 private static Logger logger=LogManager.getLogger(UserServiceImpl.class.getName());;
	 
	 
	/**
	 * ---------------------TEST TO GET ALL THE LIST OF USERS----------------------
	 */
	@Test
	public void testGetAllUser()
	 { 
		logger.info("[START] testGetAllUser()");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/user",User[].class);
		assertNotNull(responseEntity);
		logger.info("User displayed");
		logger.info("[END] testGetAllUser()");
	}
	/**
	 * -----------------------------TESTING TO GET USER BY ID-----------------------
	 */
	@Test
	public void testFindUserById() 
	{
		logger.info("[START] testFindUserById()");
		RestTemplate restTemplate = new RestTemplate();
		User user=restTemplate.getForObject("http://localhost:8080/cgoas/user/search/110", User.class);
		assertNotNull(user);
		logger.info("User by Id displayed");
		logger.info("[END] testFindUserById()");
		
	}
	
	/**
	 * -----------------------------TESTING TO GET USER BY WRONG ID-FAIL----------------------
	 */
	@Test
	public void testgetUserByBlankId()
	{
		logger.info("[START] testgetUserByBlankId()");
		assertThrows(UserNotFoundException.class,()->
			{
				userService.getUserById(10);
			});
		logger.error("UserId is invalid");
		logger.info("[END] testFindUserByBlankId()");
		
	}
	
	/**
	 * ----------------------TEST TO GET A USER BY ITS NAME------------------------
	 */
	@Test
	void testgetUserByName()
	  {
		logger.info("[START] testgetUserByName()");
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/user/sangita",User[].class);
	    assertNotNull(responseEntity);
	    logger.info("User by Name displayed");
		logger.info("[END] testFindUserByName()");
		
	    
	   }
	
	/**
	 * ----------------------TEST CASE TO GET A USER BY BLANK NAME - FAIL----------------------
	 */
	@Test
	public void testgetUserByBlankName()
	{
		logger.info("[START] testgetUserByBlankName()");
		assertThrows(UserNotFoundException.class,()->
			{
				userService.getUserByName("kuku");
			});
		logger.error("UserName is invalid");
		logger.info("[END] testFindUserByBlankName()");
		
	}
		
	/**
	 *-------------------------- TESTING TO CHECK USER GETS DELETED OR NOT BY ID-------------------
	 */
	 
	@Test
	public void testDeleteById() 
	 {
		logger.info("[START] testDeleteById()");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/cgoas/user/{id}",110);
		logger.info("User deleted by id");
		logger.info("[END] testDeleteById()");
		
	 }
	
	 /**
	 *-------------------------- TESTING TO  DELETE USER  BY WRONG ID-------------------
	 */
	@Test()
	void testdeleteUserByIdFail()
	{
		logger.info("[START] testdeleteUserByIdFail()");
		assertThrows(UserNotFoundException.class,
				()->{
					
					userService.deleteById(200);
					
				}
				);
		logger.info("User id is invalid");
		logger.info("[END] testdeleteUserByIdFail()");
	}

	/**
	 * -----------------------TESTING TO CHECK USER GETS DELETED OR NOT BY ITS NAME------------------------
	 */
	@Test
	void testDeleteUserByName() throws UserNotFoundException
	{
		logger.info("[START] testDeleteUserByName()");
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/cgoas/user/{name}/delete","sara");
        logger.info("User is deleted by name");
        logger.info("[END] testDeleteUserByName()");
		
	}
	/**
	 * ---------------------------TEST TO DELETE A CATGEORY BY BLANK NAME-FAIL----------------------------
	 */
	@Test()
	void testdeleteUserByNameFail()
	{
		logger.info("[START] testDeleteUserByNameFail()");
		assertThrows(UserNotFoundException.class,
				()->{
					
					userService.deleteUser("ram");
				}
				);
		logger.error("User name is Invalid");
		logger.info("[END] testDeleteUserByNameFail()");
	}


	}	
	

