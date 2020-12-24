package com.cg.oas.testdto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Category 
	{
		@Min(value=1)
			private long category_id;
		
		@NotBlank
		@NotNull
			private String category_name;
		
		@NotBlank
		@NotNull
			private String category_desc;
			/* 
			 * Creating constructors
			 * 
			 */
			
			public Category(long category_id, String category_name, String category_desc) 
			{
				super();
				this.category_id = category_id;
				this.category_name = category_name;
				this.category_desc = category_desc;
			}
			public Category( String category_name, String category_desc) 
			{
				super();
				
				this.category_name = category_name;
				this.category_desc = category_desc;
			}
			
			public Category()
			{
				super();
			}
			/*
			 * Creating Getters and Setter method
			 * 
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
			/*
			 * Creating toString function
			 * 
			 */
			@Override
			public String toString()
			{
				return "Category [category_id=" + category_id + ", category_name=" + category_name + ", category_desc="
						+ category_desc + "]";
			}
			
		}
