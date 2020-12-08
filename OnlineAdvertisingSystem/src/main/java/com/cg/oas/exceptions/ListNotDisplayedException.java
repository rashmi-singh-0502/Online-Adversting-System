package com.cg.oas.exceptions;

public class ListNotDisplayedException extends Exception
{   
	private String message;
	
	public ListNotDisplayedException()
	{
		this.message = "";
		
	}
	public ListNotDisplayedException(String message) 
	{
		 this.message = message;
	}
	@Override
	public String toString() {
		return "Name cannot be Empty" + this.message;
	}

}
