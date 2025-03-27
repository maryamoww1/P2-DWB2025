package com.customer.common.dto;

/**
 * Clase que representa una respuesta estándar de la API.
 * Contiene un mensaje informativo sobre la operación realizada.
 */
public class ApiResponse {

    /** Mensaje de la respuesta. */
    private String message;

    /**
     * Constructor de la clase ApiResponse.
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
