package com.customer.api.service;

import com.customer.api.entity.Category;
import java.util.List;

/**
 * Servicio para la gestión de categorías.
 * Define las operaciones disponibles para obtener información de las categorías.
 */
public interface SvcCategory {

    /**
     * Obtiene la lista de todas las categorías.
     * 
     * @return Lista de todas las categorías.
     */
    public List<Category> getCategories();

    /**
     * Obtiene la lista de categorías activas.
     * 
     * @return Lista de categorías con estado activo.
     */
    public List<Category> getActiveCategories();

    /**
     * Obtiene una categoría específica según su ID.
     * 
     * @param id Identificador único de la categoría.
     * @return Categoría correspondiente al ID proporcionado.
     */
    public Category getCategory(Integer id);
}
