package com.cg.oas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exception.AdvertiseNotFoundException;
import com.cg.oas.repo.AdvertiseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	//private static final Logger logger = LoggerFactory.getLogger(AdvertiseServiceImpl.class);
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
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(), advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
			advertises.add(new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category));
		}
		return advertises;
	}
		else
		{
			throw new AdvertiseNotFoundException("No record found");
		}
	}
	
	
	//FUNCTION TO READ ADVERTISE BY ID
	@Override
	public Advertise getAdvertiseById(long ad_id) throws AdvertiseNotFoundException {
		Optional<AdvertiseEntity> opAdvertiseEntity = advertiseRepo.findById(ad_id);
		if(opAdvertiseEntity.isPresent()) {
			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		}
		else {
			throw new AdvertiseNotFoundException("ad_id: " + ad_id);
			//return null;
		}
	}
	
	//FUNCTION TO READ ADVERTISE BY TITLE
//	@Override
//	public Advertise getAdvertiseByTitle(String title) throws AdvertiseNotFoundException {
//		Optional<AdvertiseEntity> opAdvertiseEntity = advertiseRepo.findByTitleRead(title);
//		if(opAdvertiseEntity.isPresent()) {
//			AdvertiseEntity advertiseEntity = opAdvertiseEntity.get();
//			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
//			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
//		}
//		else {
//			throw new AdvertiseNotFoundException("title: " + title);
//			//return null;
//		}
//	}
	
	//FUNCTION TO READ ADVERTISE BY TITLE
	@Override
	public List<Advertise> getAdvertiseByTitle(String title) throws AdvertiseNotFoundException {
		List<AdvertiseEntity> advertiseEntityList = advertiseRepo.findByTitleRead(title);
		if(!advertiseEntityList.isEmpty())
		{
		List<Advertise> advertises = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity:advertiseEntityList)
		{
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
			advertises.add(new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category));
		}
		return advertises;
		}
		else
		{
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
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		}
		else {
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
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(),advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
			return new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		}
		else {
			throw new AdvertiseNotFoundException("title: " + title);
		}
	}
}
