package com.cg.oas.dao;
import java.util.List;

import com.cg.oas.entity.UserEntity;
import com.cg.oas.exceptions.IdNotFoundException;

public interface UserDAO 
{    
	public  List<UserEntity> viewUser();
	
	
	UserEntity DeleteById(int userId) throws IdNotFoundException;
	

}
