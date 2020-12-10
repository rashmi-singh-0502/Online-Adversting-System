package com.cg.oas.dao;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFound;


public interface AdvertiseDAO {
	AdvertiseEntity findAdvertiseTitle(String title) throws AdvertiseNotFound;

	
}
