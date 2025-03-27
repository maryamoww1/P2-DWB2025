package com.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.api.entity.Product;

@Repository
public interface RepoProduct extends JpaRepository<Product, Integer> {

}
