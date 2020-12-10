package com.cg.oas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class SendMessageEntity {
	
	@Id
	@GeneratedValue
	@Column(name="message_id")
	private int message_id;
	
	@Column(name="message")
	private String message;
	
	@Column(name="sender_username")
	private String sender_username;

	public SendMessageEntity(int message_id, String message, String sender_username) {
		super();
		this.message_id = message_id;
		this.message = message;
		this.sender_username = sender_username;
	}

	public SendMessageEntity(String message, String sender_username) {
		super();
		this.message = message;
		this.sender_username = sender_username;
	}

	public SendMessageEntity() {
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
		return "SendMessageEntity [message_id=" + message_id + ", message=" + message + ", sender_username="
				+ sender_username + "]";
	}
	
	
	
	
	

}
