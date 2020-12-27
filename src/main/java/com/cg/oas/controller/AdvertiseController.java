package com.cg.oas.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oas.service.AdvertiseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.cg.oas.exception.AdvertiseNotFoundException;
import com.cg.oas.dto.Advertise;

@RestController
@CrossOrigin("*")
@RequestMapping("/cgoas")
@Api(value="Online Advertisement System related REST APIs")
public class AdvertiseController 
{
	//Logger logger = LogManager.getLogger(AdvertiseController.class);
	@Autowired
	private AdvertiseService advertiseService;
	
	//CONTROLLER TO READ ALL ADVERTISES
	@ApiOperation(value="Returns all advertisements")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Advertisement list returned"),
			@ApiResponse(code=404,message="No such advertise found"),
	})
	@GetMapping(value="/advertise/getall", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAllAdvertises() throws AdvertiseNotFoundException{
//	logger.info("Getting list of advertisements");
//	logger.error("Advertise not found");
//	logger.debug("Test");
//	logger.warn("Test 2");
		return advertiseService.getAllAdvertises();
	}
	
	//CONTROLLER TO READ ADVERTISE BY ID
	@ApiOperation(value="Returns advertisement using advertise id")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Advertisement of specific id returned"),
			@ApiResponse(code=404,message="No such advertise found"),
	})
	@GetMapping(value="/advertise/get/id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Advertise getAdvertiseById(@PathVariable("id") String ad_id) 
			throws AdvertiseNotFoundException {
		return advertiseService.getAdvertiseById(Long.parseLong(ad_id));
	}
	
	//CONTROLLER TO EDIT ADVERTISE BY ID
	@ApiOperation(value="Returns newly edited advertisement using advertise id")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Advertisement updated"),
			@ApiResponse(code=404,message="No such advertisement found"),
	})
	@PutMapping(value="/advertise/update/id/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Advertise> editAdvertise(@PathVariable("id") String ad_id,@Valid @RequestBody Advertise advertise) throws AdvertiseNotFoundException
	{
		return new ResponseEntity<Advertise>(advertiseService.editAdvertiseById(Long.parseLong(ad_id), advertise),HttpStatus.OK);
	}
	
	//CONTROLLER TO READ ADVERTISE BY TITLE
//	@ApiOperation(value="Returns advertisement using advertise title")
//	@ApiResponses(value= {
//			@ApiResponse(code=201,message="Advertisement of such title returned"),
//			@ApiResponse(code=404,message="No such advertise found"),
//	})
//	@GetMapping(value="/advertise/get/title/{title}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<Advertise> getAdvertiseByName(@PathVariable("title") String title) 
//			throws AdvertiseNotFoundException {
//		return advertiseService.getAdvertiseByTitle(title);
//	}
	
	@ApiOperation(value="Returns advertisement using advertise title")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Advertisement of such title returned"),
			@ApiResponse(code=404,message="No such advertise found"),
	})
	@GetMapping(value="/advertise/get/title/{title}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Advertise getAdvertiseByName(@PathVariable("title") String title) 
			throws AdvertiseNotFoundException {
		return advertiseService.getAdvertiseByTitle(title);
	}
	
	//CONTROLLER TO EDIT ADVERTISE BY TITLE
	@ApiOperation(value="Returns newly edited advertisement using advertise title")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Advertisement updated"),
			@ApiResponse(code=404,message="No such advertisement found"),
	})
	@PutMapping(value="/advertise/update/title/{title}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Advertise> editAdvertiseByTitle(@PathVariable("title") String title,@Valid @RequestBody Advertise advertise) throws AdvertiseNotFoundException
	{
		return new ResponseEntity<Advertise>(advertiseService.editAdvertiseByTitle(title, advertise),HttpStatus.OK);
	}
}
