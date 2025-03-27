package com.customer.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla "region" en la base de datos.
 * Contiene los atributos de una categoría y su mapeo a la base de datos.
 */
@Entity
@Table(name = "region")
public class Category {	
	
    /** Identificador único de la categoría. */
	@Id
	@JsonProperty("category_id")
	@Column(name = "category_id")
	private Integer category_id;
	
    /** Nombre de la categoría. */
	@JsonProperty("category")
	@Column(name = "category")
	private String category;

    /** Etiqueta de la categoría. */
	@JsonProperty("tag")
	@Column(name = "tag")
	private String tag;

    /** Estado de la categoría (1 = Activa, 0 = Inactiva). */
	@JsonProperty("status")
	@Column(name = "status")
	private Integer status;

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
	public String getCategory() {
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
     * @return Estado de la categoría (1 = Activa, 0 = Inactiva).
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