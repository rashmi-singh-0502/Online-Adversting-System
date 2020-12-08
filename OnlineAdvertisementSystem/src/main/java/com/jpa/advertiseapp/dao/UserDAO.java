package com.jpa.advertiseapp.dao;

import com.jpa.advertiseapp.entity.UserEntity;
import com.jpa.advertiseapp.exceptions.UserNotFoundException;
public interface UserDAO
{
	UserEntity findByName(String name) throws UserNotFoundException;
	
}
