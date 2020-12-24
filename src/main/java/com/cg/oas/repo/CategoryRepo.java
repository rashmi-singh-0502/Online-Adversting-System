package com.cg.oas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oas.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long>{

}
