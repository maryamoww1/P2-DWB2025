package com.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.api.entity.Category;

@Repository
public interface RepoCategory extends JpaRepository<Category, Integer> {

}
