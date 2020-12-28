package com.cg.oas.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.CategoryEntity;


public class AdvertiseUtil {
	public static Advertise convertAdvertiseEntityIntoAdvertise(AdvertiseEntity advertiseEntity) {
		Category category = new Category(advertiseEntity.getCategory().getCategory_id(), advertiseEntity.getCategory().getName(), advertiseEntity.getCategory().getCategory_desc());
		Advertise advertise = 
				new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getTitle(),advertiseEntity.getDescription(),advertiseEntity.getPrice(),category);
		return advertise;
	}

	public static AdvertiseEntity convertAdvertiseIntoAdvertiseEntity(Advertise advertise, CategoryEntity category) {
		return new AdvertiseEntity(advertise.getAd_id(),advertise.getTitle(),advertise.getDescription(),advertise.getPrice(),category);
	}

	public static List<Advertise> convertAdvertiseEntityListIntoAdvertiseList(List<AdvertiseEntity> advertiseEntityList) {
		List<Advertise> advertises = new ArrayList<Advertise>();
		for(AdvertiseEntity AdvertiseEntity: advertiseEntityList) {
			advertises.add(convertAdvertiseEntityIntoAdvertise(AdvertiseEntity));
		}
		return advertises;
	}
}
