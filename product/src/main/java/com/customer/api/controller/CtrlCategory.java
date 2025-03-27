package com.customer.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.entity.Category;
import com.customer.api.service.SvcCategory;

/**
 * Controlador REST para la gestión de categorías.
 * Proporciona endpoints para obtener todas las categorías,
 * categorías activas y una categoría específica por su ID.
 */
@RestController
@RequestMapping("/category")
public class CtrlCategory {
	
    /** Servicio para la gestión de categorías. */
	@Autowired
	SvcCategory svc;

    /**
     * Obtiene la lista de todas las categorías.
     * 
     * @return Lista de categorías disponibles.
     */
	@GetMapping
	public List<Category> getCategories(){
		return svc.getCategories();
	}

    /**
     * Obtiene la lista de categorías activas.
     * 
     * @return Lista de categorías con estado activo.
     */
	@GetMapping("/active")
	public List<Category> getActiveCategories(){
		return svc.getActiveCategories();
	}

    /**
     * Obtiene una categoría específica según su ID.
     * 
     * @param category_id Identificador único de la categoría.
     * @return Categoría correspondiente al ID proporcionado.
     */
	@GetMapping("/{category_id}")
	public Category getCategory(@PathVariable Integer category_id){
		return svc.getCategory(category_id);
	}
}
