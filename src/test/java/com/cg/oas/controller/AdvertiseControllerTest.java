package com.cg.oas.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.oas.CgSpringOasApplication;
import com.cg.oas.dto.Advertise;
import com.cg.oas.exception.AdvertiseNotFoundException;
import com.cg.oas.service.AdvertiseService;

@SpringBootTest(classes = CgSpringOasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdvertiseControllerTest 
{
	private static final Logger logger = LogManager.getLogger(AdvertiseController.class);
	@Autowired
	private AdvertiseService advertiseService;
	public Advertise advertise;
	//TEST CASE TO READ ALL ADVERTISES
	@Test
	public void testGetAllAdvertises()
	{
		logger.info("[START] Test to read all advertises");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Advertise[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/advertise/getall", Advertise[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to read all advertises");
	}
		
	//TEST CASE TO READ AN ADVERTISE BY ID AS POSITIVE
	@Test
	public void testReadAdvertiseByIdSuccess()
	{
		logger.info("[START] Test to read advertise by advertise id");
		RestTemplate restTemplate = new RestTemplate();
		advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/id/1", Advertise.class);
		assertNotNull(advertise);
		logger.info("[END] Test to read advertise by advertise id");
	}
	
	//TEST CASE TO READ AN ADVERTISE BY ID AS NEGATIVE
	@Test
	public void testReadAdvertiseByIdNegative()
	{
		logger.info("[START] Test to read advertise by negative advertise id");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/id/-1", Advertise.class);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Advertise with negative id not found");
		}
		logger.info("[END] Test to read advertise by negative advertise id");
	}
	
	//TEST CASE TO READ AN ADVERTISE BY ID AS ZERO
	@Test
	public void testReadAdvertiseByIdZero()
	{
		logger.info("[START] Test to read advertise by advertise id = 0");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/id/0", Advertise.class);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Advertise with id = 0 not found");
		}
		logger.info("[END] Test to read advertise by advertise id = 0");
	}
	
	//TEST CASE TO READ AN ADVERTISE BY BLANK ID
	@Test
	public void testReadAdvertiseByBlankId()
	{
		logger.info("[START] Test to read advertise by blank advertise id");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/id/", Advertise.class);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Please enter a valid advertise id");
		}
		logger.info("[END] Test to read advertise by blank advertise id");
	}
		
	//TEST CASE TO READ AN ADVERTISE BY TITLE
	@Test
	public void testReadAdvertiseByTitleSuccess()
	{
		logger.info("[START] Test to read advertise by advertise title");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Advertise[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/advertise/get/title/Table", Advertise[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to read advertise by advertise title");
	}
		
	//TEST CASE TO READ AN ADVERTISE BY BLANK TITLE
	@Test
	public void testReadAdvertiseByBlankTitle()
	{
		logger.info("[START] Test to read advertise by blank advertise title");
		RestTemplate restTemplate = new RestTemplate();
		try
		{
			advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/title/", Advertise.class);
		}
		catch(Exception e)
		{
			advertise = null;
		}
		finally
		{
			assertNull(advertise,"Please enter a valid advertise title");
		}
		logger.info("[END] Test to read advertise by blank advertise title");
	}

	//TEST CASE TO READ AN ADVERTISE BY INCORRECT TITLE
	@Test
	public void testReadAdvertiseByIncorrectTitle()
	{
		logger.info("[START] Test to read advertise by incorrect advertise title");
		RestTemplate restTemplate = new RestTemplate();
		try
		{
			advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/title/Tabel", Advertise.class);
		}
		catch(Exception e)
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Tabel was not found");
		}
		logger.info("[END] Test to read advertise by incorrect advertise title");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY INVALID TITLE
	@Test
	public void testReadAdvertiseByInvalidTitle()
	{
		logger.info("[START] Test to read advertise by invalid advertise title");
		assertThrows(AdvertiseNotFoundException.class,
				()->{
					
					
					advertiseService.getAdvertiseByTitle("Tap");
					
				}
				);
		logger.info("[END] Test to read advertise by invalid advertise title");
	}
	//TEST CASE TO EDIT AN ADVERTISE BY ID - PASS
	@Test
	public void testEditAdvertiseByIdSuccess()
	{
		logger.info("[START] Test to edit advertise by advertise id");
		RestTemplate restTemplate = new RestTemplate();
		Advertise updatedAdvertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
		restTemplate.put("http://localhost:8080/cgoas/advertise/update/id/1", updatedAdvertise);
		assertNotNull(updatedAdvertise);
		logger.info("[END] Test to edit advertise by advertise id");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY ID AS NEGATIVE
	@Test
	public void testEditAdvertiseByIdNegative()
	{
		logger.info("[START] Test to edit advertise by negative advertise id");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
			restTemplate.put("http://localhost:8080/cgoas/advertise/update/id/-1", advertise);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Advertise with negative id not found, cannot be updated");
		}
		logger.info("[END] Test to edit advertise by negative advertise id");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY ID AS ZERO
	@Test
	public void testEditAdvertiseByIdZero()
	{
		logger.info("[START] Test to edit advertise by advertise id = 0");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
			restTemplate.put("http://localhost:8080/cgoas/advertise/update/id/0", advertise);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Advertise with id = 0 not found, cannot be updated");
		}
		logger.info("[END] Test to edit advertise by advertise id = 0");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY BLANK ID
	@Test
	public void testEditAdvertiseByBlankId()
	{
		logger.info("[START] Test to edit advertise by blank advertise id");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
			restTemplate.put("http://localhost:8080/cgoas/advertise/update/id/", advertise);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Please enter a valid advertise id");
		}
		logger.info("[END] Test to edit advertise by blank advertise id");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY TITLE
	@Test
	public void testEditAdvertiseByTitleSuccess()
	{
		logger.info("[START] Test to edit advertise by advertise title");
		RestTemplate restTemplate = new RestTemplate();
		Advertise updatedAdvertise = new Advertise("Mi TV","Flat, LED Display, Bezel less, Colour",20000.00);
		restTemplate.put("http://localhost:8080/cgoas/advertise/update/title/Samsung 24-inch monitor", updatedAdvertise);
		assertNotNull(updatedAdvertise);
		logger.info("[END] Test to edit advertise by advertise title");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY INCORRECT TITLE
	@Test
	public void testEditAdvertiseByIncorrectTitle()
	{
		logger.info("[START] Test to edit advertise by incorrect advertise title");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
			restTemplate.put("http://localhost:8080/cgoas/advertise/update/title/Smasung 24-inch monitor", advertise);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Smasung 24-inch monitor was not found, cannot be updated");
		}
		logger.info("[END] Test to edit advertise by incorrect advertise title");
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY INVALID TITLE
		@Test
		public void testEditAdvertiseByInvalidTitle()
		{
			logger.info("[START] Test to edit advertise by invalid advertise title");
			assertThrows(AdvertiseNotFoundException.class,
					()->{
						
						Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
						advertiseService.editAdvertiseByTitle("Philips 24-inch monitor", advertise);
						
					}
					);
			logger.info("[END] Test to edit advertise by invalid advertise title");
		}
		
	//TEST CASE TO EDIT AN ADVERTISE BY BLANK TITLE
	@Test
	public void testEditAdvertiseByBlankTitle()
	{
		logger.info("[START] Test to edit advertise by blank advertise title");
		RestTemplate restTemplate = new RestTemplate();
		try 
		{
			Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
			restTemplate.put("http://localhost:8080/cgoas/advertise/update/title/", advertise);
		}
		catch(Exception e) 
		{
			advertise = null;
		}
		finally 
		{
			assertNull(advertise,"Please enter a valid advertise title");
		}
		logger.info("[END] Test to edit advertise by blank advertise title");
	}
	//DELETE ADVERTISE BY ID
	@Test
	public void testDeleteById()
	{
		logger.info("[START] Test to delete advertise by advertise ID");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:9090/myapp/advertise/advertiseid/2");
		logger.info("[END] Test to delete advertise by advertise ID");
	}
	//DELETE ADVERTISE BY TITLE
	public void testDeleteBytitle()
	{
		logger.info("[START] Test to delete advertise by advertise Title");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:9090/myapp/advertise/door");
		logger.info("[END] Test to delete advertise by advertise Title");
	}
	
}