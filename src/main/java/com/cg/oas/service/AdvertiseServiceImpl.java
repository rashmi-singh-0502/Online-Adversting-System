package com.cg.oas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exception.AdvertiseNotFoundException;
import com.cg.oas.repo.AdvertiseRepo;
import com.cg.oas.repo.CategoryRepo;
import com.cg.oas.util.AdvertiseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	//private static final Logger logger = LoggerFactory.getLogger(AdvertiseServiceImpl.class);
	@Autowired
	private AdvertiseRepo advertiseRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Advertise createAdvertise(Advertise advertise) {
		Optional<CategoryEntity> categoryOptional = categoryRepo.findById(advertise.getCategory().getCategory_id());
		if(categoryOptional.isPresent()) {
			CategoryEntity categoryEntity = categoryOptional.get();
			AdvertiseEntity advertiseEntity = 
					advertiseRepo.save(AdvertiseUtil.convertAdvertiseIntoAdvertiseEntity(advertise, categoryEntity));
			return AdvertiseUtil.convertAdvertiseEntityIntoAdvertise(advertiseEntity);
		}
		return null;
	}
	
	@Override
	public List<Advertise> getAllAdvertises() {
		List<AdvertiseEntity> advertiseEntityList = advertiseRepo.findAll();
		List<Advertise> advertises = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntityList) {
			Category category = new Category(advertiseEntity.getCategory().getCategory_id(), advertiseEntity.getCategory().getCategory_name(), advertiseEntity.getCategory().getCategory_desc());
			advertises.add(new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category));
		}
		return advertises;
	}
		
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
		}
	}
	
	
	@Override
	public Advertise editAdvertise(long ad_id,Advertise advertise) throws AdvertiseNotFoundException {
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

}
