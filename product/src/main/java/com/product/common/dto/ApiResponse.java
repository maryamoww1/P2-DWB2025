package com.product.common.dto;

/**
 * Clase que representa una respuesta genérica de la API.
 * Esta clase se utiliza para envolver mensajes de respuesta en las operaciones CRUD.
 */
public class ApiResponse {

	private String message;

	public ApiResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}