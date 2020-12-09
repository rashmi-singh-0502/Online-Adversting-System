package com.cg.oas.dao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.exceptions.InvalidDataFormatException;

public class AdDAOImpl implements AdDAO{

	private static Logger logger=LogManager.getFormatterLogger(AdDAOImpl.class.getName());
	private static EntityManager entityManager;
	

	public AdvertiseEntity postNewAdvertise(AdvertiseEntity adEntity) throws InvalidDataFormatException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
		
		if(AdDAOImpl.validateLetters(adEntity.getTitle())) 
		{
			if (AdDAOImpl.validateLetters(adEntity.getCategory())) 
			{
			
				if(AdDAOImpl.validateLetters(adEntity.getDescription()))
				{
				
					entityManager.getTransaction().begin();
					entityManager.persist(adEntity);
					entityManager.getTransaction().commit();

					
				}else {
					throw new InvalidDataFormatException("Invalid Description format [should be in format xyz]");
				}
				
			} else {
				throw new InvalidDataFormatException("Invalid category name [should contain only characters]");
			}
		}else {
			throw new InvalidDataFormatException("Invalid title name [should contain only characters]");
		}

		return null;
	}
	
	public static boolean validateLetters(String txt) {

		String regx = "^[a-zA-Z\\s]+$";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(txt);
		return matcher.find();

	}
}

