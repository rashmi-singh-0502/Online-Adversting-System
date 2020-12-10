package com.cg.oas.dao;
import java.util.List;
import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.ListNotDisplayedException;
import com.cg.oas.exceptions.IdNotFoundException;

public interface UserDAO 
{    
	
	List<UserEntity> viewAllUsers() throws ListNotDisplayedException;
	UserEntity DeleteById(int user_id) throws IdNotFoundException;
	

}
