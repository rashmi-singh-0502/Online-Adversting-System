package com.cg.oas.service;

import java.util.List;
import com.cg.oas.dto.Advertise;
import com.cg.oas.exception.AdvertiseNotFoundException;


public interface AdvertiseService 
{
	public Advertise createAdvertise(Advertise Advertise);
	public List<Advertise> getAllAdvertises() throws AdvertiseNotFoundException;
	public Advertise getAdvertiseById(long ad_id) throws AdvertiseNotFoundException;
	public Advertise editAdvertise(long ad_id,Advertise Advertise) throws AdvertiseNotFoundException;
}
