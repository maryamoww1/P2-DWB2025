package com.product.exception;

import org.springframework.http.HttpStatus;

/**
 * Excepción personalizada para manejar errores en la API.
 * Extiende RuntimeException y permite establecer un estado HTTP específico.
 */
public class ApiException extends RuntimeException {
    
    /** Serial UID para la serialización. */
    private static final long serialVersionUID = 1L;
    
    /** Estado HTTP asociado a la excepción. */
    private HttpStatus status;
    
    /**
     * Constructor de la excepción con un estado HTTP y un mensaje.
     * 
     * @param status Estado HTTP asociado a la excepción.
     * @param message Mensaje descriptivo del error.
     */
    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    /**
     * Obtiene el estado HTTP de la excepción.
     * 
     * @return Estado HTTP.
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Establece el estado HTTP de la excepción.
     * 
     * @param status Nuevo estado HTTP.
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * Obtiene el UID de serialización de la clase.
     * 
     * @return UID de serialización.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}