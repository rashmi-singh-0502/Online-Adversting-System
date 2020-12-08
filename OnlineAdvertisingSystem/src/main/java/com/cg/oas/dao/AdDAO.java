package com.cg.oas.dao;

import com.cg.oas.entity.AdEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public interface AdDAO 
{
	AdEntity postNewAdvertise(AdEntity adEntity) throws InvalidDataFormatException;
}
