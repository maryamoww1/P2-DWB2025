package com.customer.api.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.customer.api.entity.Category;


public interface SvcCategory {

	public ResponseEntity<List<Category>> getCategories();
	public List<Category> getActiveCategories();
	public Category getCategory(Integer id);
}
