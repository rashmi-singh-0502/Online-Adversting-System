package com.cg.oas.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.oas.entity.CategoryEntity;

/*
 * ------------------EXTENDING JPA REPOSITORY-------------------
 */

public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer>
{
	public CategoryEntity findById(int category_id);
   List<CategoryEntity> findByName(String name);
   
}
