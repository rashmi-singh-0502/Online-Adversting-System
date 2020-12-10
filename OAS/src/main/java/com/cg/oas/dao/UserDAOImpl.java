package com.cg.oas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.ListNotDisplayedException;


public class UserDAOImpl implements UserDAO
{
	private static Logger logger = LogManager.getLogger(UserDAOImpl.class.getName());	
	private static EntityManager entityManager;

	
	static
	  {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
	  entityManager.getTransaction().begin();
		 
	  }
	/*
	 * Creating List for users
	 * 
	 */

public List<UserEntity> viewAllUsers() throws ListNotDisplayedException {
		
		List<UserEntity> list;
		Query query = entityManager.createQuery("SELECT users from UserEntity users");
		list = query.getResultList();

		if(list==null)
			throw new ListNotDisplayedException("No Entry in Database");
		
		return list;
	}
/*
 * This method delete user by id if exists
 * 
 */
	public UserEntity DeleteById(int user_id) throws IdNotFoundException
	{
		UserEntity userEntity=entityManager.find(UserEntity.class,user_id);
		if(userEntity!=null)
		{
			entityManager.remove(userEntity);
			
		}
		
		entityManager.getTransaction().commit();
		logger.info("Database deleted user: " + userEntity);
		if(userEntity==null)
			throw new IdNotFoundException("UserId: " + user_id);
		return userEntity;
	}
	
	
}