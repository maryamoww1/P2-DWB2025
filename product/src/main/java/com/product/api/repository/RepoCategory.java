package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;


@Repository
public interface RepoCategory extends JpaRepository<Category, Integer>{

	@Query(value ="SELECT * FROM category ORDER BY category", nativeQuery = true)
	List<Category> getCategories();

	@Query(value ="SELECT * FROM category WHERE status = 1 ORDER BY category", nativeQuery = true)
	List<Category> getActiveCategories();

	@Query(value ="SELECT * FROM category WHERE category_id = :category_id ORDER BY category", nativeQuery = true)
	Category getCategory(@Param("category_id") Integer category_id);
}
