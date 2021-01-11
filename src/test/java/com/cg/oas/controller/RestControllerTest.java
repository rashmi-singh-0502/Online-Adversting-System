package com.cg.oas.controller;


import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.User;
import static org.junit.jupiter.api.Assertions.*;
import java.net.URI;
import java.net.URISyntaxException;

public class RestControllerTest {

	//TEST CASE TO READ ALL ADVERTISES POSTED BY USER
	@Test
	public void testReadAllAdvertiseSuccess() throws URISyntaxException
	{
		URI uri = new URI("http://localhost:8080/oas/advertise");
		RestTemplate restTemplate = new RestTemplate();
		Advertise[] ad = restTemplate.getForObject(uri, Advertise[].class);
		assertNotNull(ad);
	}
	
	
	//TEST CASE TO READ ALL USERS
	@Test
	public void testReadAllUsersSuccess() throws URISyntaxException
	{
		URI uri = new URI("http://localhost:8080/oas/user");
		RestTemplate restTemplate = new RestTemplate();
		User[] user = restTemplate.getForObject(uri, User[].class);
		assertNotNull(user);
	}
	
		//TEST CASE TO READ USER BY SPECIFIC ID
		@Test
		public void testReadUserByIdSuccess() throws URISyntaxException
		{
			URI uri = new URI("http://localhost:8080/oas1/users/48");
			RestTemplate restTemplate = new RestTemplate();
			User user = restTemplate.getForObject(uri, User.class);
			assertNotNull(user);
		}
	
	//TEST CASE TO POST NEW ADVERTISE
	@Test
	public void testPostAdvertiseSuccess()throws URISyntaxException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI url = new URI("http://localhost:8080/oas/advertises");
		User user=new User();
		user.setUser_id(101);
		Advertise obj = new Advertise();
		obj.setAd_id((long) 11);
		obj.setTitle("car advertise");
		obj.setUser(user);

		HttpEntity<Advertise> requestEntity = new HttpEntity<>(obj, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Advertise> responseEntity = restTemplate.postForEntity(url, requestEntity, Advertise.class);

		System.out.println("Status Code: " + responseEntity.getStatusCode());	
		System.out.println("Id: " + responseEntity.getBody().getAd_id());		
	}
	
}
