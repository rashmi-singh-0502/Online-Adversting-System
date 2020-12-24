package com.cg.oas.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//Declare the class as entity or table
@Entity 
// Declare table name 	
@Table(name="category", schema = "public")                                                                
	public class CategoryEntity
	{
		@Id
		@GeneratedValue     //auto-generating value for id
		@Column(name="category_id")
		private long category_id;

		@Column(name="category_name")
		private String category_name;
		
		@Column(name="category_desc")
		private String category_desc;
		
		@OneToMany(cascade={CascadeType.ALL}, 
				fetch=FetchType.EAGER, mappedBy = "category")
		private Set<AdvertiseEntity> advertises;
		/*
		*Creating constructors
		*
		*/
		public CategoryEntity(long category_id,String category_name, String category_desc,Set<AdvertiseEntity> advertises)
		{
			super();
			this.category_id=category_id;
			this.category_name = category_name;
			this.category_desc = category_desc;
			this.advertises = advertises;
			
		}

		public CategoryEntity(String category_name, String category_desc,Set<AdvertiseEntity> advertises)
		{
			super();
			this.category_name = category_name;
			this.category_desc = category_desc;
			this.advertises = advertises;
		}

		
		public CategoryEntity() 
		{
			super();
		}

		/*
		 * creating getters and setters
		 */	


		public long getCategory_id() 
		{
			return category_id;
		}

		public void setCategory_id(long category_id)
		{
			this.category_id = category_id;
		}

		public String getCategory_name() 
		{
			return category_name;
		}

		public void setCategory_name(String category_name)
		{
			this.category_name = category_name;
		}

		public String getCategory_desc() 
		{
			return category_desc;
		}

		public void setCategory_desc(String category_desc)
		{
			this.category_desc = category_desc;
		}
		public Set<AdvertiseEntity> getAdvertises() {
			return advertises;
		}

		public void setAdvertises(Set<AdvertiseEntity> advertises) {
			this.advertises = advertises;
		}
       /*
        * 
        * Creating toString method
        */

		@Override
		public String toString() {
			return "CategoryEntity [category_id=" + category_id + ", category_name=" + category_name
					+ ", category_desc=" + category_desc + ", advertises=" + advertises + "]";
		}
	}

