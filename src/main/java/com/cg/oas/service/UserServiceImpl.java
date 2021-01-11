package com.cg.oas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entity.UserEntity;
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.repo.AdvertiseRepo;
import com.cg.oas.repo.UserRepo;
import com.cg.oas.entity.AdvertiseEntity;
import com.cg.oas.dto.Advertise;
import com.cg.oas.util.AdvertiseUtil;
import com.cg.oas.util.UserUtil;
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
	private AdvertiseRepo advertiseRepo;
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());
	
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
			logger.info("getAllUser:"+" "+ userEntity);
			users.add(new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email()));
		}
		
		return users;
	    }
	   else
	    {
		   logger.error("getAllUser: No User exists" );
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
			logger.info("getUserById:Getting User of id="+ user_id+" " +userEntity);
			return new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email());
		}
		else 
		{
			logger.error("getUserById: UserId="+ user_id+" "+" does not exists" );
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
			logger.info("deleteUserById: user with user_id="+user_id+" "+"is deleted"+" "+ userEntity);
			userRepo.deleteById(user_id);
			return new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
						userEntity.getUser_email());
			
		}
		else 
		{
			logger.error("DeleteUserById: User with user_id="+user_id+" "+"does not exists" );
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
			logger.info("getUserByName: User with user_name="+name+" "+"is displayed" +" "+ userEntity);
			users.add(new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email()));		
		}
		return users;
	  }
	   else
	   {
		   logger.error("getUserByName: UserName with name="+name+" "+"does not exists" );
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
			   logger.info("deleteUserByName:User with name="+name+" "+"is deleted" +" "+ userEntity);
			     users.add(new User(userEntity.getUser_id(), userEntity.getName(), userEntity.getUser_address(),userEntity.getUser_contactno(),
					userEntity.getUser_email()));
		
			   userRepo.delete(userEntity);
		     }
		  return users;
	   }
	  else
	   {
		  logger.error("DeleteUserByName: User with name="+name+" " +" does not exists" );
		  throw new UserNotFoundException(name);
	
	   }
	}
	@Override
	public Advertise createNewAdvertise(Advertise advertise) { //Method to post new advertise
		Optional<UserEntity> userOptional = Optional.ofNullable(userRepo.findById(advertise.getUser().getUser_id()));
		if(userOptional.isPresent()) {
			UserEntity userEntity = userOptional.get();
			AdvertiseEntity advertiseEntity = 
			advertiseRepo.save(UserUtil.convertAdvertiseIntoAdvertiseEntity(advertise, userEntity));
			return UserUtil.convertAdvertiseEntityIntoAdvertise(advertiseEntity);
		}
		return null;
	}
	@Override
	public List<Advertise> getAllAdvertises() { //Method to get all posted advertises
		List<AdvertiseEntity> advertiseEntityList = advertiseRepo.findAll();
		List<Advertise> advertise = new ArrayList<Advertise>();
		for(AdvertiseEntity advertiseEntity: advertiseEntityList) {
			//double user = new User(advertiseEntity.getUser().getUserId(), advertiseEntity.getUser().getName());
			advertise.add(new Advertise(advertiseEntity.getAd_id(), advertiseEntity.getDescription(), advertiseEntity.getTitle(), 0));
		}
		return advertise;
	}
	@Override
	public List<User> getAllUsers() {		//Method to get all users who posted the advertises
		List<UserEntity> userEntityList = userRepo.findAll();
		List<User> user = new ArrayList<User>();
		for(UserEntity userEntity: userEntityList) {
			user.add(new User(userEntity.getUser_id(), userEntity.getName(), null, 0, null));
		}
		return user;
		
	}

	          
}
	

