package com.cg.oas.service;

import java.util.List;

import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.User;

import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.UserAddNotFoundException;
import com.cg.oas.exceptions.UserIdNotFoundException;

public interface UserService

{

	public List<User> viewAllUsers() throws ListNotDisplayedException;
	
		User DeleteById(int user_id) throws IdNotFoundException;
		
		
		User findById(int userid) throws UserIdNotFoundException;

		public List<Advertise> viewAllAdvertise() throws UserAddNotFoundException;
	    
		
		
		
		
		
		
		
		
		
}
