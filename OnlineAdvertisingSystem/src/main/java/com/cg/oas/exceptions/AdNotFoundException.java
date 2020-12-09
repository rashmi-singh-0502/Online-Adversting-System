package com.cg.oas.exceptions;

public class AdNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AdNotFoundException() {
		this.message = "";
	}
	
	public AdNotFoundException(String message) {
		this.message = message;
		
	}

	public  void AdFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Search Unsuccessful" + this.message;
	}
}
