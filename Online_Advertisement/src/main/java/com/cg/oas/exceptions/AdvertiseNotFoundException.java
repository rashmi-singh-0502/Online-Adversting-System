package com.cg.oas.exceptions;

public class AdvertiseNotFoundException extends Exception {
	private String message;
	
	public AdvertiseNotFoundException() {
		this.message = "";
	}
	public AdvertiseNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Advertise not found " + this.message;
	}
}
