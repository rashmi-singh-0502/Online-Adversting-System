package com.cg.oas.dao;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.AdvertiseNotFoundException;

public interface AdvertiseDAO {
	AdvertiseEntity findAdvertiseById(int advertiseId) throws AdvertiseNotFoundException;
}
