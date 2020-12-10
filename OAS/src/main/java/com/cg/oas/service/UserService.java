package com.cg.oas.service;

import java.util.List;

import com.cg.oas.dto.User;
import com.cg.oas.exceptions.IdNotFoundException;
import com.cg.oas.exceptions.ListNotDisplayedException;

public interface UserService

{

	public List<User> viewAllUsers() throws ListNotDisplayedException;
	
		User DeleteById(int user_id) throws IdNotFoundException;
}
