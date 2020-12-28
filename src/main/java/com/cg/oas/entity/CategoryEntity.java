package com.cg.oas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//-------------Declare the class as entity or table----------------
@Entity 
// ------------Declare table name----------------------- 	
@Table(name="category", schema = "public")  

	public class CategoryEntity
	{
		@Id
	  //-------------auto-generating value for id--------------
		@GeneratedValue 
		@Column(name="category_id")
		private int category_id;

		@Column(name="name")
		private String name;
		
		@Column(name="category_desc")
		private String category_desc;
		
		/*
		*-------------------------Creating constructors-------------------
		*
		*/
		public CategoryEntity() 
		{
			super();
		}
		public CategoryEntity(int category_id,String name, String category_desc)
		{
			super();
			this.category_id=category_id;
			this.name = name;
			this.category_desc = category_desc;
			
		}

		public CategoryEntity( String name, String category_desc)
		{
			super();
			this.name = name;
			this.category_desc = category_desc;
		}
		
		
		/*
		 * ---------------------------creating getters and setters---------------------
		 */	


		public int getCategory_id() 
		{
			return category_id;
		}

		public void setCategory_id(int category_id)
		{
			this.category_id = category_id;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getCategory_desc() 
		{
			return category_desc;
		}

		public void setCategory_desc(String category_desc)
		{
			this.category_desc = category_desc;
		}
	
       /* 
        * -----------------------------Creating toString method---------------------
        */
		@Override
		public String toString() 
		{
			return "CategoryEntity [category_id=" + category_id + ", name=" + name
					+ ", category_desc=" + category_desc + "]";
		}
		
	}

