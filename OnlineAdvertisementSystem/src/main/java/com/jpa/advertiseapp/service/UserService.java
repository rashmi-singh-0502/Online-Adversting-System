package com.jpa.advertiseapp.service;

import com.jpa.advertiseapp.dto.User;
import com.jpa.advertiseapp.exceptions.UserNotFoundException;
public interface UserService 
{
	User findByName(String name) throws UserNotFoundException;

}








