package com.jpa.advertiseapp.utils;


import com.jpa.advertiseapp.dto.User;
import com.jpa.advertiseapp.entity.UserEntity;

public class UserAddUtils {
	public static UserEntity convertUserIntoUserEntity(User user) {
		return new UserEntity(user.getId(), user.getName(), user.getAddress(),user.getContact_no(),user.getEmail());
	}
	public static User convertUserEntityIntoUser(UserEntity userEntity) {
		return new User(userEntity.getId(), userEntity.getName(), userEntity.getAddress(),userEntity.getContact_no(),userEntity.getEmail());
	}

}
