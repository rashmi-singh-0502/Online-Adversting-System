package com.cg.oas.service;

import java.util.List;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.dto.Advertise;
import com.cg.oas.dto.User;

public interface UserService
{

   public List<User> getAllUser() throws RecordNotFoundException;
   
   public User deleteById(int user_id) throws UserNotFoundException;
   
   public List<User> getUserByName(String name) throws UserNotFoundException;
   
   public List<User> deleteUser(String name) throws UserNotFoundException;
   
   public User getUserById(int user_id) throws UserNotFoundException;
   
   //Method to post new Advertise
 	public Advertise createNewAdvertise(Advertise advertise);
 	
 	//Method to get all users who posted the advertises
 	public List<User> getAllUsers();
 	
 	//Method to get all advertises
 	public List<Advertise> getAllAdvertises();
}
