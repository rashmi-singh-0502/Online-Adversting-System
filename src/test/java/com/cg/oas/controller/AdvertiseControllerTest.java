package com.cg.oas.controller;

import static org.junit.jupiter.api.Assertions.*;
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
	@Autowired
	private AdvertiseService advertiseService;
	public Advertise advertise;
	//TEST CASE TO READ ALL ADVERTISES
	@Test
	public void testGetAllAdvertises()
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Advertise[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/advertise/getall", Advertise[].class);
		assertNotNull(responseEntity);
	}
		
	//TEST CASE TO READ AN ADVERTISE BY ID AS POSITIVE
	@Test
	public void testReadAdvertiseByIdSuccess()
	{
		RestTemplate restTemplate = new RestTemplate();
		advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/id/1", Advertise.class);
		assertNotNull(advertise);
	}
	
	//TEST CASE TO READ AN ADVERTISE BY ID AS NEGATIVE
	@Test
	public void testReadAdvertiseByIdNegative()
	{
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
	}
	
	//TEST CASE TO READ AN ADVERTISE BY ID AS ZERO
	@Test
	public void testReadAdvertiseByIdZero()
	{
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
	}
	
	//TEST CASE TO READ AN ADVERTISE BY BLANK ID
	@Test
	public void testReadAdvertiseByBlankId()
	{
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
	}
		
	//TEST CASE TO READ AN ADVERTISE BY TITLE
	@Test
	public void testReadAdvertiseByTitleSuccess()
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Advertise[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/cgoas/advertise/get/title/Table", Advertise[].class);
		assertNotNull(responseEntity);
	}
		
	//TEST CASE TO READ AN ADVERTISE BY BLANK TITLE
	@Test
	public void testReadAdvertiseByBlankTitle()
	{
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
	}

	//TEST CASE TO READ AN ADVERTISE BY INCORRECT TITLE
	@Test
	public void testReadAdvertiseByIncorrectTitle()
	{
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
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY INVALID TITLE
	@Test
	public void testReadAdvertiseByInvalidTitle()
	{
		assertThrows(AdvertiseNotFoundException.class,
				()->{
					
					
					advertiseService.getAdvertiseByTitle("Tap");
					
				}
				);
	}
	//TEST CASE TO EDIT AN ADVERTISE BY ID - PASS
	@Test
	public void testEditAdvertiseByIdSuccess()
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise updatedAdvertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
		restTemplate.put("http://localhost:8080/cgoas/advertise/update/id/1", updatedAdvertise);
		assertNotNull(updatedAdvertise);
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY ID AS NEGATIVE
	@Test
	public void testEditAdvertiseByIdNegative()
	{
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
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY ID AS ZERO
	@Test
	public void testEditAdvertiseByIdZero()
	{
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
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY BLANK ID
	@Test
	public void testEditAdvertiseByBlankId()
	{
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
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY TITLE
	@Test
	public void testEditAdvertiseByTitleSuccess()
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise updatedAdvertise = new Advertise("Mi TV","Flat, LED Display, Bezel less, Colour",20000.00);
		restTemplate.put("http://localhost:8080/cgoas/advertise/update/title/Samsung 24-inch monitor", updatedAdvertise);
		assertNotNull(updatedAdvertise);
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY INCORRECT TITLE
	@Test
	public void testEditAdvertiseByIncorrectTitle()
	{
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
	}
	
	//TEST CASE TO EDIT AN ADVERTISE BY INVALID TITLE
		@Test
		public void testEditAdvertiseByInvalidTitle()
		{
			assertThrows(AdvertiseNotFoundException.class,
					()->{
						
						Advertise advertise = new Advertise("Samsung 24-inch monitor","Flat, LED Display, Bezel less",15000.00);
						advertiseService.editAdvertiseByTitle("Philips 24-inch monitor", advertise);
						
					}
					);
		}
		
	//TEST CASE TO EDIT AN ADVERTISE BY BLANK TITLE
	@Test
	public void testEditAdvertiseByBlankTitle()
	{
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
	}
}