package com.cg.oas.dao;
import java.util.List;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.UserEntity;

import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.UserAddNotFoundException;
import com.cg.oas.exceptions.UserIdNotFoundException;
import com.cg.oas.exceptions.IdNotFoundException;

public interface UserDAO 
{    
	
	List<UserEntity> viewAllUsers() throws ListNotDisplayedException;
	UserEntity DeleteById(int user_id) throws IdNotFoundException;
	
	
UserEntity findById(int userId) throws UserIdNotFoundException;
	
List<AdvertiseEntity> viewAllAdvertise() throws UserAddNotFoundException;
	
	
	

}
