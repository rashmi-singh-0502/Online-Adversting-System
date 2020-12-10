package com.cg.oas.dao;

import java.util.List;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;
import com.cg.oas.exceptions.InvalidDataFormatException;


public interface AdvertiseDAO {
	AdvertiseEntity findAdvertiseTitle(String title) throws AdvertiseNotFound;
	
	//Delete Advertise By AdvertisementId
	AdvertiseEntity DeleteById(int advertiseId) throws AdvertiseNotFound;
	
	//function for reading advertise by id
		AdvertiseEntity readAdvertiseById(int advertiseId) throws AdvertiseNotFoundException;
		
		//function for editing advertise
		AdvertiseEntity editAdvertise(int advertiseId) throws AdvertiseNotFoundException;
		
		//function for reading all advertises
		List<AdvertiseEntity> viewAllAdvertises() throws AdvertiseNotFoundException;
		
		//interface for post new advertise
		AdvertiseEntity postNewAdvertise(AdvertiseEntity adEntity) throws InvalidDataFormatException;
}
