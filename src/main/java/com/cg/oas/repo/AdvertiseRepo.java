package com.cg.oas.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.oas.entity.AdvertiseEntity;

public interface AdvertiseRepo extends JpaRepository<AdvertiseEntity, Long>{

//	@Query("SELECT a FROM AdvertiseEntity a WHERE a.title = :title")
//	public List<AdvertiseEntity> findByTitleRead(@Param("title")String title);
	
	@Query("SELECT a FROM AdvertiseEntity a WHERE a.title = :title")
	public Optional<AdvertiseEntity> findByTitleRead(@Param("title")String title);

	@Query("SELECT a FROM AdvertiseEntity a WHERE a.title = :title")
	public Optional<AdvertiseEntity> findByTitleEdit(@Param("title")String title);
}
