package com.cg.oas.dto;

public class SendMessage {
	
	private int message_id;
	private String message;
	private String sender_username;
	
	public SendMessage(int message_id, String message, String sender_username) {
		super();
		this.message_id = message_id;
		this.message = message;
		this.sender_username = sender_username;
	}

	public SendMessage(String message, String sender_username) {
		super();
		this.message = message;
		this.sender_username = sender_username;
	}

	public SendMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender_username() {
		return sender_username;
	}

	public void setSender_username(String sender_username) {
		this.sender_username = sender_username;
	}

	@Override
	public String toString() {
		return "SendMessage [message_id=" + message_id + ", message=" + message + ", sender_username=" + sender_username
				+ "]";
	}
	
	
	

}
