package com.cg.oas.service;

import java.util.List;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFound;
import com.cg.oas.exceptions.AdvertiseNotFoundException;

public interface AdvertiseService {
	Advertise findAdvertiseTitle(String  advertisename) throws AdvertiseNotFound;
	
	//Delete Advertise By AdvertisementID
	Advertise DeleteById(int advertiseId)throws AdvertiseNotFound;
	
	//function for reading advertise by id
		Advertise readAdvertiseById(int advertiseId) throws AdvertiseNotFoundException;

		//function for editing advertise by id
		Advertise editAdvertise(int advertiseId)throws AdvertiseNotFoundException;

		//function for reading all advertises
		public List<Advertise> viewAllAdvertises() throws AdvertiseNotFoundException;
}
