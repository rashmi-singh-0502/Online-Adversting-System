package com.cg.oas.exceptions;

public class IdNotFoundException extends Exception
{

	private String message;
	
	public IdNotFoundException()
	{
		this.message = "";
	}
	public IdNotFoundException(String message)
	{
		this.message = message;
	}
	@Override
	public String toString() 
	{
		return "Id not found" + this.message;
	}
}
