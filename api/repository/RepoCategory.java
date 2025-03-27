package com.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.api.entity.Category;

/**
 * Repositorio para la gestión de la entidad Category.
 * Extiende JpaRepository para proporcionar operaciones CRUD sobre la tabla de categorías.
 */
@Repository
public interface RepoCategory extends JpaRepository<Category, Integer> {
}
