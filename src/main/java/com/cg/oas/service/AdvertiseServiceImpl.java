package com.cg.oas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.oas.controller.AdvertiseController;
import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exception.AdvertiseNotFoundException;
import com.cg.oas.repo.AdvertiseRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	Logger logger = LogManager.getLogger(AdvertiseServiceImpl.class);
	@Autowired
	private AdvertiseRepo advertiseRepo;
	
	//FUNCTION TO READ ALL ADVERTISES
	@Override
	public List<Advertise> getAllAdvertises() throws AdvertiseNotFoundException{
		List<AdvertiseEntity> advertiseEntityList = advertiseRepo.findAll();
		if(!advertiseEntityList.isEmpty()) 
		{
		List<Advertise> advertises = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntityList) {
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(), advertiseEntity.getCategory().getName(), advertiseEntity.getCategory().getCategory_desc());
			advertises.add(new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category));
		}
		logger.info("Returning list of advertisements :"+advertises);
		return advertises;
	}
		else
		{
			logger.error("List of advertisements not found");
			throw new AdvertiseNotFoundException("No record found");
		}
	}
	
	
	//FUNCTION TO READ ADVERTISE BY ID
	@Override
	public Advertise getAdvertiseById(long ad_id) throws AdvertiseNotFoundException {
		Optional<AdvertiseEntity> opAdvertiseEntity = advertiseRepo.findById(ad_id);
		if(opAdvertiseEntity.isPresent()) {
			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getName(), advertiseEntity.getCategory().getCategory_desc());
			logger.info("Returning advertisement with id : "+ad_id);
			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		}
		else {
			logger.error("Advertisement with id : "+ad_id+" not found");
			throw new AdvertiseNotFoundException("ad_id: " + ad_id);
			//return null;
		}
	}
	

	//FUNCTION TO READ ADVERTISE BY TITLE
	@Override
	public List<Advertise> getAdvertiseByTitle(String title) throws AdvertiseNotFoundException {
		List<AdvertiseEntity> advertiseEntityList = advertiseRepo.findByTitleRead(title);
		if(!advertiseEntityList.isEmpty())
		{
		List<Advertise> advertises = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity:advertiseEntityList)
		{
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getName(), advertiseEntity.getCategory().getCategory_desc());
			advertises.add(new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category));
		}
		logger.info("Returning advertisement with title : "+title);
		return advertises;
		}
		else
		{
			logger.error("Advertisement with title : "+title+" not found");
			throw new AdvertiseNotFoundException("Advertise title:"+title);
		}
	}
	
	//FUNCTION TO EDIT ADVERTISE BY ID
	@Override
	public Advertise editAdvertiseById(long ad_id,Advertise advertise) throws AdvertiseNotFoundException {
		Optional<AdvertiseEntity> opAdvertiseEntity = advertiseRepo.findById(ad_id);
		if(opAdvertiseEntity.isPresent()) {
			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
			advertiseEntity.setTitle(advertise.getTitle());
			advertiseEntity.setDescription(advertise.getDescription());
			advertiseEntity.setPrice(advertise.getPrice());
			advertiseRepo.save(advertiseEntity);
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getName(), advertiseEntity.getCategory().getCategory_desc());
			logger.info("Advertisement with id : "+ad_id+" edited successfully");
			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		}
		else {
			logger.error("Advertisement with id : "+ad_id+" not found, hence cannot be edited");
			throw new AdvertiseNotFoundException("ad_id: " + ad_id);
		}
	}
	
	//FUNCTION TO EDIT ADVERTISE BY TITLE
	@Override
	public Advertise editAdvertiseByTitle(String title,Advertise advertise) throws AdvertiseNotFoundException {
		Optional<AdvertiseEntity> opAdvertiseEntity = advertiseRepo.findByTitleEdit(title);
		if(opAdvertiseEntity.isPresent()) {
			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
			advertiseEntity.setTitle(advertise.getTitle());
			advertiseEntity.setDescription(advertise.getDescription());
			advertiseEntity.setPrice(advertise.getPrice());
			advertiseRepo.save(advertiseEntity);
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getName(), advertiseEntity.getCategory().getCategory_desc());
			logger.info("Advertisement with title : "+title+" edited successfully");
			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		}
		else {
			logger.error("Advertisement with title : "+title+" not found, hence cannot be edited");
			throw new AdvertiseNotFoundException("title: " + title);
		}
	}
	//FUNCTION TO DELETE BY ID
	@Override
	public String deleteById(Long ad_id) throws AdvertiseNotFoundException {
		AdvertiseEntity advertiseEntity = advertiseRepo.findById(ad_id).orElseThrow(()-> new AdvertiseNotFoundException
				("Sorry! No Advertise Found with the given ID "+ad_id));

		advertiseRepo.deleteById(ad_id);
		// TODO Auto-generated method stub
		return "Advertise deleted Sucessfully";
	}
	//FUNCTION TO DELETE BY TITLE
	@Override
	
	public String deleteAdvertiseByTitle(String title) throws AdvertiseNotFoundException {
		
		AdvertiseEntity advertiseEntityList = advertiseRepo.findByTitledelete(title);
		advertiseRepo.deleteByTitle(title);
		
		// TODO Auto-generated method stub
		return "Advertise deleted Sucessfully";
	}
}
