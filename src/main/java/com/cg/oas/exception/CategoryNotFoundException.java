package com.cg.oas.exception;

@SuppressWarnings("serial")
public class CategoryNotFoundException  extends Exception
{


	private String message;
	public CategoryNotFoundException ()
	{
		this.message = "";
	}
	public CategoryNotFoundException (String message)
	{
		this.message = message;
	}
	@Override
	public String toString() 
	{
		return "User not found" + this.message;
	}
}

