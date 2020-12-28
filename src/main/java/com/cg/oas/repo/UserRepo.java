package com.cg.oas.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oas.entity.UserEntity;

/*
 * ------------------EXTEDNING JPA REPOSITORY------------------------
 */
public interface UserRepo extends JpaRepository<UserEntity, Integer>
{
	public UserEntity findById(int user_id);
	List<UserEntity> findByName(String name);
}
