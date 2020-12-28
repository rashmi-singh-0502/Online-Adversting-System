package com.cg.oas.service;

import java.util.List;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.dto.User;

public interface UserService
{

   public List<User> getAllUser() throws RecordNotFoundException;
   
   public User deleteById(int user_id) throws UserNotFoundException;
   
   public List<User> getUserByName(String name) throws UserNotFoundException;
   
   public List<User> deleteUser(String name) throws UserNotFoundException;
   
   public User getUserById(int user_id) throws UserNotFoundException;
   
 
}
