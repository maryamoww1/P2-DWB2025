package com.product.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object para la entrada de datos de categorias.
 * Esta clase se utiliza para validar y transferir los datos de entrada
 * al crear o actualizar categorias, omitiendo campos autogenerados o
 * de control interno como el id y el estado.
 */
public class DtoCategoryIn {
	
	@JsonProperty("category")
	@NotNull(message="La categoría es obligatoria")
	private String category;

	@JsonProperty("tag")
	@NotNull(message="El tag es obligatorio")
	private String tag;

	public String getCategory() {
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
	
	

}