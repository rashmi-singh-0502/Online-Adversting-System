package com.jpa.advertiseapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jpa.advertiseapp.dao.UserDAO;
import com.jpa.advertiseapp.dao.UserDAOImpl;
import com.jpa.advertiseapp.dto.User;
import com.jpa.advertiseapp.entity.UserEntity;
import com.jpa.advertiseapp.exceptions.UserNotFoundException;
import com.jpa.advertiseapp.presentation.AdvertiseAppController;
//import com.jpa.advertiseapp.utils.AdvertiseAppUtils;
import com.jpa.advertiseapp.utils.UserAddUtils;

public class UserServiceImpl implements UserService {

	private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	UserDAO userDao = new UserDAOImpl();
	
	public User findByName(String name) throws UserNotFoundException {
		UserEntity userEntity = userDao.findByName(name);
		logger.info("UserEntity: " + userEntity);
		return UserAddUtils.convertUserEntityIntoUser(userEntity);
	}
	
	

}

