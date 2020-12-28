package com.cg.oas.service;

import java.util.List;
import com.cg.oas.dto.Advertise;
import com.cg.oas.exception.AdvertiseNotFoundException;


public interface AdvertiseService 
{
	public List<Advertise> getAllAdvertises() throws AdvertiseNotFoundException;
	public Advertise getAdvertiseById(long ad_id) throws AdvertiseNotFoundException;
	public Advertise editAdvertiseById(long ad_id,Advertise Advertise) throws AdvertiseNotFoundException;
	public List<Advertise> getAdvertiseByTitle(String title) throws AdvertiseNotFoundException;
	public Advertise editAdvertiseByTitle(String title, Advertise advertise) throws AdvertiseNotFoundException;
	//public Advertise getAdvertiseByTitle(String title) throws AdvertiseNotFoundException;
	public String deleteById(Long ad_id)throws AdvertiseNotFoundException;
	public String deleteAdvertiseByTitle(String title)throws AdvertiseNotFoundException;

}
