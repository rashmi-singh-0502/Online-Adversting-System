package com.cg.oas.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exceptions.NameIsBlankException;


public class CategoryDAOImpl implements CategoryDAO
{
	private static Logger logger = LogManager.getLogger(CategoryDAOImpl.class.getName());	
	private static EntityManager entityManager;

	static
	  {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OnlineAdvertisePU");
		entityManager = entityManagerFactory.createEntityManager();
	  }
	
	/*
	 * This method adds entity to Candidate table
	 */
	
	public CategoryEntity addCategory(CategoryEntity entity) 
	{
		
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		logger.info("Category with Name" + entity.getCategory_name()+ "is added");
		return entity;
		
	}
	
	/*
	 * This method checks name is null or not
	 * 
	 */
	
	public CategoryEntity checkName(String categoryName) throws NameIsBlankException 
	{
		
		String jpql = "SELECT category FROM CategoryEntity category where category.category_name=:pname";
		TypedQuery<CategoryEntity> query = entityManager.createQuery(jpql, CategoryEntity.class);
		query.setParameter("pname", categoryName);
		query.setMaxResults(1);
		CategoryEntity entity = query.getSingleResult();
		if (entity== null) 
		{
			throw new NameIsBlankException("Name not found");
			
			
		}
		
		return entity;
		
	}




}
