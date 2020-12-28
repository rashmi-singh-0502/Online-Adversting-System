package com.cg.oas.exception;
@SuppressWarnings("serial")
public class RecordNotFoundException extends Exception
{


	private String message;
	public RecordNotFoundException()
	{
		this.message = "";
	}
	public RecordNotFoundException(String message)
	{
		this.message = message;
	}
	@Override
	public String toString() 
	{
		return "User not found" + this.message;
	}
}

