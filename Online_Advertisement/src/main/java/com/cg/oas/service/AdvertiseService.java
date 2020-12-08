package com.cg.oas.service;

import com.cg.oas.dto.Advertise;
import com.cg.oas.exceptions.AdvertiseNotFoundException;

public interface AdvertiseService {
	Advertise findAdvertiseById(int advertiseId) throws AdvertiseNotFoundException;
}
