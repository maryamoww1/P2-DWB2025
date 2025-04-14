package com.product.common.dto;

/**
 * Clase que representa una respuesta genérica de la API.
 * Esta clase se utiliza para envolver mensajes de respuesta en las operaciones CRUD.
 */
public class ApiResponse {

    /** Mensaje de respuesta de la API. */
    private String message;

    /**
     * Constructor que inicializa la respuesta con un mensaje específico.
     * 
     * @param message Mensaje de la respuesta.
     */
    public ApiResponse(String message) {
        super();
        this.message = message;
    }

    /**
     * Obtiene el mensaje de la respuesta.
     * 
     * @return Mensaje de la respuesta.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de la respuesta.
     * 
     * @param message Nuevo mensaje de la respuesta.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
