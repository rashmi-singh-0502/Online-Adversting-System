package com.cg.oas.dao;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public interface AdDAO 
{
	AdvertiseEntity postNewAdvertise(AdvertiseEntity adEntity) throws InvalidDataFormatException;
}

