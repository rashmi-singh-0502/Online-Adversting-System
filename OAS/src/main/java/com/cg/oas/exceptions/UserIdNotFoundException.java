package com.cg.oas.exceptions;

public class UserIdNotFoundException extends Exception{

	private String message;

	public UserIdNotFoundException() {
		super();
		this.message="";
	}

	public UserIdNotFoundException(String message) {
		
		this.message = message;
	}
	@Override
	public String toString()
	{
		return "Item not found " + this.message;
	}
}