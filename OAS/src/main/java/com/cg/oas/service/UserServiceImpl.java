package com.cg.oas.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.dao.UserDAO;
import com.cg.oas.dao.UserDAOImpl;
import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.User;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.InvalidUserFormatException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.UserAddNotFoundException;
import com.cg.oas.exceptions.UserIdNotFoundException;
import com.cg.oas.utils.OasUtils;
import com.cg.oas.service.UserServiceImpl;

public class UserServiceImpl implements UserService
{
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	UserDAO userDao = new UserDAOImpl();
	
	List<Advertise> advertise;
	
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
	
public User findById(int userid) throws UserIdNotFoundException {
		
		
		
		UserEntity userEntity = userDao.findById(userid);
		logger.info("Entity: " + userEntity);
		return OasUtils.convertUserEntityIntoUser(userEntity);
	}
	
	
	
	public List<Advertise> viewAllAdvertise() throws UserAddNotFoundException {

		List<AdvertiseEntity> entities=userDao.viewAllAdvertise();
		logger.info("All Database Entries are:");
		advertise=OasUtils.convertAdvertiseEntityListToAdvertise(entities);
		
		return advertise;
	}
	
	
	public User addData(UserEntity adEntity) throws InvalidUserFormatException
	{
			
			UserEntity adEntity1=userDao.registerNewUser(adEntity);
			return OasUtils.convertUserEntityIntoUser(adEntity1);
		
	}
	
	
	
}
