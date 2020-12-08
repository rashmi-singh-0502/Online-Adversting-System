package com.cg.oas.service;
import com.cg.oas.dto.Ad;
import com.cg.oas.entity.AdEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public interface AdService  {

	Ad addData(AdEntity adEntity) throws InvalidDataFormatException;

}

