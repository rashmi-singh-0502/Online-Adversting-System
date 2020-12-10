package com.cg.oas.service;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFound;

public interface AdvertiseService {
	Advertise findAdvertiseTitle(String  advertisename) throws AdvertiseNotFound;
}
