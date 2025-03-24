package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")

/**
 * Entidad que representa una categoria en el sistema.
 * Esta clase mapea directamente a la tabla category en la base de datos y
 * proporciona la estructura de datos para las categoras de productos.
 */
public class Category { 
	
	@Id
	@JsonProperty("category_id")
	@Column(name = "category_id")
	private Integer category_id;
	
	@JsonProperty("category")
	@Column(name = "category")
	private String category;
	
	@JsonProperty("tag")
	@Column(name = "tag")
	private String tag;
	
	@JsonProperty("status")
	@Column(name = "status")
	private Integer status;
	
	public Category() {
	}
	
	public Category(Integer category_id, String category, String tag, Integer status) {
		super();
		this.category_id = category_id;
		this.category = category;
		this.tag = tag;
		this.status = status;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategories() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	
}
