package com.cg.oas.dao;

import com.cg.oas.entity.AdEntity;
import com.cg.oas.exceptions.AdNotFoundException;


public interface AdDao {
	AdEntity findAdvertiseById(int advertiseId) throws AdNotFoundException;
}
