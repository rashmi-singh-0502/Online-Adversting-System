package com.cg.oas.service;
import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public interface AdService  {

	Advertise addData(AdvertiseEntity adEntity) throws InvalidDataFormatException;

}

