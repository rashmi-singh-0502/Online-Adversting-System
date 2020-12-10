package com.cg.oas.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dao.UserDAO;
import com.cg.oas.dao.UserDAOImpl;
import com.cg.oas.dto.User;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.utils.OasUtils;
import com.cg.oas.service.UserServiceImpl;

public class UserServiceImpl implements UserService
{
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	UserDAO userDao = new UserDAOImpl();
	
	List<User> users;
	//Calling DAO service for userList

	public List<User> viewAllUsers() throws ListNotDisplayedException {

		List<UserEntity> entities=userDao.viewAllUsers();
		logger.info("All User Entries are:");
		users=OasUtils.convertUserEntityListToUser(entities);
		
		return users;
	}

    //Calling DAO service for userId
	public User DeleteById(int user_id)throws IdNotFoundException 
	{
		UserEntity userEntity=userDao.DeleteById(user_id);
		logger.info("UserEntity: " + userEntity);
		return OasUtils.convertUserEntityIntoUser(userEntity);
	}
	
	
}
