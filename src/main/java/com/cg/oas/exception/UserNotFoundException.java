package com.cg.oas.exception;
@SuppressWarnings("serial")
public class UserNotFoundException extends Exception
{


	private String message;
	public UserNotFoundException()
	{
		this.message = "";
	}
	public UserNotFoundException(String message)
	{
		this.message = message;
	}
	@Override
	public String toString() 
	{
		return "User not found" + this.message;
	}
}
