package com.customer.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.api.repository.RepoCategory;
import com.customer.api.entity.Category;

/**
 * Implementación del servicio para la gestión de categorías.
 * Proporciona métodos para obtener todas las categorías, las activas y una específica por su ID.
 */
@Service
public class SvcCategoryImp implements SvcCategory {
	
    /** Repositorio para acceder a los datos de categorías. */
	@Autowired
	RepoCategory repo;

    /**
     * Obtiene la lista de todas las categorías.
     * 
     * @return Lista de todas las categorías disponibles.
     */
	@Override
	public List<Category> getCategories() {
		return repo.getCategories();
	}

    /**
     * Obtiene la lista de categorías activas.
     * 
     * @return Lista de categorías con estado activo.
     */
	@Override
	public List<Category> getActiveCategories() {
		return repo.getActiveCategories();
	}

    /**
     * Obtiene una categoría específica según su ID.
     * Si la categoría no existe, lanza una excepción y devuelve null.
     * 
     * @param id Identificador único de la categoría.
     * @return Categoría correspondiente al ID proporcionado o null si no existe.
     */
	@Override
	public Category getCategory(Integer id) {
		try {
			Category category = repo.getCategory(id);
			if(category == null) {
				throw new Exception("No existe la categoría");
			}
			return category;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
