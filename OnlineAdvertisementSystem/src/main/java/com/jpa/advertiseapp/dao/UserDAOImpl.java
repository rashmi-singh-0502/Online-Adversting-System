package com.jpa.advertiseapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jpa.advertiseapp.entity.UserEntity;
import com.jpa.advertiseapp.exceptions.UserNotFoundException;
import com.jpa.advertiseapp.service.UserServiceImpl;
public class UserDAOImpl implements UserDAO
{
	private static Logger logger = LogManager.getLogger(RegisterUserDAOImpl.class.getName());	
	private static EntityManager entityManager;
	
	static {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ShopCartAppPU");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public UserEntity findByName(String name) throws UserNotFoundException {
		UserEntity userEntity = entityManager.find(UserEntity.class, name);
		if(userEntity==null)
			throw new UserNotFoundException("Name: " + name+"not found");
		return userEntity;
	}

}


