package com.cg.oas.utils;
import java.util.List;
import com.cg.oas.dto.Advertise;
import com.cg.oas.entity.AdvertiseEntity;
public class AdAppUtils 
{

		public static Advertise convertUserEntityToUser(AdvertiseEntity adEntity) {
			return new Advertise(adEntity.getAd_id(),adEntity.getTitle(),adEntity.getCategory(),adEntity.getDescription(),adEntity.getPrice(),adEntity.getStatus());
		} 
		
		public static AdvertiseEntity coverUserToUSerEntity(Advertise ad) {
			return new AdvertiseEntity(ad.getAd_id(),ad.getTitle(),ad.getCategory(),ad.getDescription(),ad.getPrice(),ad.getStatus());
		}
}

