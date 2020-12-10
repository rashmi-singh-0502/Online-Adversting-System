package com.cg.oas.exceptions;

public class SenderIdNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public SenderIdNotFound() {
		this.message = "";
	}
	
	public SenderIdNotFound(String message) {
		this.message = message;
		
	}

	@Override
	public String toString() {
		return "Message not sent" + this.message;
	}

}
