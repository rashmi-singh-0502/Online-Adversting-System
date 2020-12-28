package com.cg.oas.testdto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

public class User
{ 

    /*
     *---------------- ID SHOULD BE GREATER OR EQUAL TO 1-------------
    */
	@Min(value=1)
	@ApiModelProperty(value="User Id")
	private int user_id;
	
	 /*
     * --------------NAME SHOULD NOT BE NULL OR BLANK-----------------
     */
	@NotBlank
    @NotNull
    @ApiModelProperty(value="User Name")
	private String name;
	
	 /*
     * --------------ADDRESS SHOULD NOT BE NULL OR BLANK--------------
     */
	@NotBlank
    @NotNull
    @ApiModelProperty(value="User Address")
	private String user_address;
	
	 /*
     * --------------CONTACT NUMBER SHOULD NOT BE NULL OR BLANK--------------
     */
	@NotBlank
    @NotNull
    @ApiModelProperty(value="User contact number")
	private int user_contactno;
	
	 /*
     * --------------EMAILID SHOULD NOT BE NULL OR BLANK-------------------
     */
	@NotBlank
    @NotNull
    @ApiModelProperty(value="User emailid")
	
	private String user_email;

	/*
	 * ----------------Creating constructors------------------------
	 * 
	 */
	public User( int user_id,String name, String user_address, int user_contactno, String user_email) 
	{
		super();
		this.user_id=user_id;
		this.name = name;
		this.user_address = user_address;
		this.user_contactno = user_contactno;
		this.user_email = user_email;
	}
	public User( String name, String user_address, int user_contactno, String user_email) 
	{
		super();
		this.name = name;
		this.user_address = user_address;
		this.user_contactno = user_contactno;
		this.user_email = user_email;
	}
	
	public User() 
	{
		super();
	}
	
	/* 
	 * -------------------------Creating getter and setter function-------------------
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
	 * -------------------------------Creating toString function--------------------
	 * 
	 */
	@Override
	public String toString() 
	{
		return "User [user_id=" + user_id + ", name=" + name + ", user_address=" + user_address
				+ ", user_contactno=" + user_contactno + ", user_email=" + user_email + "]";
	}	
}
