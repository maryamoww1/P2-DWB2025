package com.customer.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.api.entity.Category;

/**
 * Repositorio para la gestión de la entidad Category.
 * Proporciona métodos para acceder a la base de datos mediante consultas SQL.
 */
@Repository
public interface RepoCategory extends JpaRepository<Category, Integer> {

    /**
     * Obtiene la lista de todas las categorías ordenadas por nombre.
     * 
     * @return Lista de categorías.
     */
    @Query(value ="SELECT * FROM category ORDER BY category", nativeQuery = true)
    List<Category> getCategories();

    /**
     * Obtiene la lista de categorías activas ordenadas por nombre.
     * 
     * @return Lista de categorías con estado activo.
     */
    @Query(value ="SELECT * FROM category WHERE status = 1 ORDER BY category", nativeQuery = true)
    List<Category> getActiveCategories();

    /**
     * Obtiene una categoría específica según su ID.
     * 
     * @param category_id Identificador único de la categoría.
     * @return Categoría correspondiente al ID proporcionado.
     */
    @Query(value ="SELECT * FROM category WHERE category_id = :category_id ORDER BY category", nativeQuery = true)
    Category getCategory(@Param("category_id") Integer category_id);
}
