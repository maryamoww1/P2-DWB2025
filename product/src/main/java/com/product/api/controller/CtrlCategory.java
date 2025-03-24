package com.customer.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.entity.Category;
import com.customer.api.service.SvcCategory;

@RestController
@RequestMapping("/category")
public class CtrlCategory {
	
	@Autowired
	SvcCategory svc;

	@GetMapping
	public List<Category> getCategories(){
		return svc.getCategories();
	}

	@GetMapping("/active")
	public List<Category> getActiveCategories(){
		return svc.getActiveCategories();
	}

	@GetMapping("/{category_id}")
	public Category getCategory(@PathVariable Integer category_id){
		return svc.getCategory(category_id);
	}
}
