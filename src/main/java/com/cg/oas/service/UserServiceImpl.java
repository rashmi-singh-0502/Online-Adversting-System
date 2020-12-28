package com.cg.oas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entity.UserEntity;
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.repo.UserRepo;
import com.cg.oas.dto.User;

/*
 * --------------------------CREATING CLASS AS SERVICE---------------------
 */
@Service
public class UserServiceImpl implements UserService
{
	/*
	 * -----------------------------AUTOWIRING REPO CLASS-------------------------
	 */
	@Autowired 
	private UserRepo userRepo;
	
	/*
	 * ---------------------DISPLAYING ALL USERS------------------------------
	 */

	@Override
	public List<User> getAllUser()  throws RecordNotFoundException
	{
		List<UserEntity> userEntityList = userRepo.findAll();
		if(!userEntityList.isEmpty())
		{
		List<User> users = new ArrayList<User>();
		for(UserEntity userEntity: userEntityList) 
		{
			users.add(new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email()));
		}
		
		return users;
	    }
	   else
	    {
		throw new RecordNotFoundException("NO RECORD FOUND");
		
	   }
	} 
	
	/*
	 * -------------------------GETTING USER BY ID------------------------
	 */
	@Override
	public User getUserById(int user_id) throws UserNotFoundException
    {
		Optional<UserEntity> opUserEntity = Optional.ofNullable(userRepo.findById(user_id));
		if(opUserEntity.isPresent()) 
		{
			UserEntity userEntity = opUserEntity.get();
			return new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email());
		}
		else 
		{
			throw new UserNotFoundException("userid" + user_id);
		}
		
	}
	
	/*
	 *---------------------- DELETING USER BY ID-------------------------
	 */
	@Override
	public User deleteById(int user_id) throws UserNotFoundException
	{
		Optional<UserEntity> opUserEntity = Optional.ofNullable(userRepo.findById(user_id));
		if(opUserEntity.isPresent())
		{
			UserEntity userEntity = opUserEntity.get();
			userRepo.deleteById(user_id);
			return new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
						userEntity.getUser_email());
			
		}
		else 
		{
			throw new UserNotFoundException();
		}
	}
	
	/*
	 * ----------------------GETTING A USER BY ITS NAME----------------------          
	 */
	
	public List<User> getUserByName(String name) throws UserNotFoundException {
		List<UserEntity> userEntityList = userRepo.findByName(name);
		if(!userEntityList.isEmpty())
		{
		List<User> users = new ArrayList<User>();
		for(UserEntity userEntity: userEntityList) 
		{
			users.add(new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email()));		
		}
		return users;
	  }
	   else
	   {
		 throw new UserNotFoundException(name);
	
	   }
	}
	/*
	 * -----------------------------DELETING A USER BY ITS NAME--------------------
	 */
	@Override
	public List<User> deleteUser(String name) throws UserNotFoundException 
	{
		List<UserEntity> userEntityList= userRepo.findByName(name);
		if(!userEntityList.isEmpty())
		 {
			List<User> users = new ArrayList<User>();
		   for(UserEntity userEntity: userEntityList)
		     {
			     users.add(new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email()));
		
			   userRepo.delete(userEntity);
		     }
		  return users;
	   }
	  else
	   {
		throw new UserNotFoundException(name);
	
	   }
	}
	          
}
	

