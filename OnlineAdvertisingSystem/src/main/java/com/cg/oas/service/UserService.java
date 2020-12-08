package com.cg.oas.service;

import java.util.List;

import com.cg.oas.dto.User;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;

public interface UserService

{
	
	   List<UserEntity> viewUser();  
	
		User DeleteById(int userId) throws IdNotFoundException;
}
