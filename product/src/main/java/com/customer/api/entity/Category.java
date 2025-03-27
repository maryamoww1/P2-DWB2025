package com.customer.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla "category" en la base de datos.
 * Define los atributos de una categoría y su mapeo a la base de datos.
 */
@Entity
@Table(name = "category")
public class Category { 
	
    /** Identificador único de la categoría. */
	@Id
	private Integer category_id;
	
    /** Nombre de la categoría. */
	private String category;
    
    /** Etiqueta asociada a la categoría. */
	private String tag;
    
    /** Estado de la categoría (1 = Activa, 0 = Inactiva). */
	private Integer status;
	
    /**
     * Constructor por defecto.
     */
	public Category() {
	}
	
    /**
     * Constructor con parámetros para inicializar una categoría.
     * 
     * @param category_id Identificador único de la categoría.
     * @param category Nombre de la categoría.
     * @param tag Etiqueta asociada a la categoría.
     * @param status Estado de la categoría (1 para activa, 0 para inactiva).
     */
	public Category(Integer category_id, String category, String tag, Integer status) {
		super();
		this.category_id = category_id;
		this.category = category;
		this.tag = tag;
		this.status = status;
	}

    /**
     * Obtiene el ID de la categoría.
     * 
     * @return Identificador único de la categoría.
     */
	public Integer getCategory_id() {
		return category_id;
	}

    /**
     * Establece el ID de la categoría.
     * 
     * @param category_id Nuevo identificador único de la categoría.
     */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

    /**
     * Obtiene el nombre de la categoría.
     * 
     * @return Nombre de la categoría.
     */
	public String getCategories() {
		return category;
	}

    /**
     * Establece el nombre de la categoría.
     * 
     * @param category Nuevo nombre de la categoría.
     */
	public void setCategory(String category) {
		this.category = category;
	}

    /**
     * Obtiene la etiqueta de la categoría.
     * 
     * @return Etiqueta de la categoría.
     */
	public String getTag() {
		return tag;
	}

    /**
     * Establece la etiqueta de la categoría.
     * 
     * @param tag Nueva etiqueta de la categoría.
     */
	public void setTag(String tag) {
		this.tag = tag;
	}

    /**
     * Obtiene el estado de la categoría.
     * 
     * @return Estado de la categoría 
     */
	public Integer getStatus() {
		return status;
	}

    /**
     * Establece el estado de la categoría.
     * 
     * @param status Nuevo estado de la categoría.
     */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
