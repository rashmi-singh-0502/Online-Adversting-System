package com.cg.oas.exceptions;

public class UserAddNotFoundException extends Exception{

	private String message;

	public UserAddNotFoundException() {
		super();
		this.message="";
	}

	public UserAddNotFoundException(String message) {
		
		this.message = message;
	}
	@Override
	public String toString()
	{
		return "Advertise not found " + this.message;
	}

}
