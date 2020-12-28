package com.cg.oas.testdto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Category 
	{
	        /*
	         *---------------- ID SHOULD BE GREATER OR EQUAL TO 1-------------
	         */
		    @Min(value=1)
		    @ApiModelProperty(value="Category Id")
			private int category_id;
		    
		    /*
		     * --------------NAME SHOULD NOT BE NULL OR BLANK--------------
		     */
		    @NotBlank
		    @NotNull
		    @ApiModelProperty(value=" Category Name")
			private String name;
		    
		    /*
		     * --------------DESCRIPTION SHOULD NOT BE NULL OR BLANK--------------
		     */
		    @NotNull
		    @NotBlank
		    @ApiModelProperty(value="Category Description")
			private String category_desc;
		  
			/* 
			 * ------------Creating constructors-------------
			 * 
			 */
			
			public Category(int category_id, String name, String category_desc) 
			{
				super();
				this.category_id = category_id;
				this.name = name;
				this.category_desc = category_desc;
			}
			public Category( String name, String category_desc) 
			{
				super();
				
				this.name = name;
				this.category_desc = category_desc;
			}
			
			
			public Category()
			{
				super();
			}
			
			/*
			 * ---------------Creating Getters and Setter method----------------
			 * 
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
			 *---------------------Creating toString function--------------------
			 * 
			 */
			@Override
			public String toString()
			{
				return "Category [category_id=" + category_id + ", name=" + name + ", category_desc="
						+ category_desc + "]";
			}
		}
