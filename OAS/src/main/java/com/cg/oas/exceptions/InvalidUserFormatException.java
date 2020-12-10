package com.cg.oas.exceptions;

public class InvalidUserFormatException extends Exception
{
	private String message;
	
	public InvalidUserFormatException() {
		this.message="";
	}

	public InvalidUserFormatException(String message) {
		super();
		this.message = message;
	}
	

}
