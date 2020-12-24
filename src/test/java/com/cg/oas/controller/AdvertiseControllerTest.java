package com.cg.oas.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exception.AdvertiseNotFoundException;

public class AdvertiseControllerTest 
{
	@Test
	public void testFindAdvertiseByIdSuccess()
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/1", Advertise.class);
		assertNotNull(advertise);
	}
	
	@Test
	public void testFindAdvertiseByIdFail1() throws AdvertiseNotFoundException
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/get/-1", Advertise.class);
		assertNotNull(advertise);
	}
	/*@Test
	public void testEditAdvertise()
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/update/1", Advertise.class);
		assertNotNull(advertise);
	}
	
	@Test
	public void testGetAllAdvertises()
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise", Advertise.class);
		assertNotNull(advertise);
	}
	
	@Test
	public void testCreateNewAdvertise()
	{
		RestTemplate restTemplate = new RestTemplate();
		Advertise advertise = restTemplate.getForObject("http://localhost:8080/cgoas/advertise/new", Advertise.class);
		assertNotNull(advertise);
	}*/
}
