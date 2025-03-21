package com.customer.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.api.repository.RepoCategory;
import com.customer.api.entity.Category;


@Service
public class SvcCategoryImp implements SvcCategory {
	
	@Autowired
	RepoCategory repo;

	@Override
	public List<Category> getCategories() {
		return repo.getCategories();
	}

	@Override
	public List<Category> getActiveCategories() {
		return repo.getActiveCategories();
	}

	@Override
	public Category getCategory(Integer id) {
		try {
			Category category = repo.getCategory(id);
			if(category == null) {
				throw new Exception("No existe la categoría");
			}
			return category;
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
