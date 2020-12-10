package com.cg.oas.exceptions;

public class AdvertiseNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AdvertiseNotFound() {
		this.message = "";
	}
	
	public AdvertiseNotFound(String message) {
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
