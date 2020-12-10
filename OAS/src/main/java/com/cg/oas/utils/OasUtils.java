package com.cg.oas.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.Category;
import com.cg.oas.dto.User;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.entity.UserEntity;

	
public class OasUtils 
{
		public static AdvertiseEntity convertAdvertiseIntoAdvertiseEntity(Advertise ad)
		{
			return new AdvertiseEntity(ad.getAd_id(), ad.getTitle(), ad.getCategory(),ad.getDescription(),ad.getPrice(),ad.getStatus());
		}
		public static Advertise convertAdvertiseEntityIntoAdvertise(AdvertiseEntity adEntity) 
		{
			return new Advertise(adEntity.getAd_id(), adEntity.getTitle(), adEntity.getCategory(),adEntity.getDescription(),adEntity.getPrice(),adEntity.getStatus());
		}
		
		//converting AdvertiseEntityList to Advertise
		public static List<Advertise> convertAdvertiseEntityListToAdvertise(List<AdvertiseEntity> entities) 
		{
			Iterator<AdvertiseEntity> itr = entities.iterator();
			List<Advertise> advertises = new ArrayList();
			while (itr.hasNext()) 
			{
				AdvertiseEntity advertiseEntity1=itr.next();
				advertises.add(new Advertise(advertiseEntity1.getAd_id(),advertiseEntity1.getTitle(), advertiseEntity1.getCategory(), advertiseEntity1.getDescription(), advertiseEntity1.getPrice(), advertiseEntity1.getStatus()));
			}
			return advertises;
			
		}
		
		 // convert category into categoryEntity
		public static CategoryEntity convertCategoryIntoCategoryEntity(Category category) 
		{    
			CategoryEntity entity=new CategoryEntity();
			
			return new CategoryEntity(category.getCategory_id(),category.getCategory_name(), category.getCategory_desc());
		}
		//convert categoryEntity into category
		
		public static Category convertCategoryEntityIntoCategory(CategoryEntity categoryEntity)
		{
			
			Category category=new Category();
			return new Category(categoryEntity.getCategory_id(),categoryEntity.getCategory_name(), categoryEntity.getCategory_desc());
		}
		//converts user into userEntity
		
		public static UserEntity convertUserIntoUserEntity(User user)
		{     UserEntity entity=new UserEntity();
		
			return new UserEntity(user.getUser_id(),user.getUser_name(),user.getUser_address(),user.getUser_contactno(),user.getUser_email());
			
		}
		//converts user entity into user
		public static User convertUserEntityIntoUser(UserEntity userEntity)
		{
			User user=new User();
			return new User(userEntity.getUser_id(),userEntity.getUser_name(),userEntity.getUser_address(),userEntity.getUser_contactno(),userEntity.getUser_email());
		}
		
		//converts user entity list into user objects list
		public static List<User> convertUserEntityListToUser(List<UserEntity> entities) {
			Iterator<UserEntity> itr = entities.iterator();
			List<User> users = new ArrayList();
			
			while (itr.hasNext()) {
				UserEntity userEntity1=itr.next();
				
				users.add(new User(userEntity1.getUser_id(),userEntity1.getUser_name(), userEntity1.getUser_address(), userEntity1.getUser_contactno(),userEntity1.getUser_email()));
			}
			return users;
		}
		
		
		
		
		
		
		
		
	/*	public static List<Advertise> convertAdvertiseEntityListToAdvertise(List<AdvertiseEntity> entities) {
			Iterator<AdvertiseEntity> itr = entities.iterator();
			List<Advertise> advertise = new ArrayList();
			
			while (itr.hasNext()) {
				AdvertiseEntity advertiseEntity1=itr.next();
				
				advertise.add(new Advertise(advertiseEntity1.getAdid(),advertiseEntity1.getTitle(),advertiseEntity1.getCategory(),advertiseEntity1.getDescription(),advertiseEntity1.getPrice(),advertiseEntity1.getStatus()));
			}
			return advertise;
		}
	
		*/
		
		
		
		
		
		
		
		
		
}
	

