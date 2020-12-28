package com.cg.oas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// --------------Declare the class as entity or table-----------------------
@Entity   
// -------------------Declare table name --------------------------
@Table(name="user", schema = "public")   

public class UserEntity
{

	@Id
	//-------------------AUTO GENERATING VALUE FOR ID---------------------------
	@GeneratedValue
	@Column(name="user_id")
	private int user_id;

	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String user_address;
	
	@Column(name="contact_no")
	private int user_contactno;
	
	@Column(name="email")
	private String user_email;
	

	/*
	 * -------------------------------creating constructors-------------------
	 */
	
	public UserEntity( int user_id,String name, String user_address, int user_contactno, String user_email) 
	{
		
		super();
		this.user_id = user_id;
		this.name = name;
		this.user_address = user_address;
		this.user_contactno = user_contactno;
		this.user_email = user_email;
		
	}

	public UserEntity( String name, String user_address, int user_contactno, String user_email) 
	{
		
		super();
		this.name = name;
		this.user_address = user_address;
		this.user_contactno = user_contactno;
		this.user_email = user_email;
		
	}

	public UserEntity()
	{
		super();
	}
	
	/*
	 * --------------------------Creating getter and setter----------------------
	 */
	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getUser_address() 
	{
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
    * --------------------------creating toString method------------------
    */
	@Override
	public String toString()
	{
		return "UserEntity [user_id=" + user_id + ", name=" + name + ", user_address=" + user_address
				+ ", user_contactno=" + user_contactno + ", user_email=" + user_email + "]";
	}
}
