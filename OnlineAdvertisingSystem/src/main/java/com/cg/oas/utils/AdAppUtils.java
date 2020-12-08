package com.cg.oas.utils;
import java.util.List;
import com.cg.oas.dto.Ad;
import com.cg.oas.entity.AdEntity;
public class AdAppUtils 
{

		public static Ad convertUserEntityToUser(AdEntity adEntity) {
			return new Ad(adEntity.getAdvertiseTitle(),adEntity.getAdvertiseCategory(),adEntity.getPrice(),adEntity.getDescription());
		} 
		
		public static AdEntity coverUserToUSerEntity(Ad ad) {
			return new AdEntity(ad.getAdvertiseTitle(),ad.getCategory(),ad.getPrice(),ad.getDescription());
		}
}
