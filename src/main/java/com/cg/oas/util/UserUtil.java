package com.cg.oas.util;


import java.util.ArrayList;
import java.util.List;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.User;
public class UserUtil
{
	public static Advertise convertAdvertiseEntityIntoAdvertise(AdvertiseEntity advertiseEntity) {
		//This Method converts Advertise Entity Into Advertise 
		User user = new User();
		Advertise advertise = 
				new Advertise(advertiseEntity.getAd_id(),advertiseEntity.getDescription(),advertiseEntity.getTitle(),advertiseEntity.getPrice());
		return advertise;
	}

	public static AdvertiseEntity convertAdvertiseIntoAdvertiseEntity(Advertise advertise, UserEntity userEntity) {
		////This Method converts Advertise Into Advertise Entity 
		return new AdvertiseEntity(advertise.getAd_id(),advertise.getDescription(),advertise.getTitle(),advertise.getPrice(), null);
	}

	public static List<Advertise> convertAdvertiseEntityListIntoAdvertiseList(List<AdvertiseEntity> advertiseEntityList) {
		//This Method converts Advertise Entity List  Into Advertise List Format 
		List<Advertise> advertise = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntityList) {
			advertise.add(convertAdvertiseEntityIntoAdvertise(advertiseEntity));
		}
		return advertise;
	}
}
