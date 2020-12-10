package com.cg.oas.dto;

public class User
{
	private int user_id;
	private String user_name;
	private String user_address;
	private int user_contactno;
	private String user_email;
	
	/*
	 * Creating constructors
	 * 
	 */
	public User( int user_id,String user_name, String user_address, int user_contactno, String user_email) 
	{
		super();
		this.user_id=user_id;
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_contactno = user_contactno;
		this.user_email = user_email;
	}
	public User( String user_name, String user_address, int user_contactno, String user_email) 
	{
		super();
		this.user_name = user_name;
		this.user_address = user_address;
		this.user_contactno = user_contactno;
		this.user_email = user_email;
	}
	public User() 
	{
		super();
	}
	/*
	 * 
	 * Creating getter and setter function
	 */
	
	public int getUser_id() 
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public String getUser_name() 
	{
		return user_name;
	}
	public void setUser_name(String user_name) 
	{
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) 
	{
		this.user_address = user_address;
	}
	public int getUser_contactno() 
	{
		return user_contactno;
	}
	public void setUser_contactno(int user_contactno) 
	{
		this.user_contactno = user_contactno;
	}
	public String getUser_email() 
	{
		return user_email;
	}
	public void setUser_email(String user_email)
	{
		this.user_email = user_email;
	}
	/*
	 * 
	 * Creating toString function
	 * 
	 */
	@Override
	public String toString() 
	{
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_address=" + user_address
				+ ", user_contactno=" + user_contactno + ", user_email=" + user_email + "]";
	}
	
	
}
