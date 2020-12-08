package com.cg.oas.utils;

import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;

public class OnlineAdvertisementUtils {
	public static AdvertiseEntity convertAdvertiseIntoAdvertiseEntity(Advertise ad) {
		return new AdvertiseEntity(ad.getAd_id(), ad.getTitle(), ad.getCategory(),ad.getDescription(),ad.getPrice(),ad.getStatus());
	}
	public static Advertise convertAdvertiseEntityIntoAdvertise(AdvertiseEntity adEntity) {
		return new Advertise(adEntity.getAd_id(), adEntity.getTitle(), adEntity.getCategory(),adEntity.getDescription(),adEntity.getPrice(),adEntity.getStatus());
	}
}
