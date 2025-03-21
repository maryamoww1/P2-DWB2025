package com.customer.api.service;
import com.customer.api.entity.Category;

import java.util.List;


public interface SvcCategory {

	public List<Category> getCategories();
	public List<Category> getActiveCategories();
	public Category getCategory(Integer id);
}
