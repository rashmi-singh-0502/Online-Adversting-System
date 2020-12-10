package com.cg.oas.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;

	
public class OasUtils 
{
		public static AdvertiseEntity convertAdvertiseIntoAdvertiseEntity(Advertise ad) {
			return new AdvertiseEntity(ad.getAd_id(), ad.getTitle(), ad.getCategory(),ad.getDescription(),ad.getPrice(),ad.getStatus());
		}
		public static Advertise convertAdvertiseEntityIntoAdvertise(AdvertiseEntity adEntity) {
			return new Advertise(adEntity.getAd_id(), adEntity.getTitle(), adEntity.getCategory(),adEntity.getDescription(),adEntity.getPrice(),adEntity.getStatus());
		}
		
		//converting AdvertiseEntityList to Advertise
		public static List<Advertise> convertAdvertiseEntityListToAdvertise(List<AdvertiseEntity> entities) {
			Iterator<AdvertiseEntity> itr = entities.iterator();
			List<Advertise> advertises = new ArrayList();
			while (itr.hasNext()) {
				AdvertiseEntity advertiseEntity1=itr.next();
				advertises.add(new Advertise(advertiseEntity1.getAd_id(),advertiseEntity1.getTitle(), advertiseEntity1.getCategory(), advertiseEntity1.getDescription(), advertiseEntity1.getPrice(), advertiseEntity1.getStatus()));
			}
			return advertises;
		}
}
	

