package com.cg.oas.utils;

import java.util.Set;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.dto.User;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.entity.UserEntity;
	
public class OasUtils 
{

	
		public static CategoryEntity convertCategoryIntoCategoryEntity(Category category) 
		{
			return new CategoryEntity( category.getName(), category.getDesc());
		}
		public static Category convertCategoryEntityIntoCategory(CategoryEntity categoryEntity)
		{
			return new Category(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDesc());
		}
		
		public static UserEntity convertUserIntoUserEntity(User user)
		{
			return new UserEntity(user.getName(),user.getAddress(),user.getContactno(),user.getEmail());
			
		}
		public static User convertUserEntityIntoUser(UserEntity userEntity)
		{
			return new User(userEntity.getName(),userEntity.getAddress(),userEntity.getContactno(),userEntity.getEmail());
		}
		
		public static AdvertiseEntity convertAdvertiseIntoAdvertiseEntity(Advertise ad) {
			return new AdvertiseEntity(ad.getAd_id(), ad.getTitle(), ad.getCategory(),ad.getDescription(),ad.getPrice(),ad.getStatus());
		}
		public static Advertise convertAdvertiseEntityIntoAdvertise(AdvertiseEntity adEntity) {
			return new Advertise(adEntity.getAd_id(), adEntity.getTitle(), adEntity.getCategory(),adEntity.getDescription(),adEntity.getPrice(),adEntity.getStatus());
		}
}

	

