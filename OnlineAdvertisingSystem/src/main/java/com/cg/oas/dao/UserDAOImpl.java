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
	public List<UserEntity> viewUser()
	{
        entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("Select c from UserEntity c");
		@SuppressWarnings("unchecked")
		List<UserEntity> list=(List<UserEntity>)query.getResultList();
		//entityManager.getTransaction().commit();
		logger.info("User is displayed");
		return list;
				
	}
	public UserEntity DeleteById(int userId) throws IdNotFoundException
	{
		UserEntity userEntity=entityManager.find(UserEntity.class,userId);
		
		entityManager.remove(userEntity);
		entityManager.getTransaction().commit();
		logger.info("Database deleted user: " + userEntity);
		if(userEntity==null)
			throw new IdNotFoundException("UserId: " + userId);
		return userEntity;
		
		
	}
}