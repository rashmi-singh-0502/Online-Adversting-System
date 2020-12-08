package com.cg.oas.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dao.UserDAO;
import com.cg.oas.dao.UserDAOImpl;
import com.cg.oas.dto.User;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.utils.OasUtils;

public class UserServiceImpl implements UserService
{
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	UserDAO userDao = new UserDAOImpl();
	
	public User DeleteById(int userId)throws IdNotFoundException 
	{
		UserEntity userEntity=userDao.DeleteById(userId);
		logger.info("CategoryEntity: " + userEntity);
		return OasUtils.convertUserEntityIntoUser(userEntity);
	}
	
	
}
