package com.cg.oas.dao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.InvalidUserFormatException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.UserAddNotFoundException;
import com.cg.oas.exceptions.UserIdNotFoundException;


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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public UserEntity findById(int userid) throws UserIdNotFoundException{
		
		UserEntity UserEntity=entityManager.find(UserEntity.class, userid);
		if (UserEntity == null) {
			throw new UserIdNotFoundException("userid  "+userid+"not found");
		}
		return UserEntity;
		
	}
	
	
	
public List<AdvertiseEntity> viewAllAdvertise() throws UserAddNotFoundException {
		
		List<AdvertiseEntity> list;
		Query query = entityManager.createQuery("SELECT advertise from AdvertiseEntity advertise");
		list = query.getResultList();

		if(list==null)
			throw new UserAddNotFoundException("No Entry in Database");
		
		return list;
	}
	
	
public UserEntity registerNewUser(UserEntity regEntity) throws InvalidUserFormatException {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
	entityManager = entityManagerFactory.createEntityManager();
	
	//check for user name
	if(UserDAOImpl.validateLetters(regEntity.getUser_name())) 
	{
		//check for user address
		if (UserDAOImpl.validateLetters(regEntity.getUser_address())) 
		{
			//check for email
			if(UserDAOImpl.isValidEmail(regEntity.getUser_email()))
			{
			
				entityManager.getTransaction().begin();
				entityManager.persist(regEntity);
				entityManager.getTransaction().commit();

				
			}
			else 
			{
				throw new InvalidUserFormatException("Invalid Name format [should be in format xyz]");
			}
			
		} 
		else 
		{
			throw new InvalidUserFormatException("Invalid Address Format[should contain only characters]");
		}
	}else {
		throw new InvalidUserFormatException("Invalid Email Format [should contain only characters]");
	}

	return null;
}

public static boolean validateLetters(String txt) {

	String regx = "^[a-zA-Z\\s]+$";
	Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
	Matcher matcher = pattern.matcher(txt);
	return matcher.find();

}
public static boolean isValidEmail(String email) {
	String emailRegex = "^[a-zA-Z0-9_+&*1-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$";

	Pattern pat = Pattern.compile(emailRegex);
	if (email == null)
		return false;
	return pat.matcher(email).matches();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}