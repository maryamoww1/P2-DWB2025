package com.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Clase que representa la estructura de respuesta para excepciones en la API.
 * Contiene información detallada sobre el error ocurrido, incluyendo la marca de tiempo,
 * el código de estado HTTP, el mensaje de error y la ruta de la solicitud.
 */
public class ExceptionResponse {
    
    /** Marca de tiempo del momento en que ocurrió la excepción. */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    
    /** Código de estado HTTP de la respuesta. */
    private Integer status;
    
    /** Estado HTTP asociado al error. */
    private HttpStatus error;
    
    /** Mensaje descriptivo del error. */
    private String message;
    
    /** Ruta de la solicitud donde ocurrió la excepción. */
    private String path;

    /**
     * Obtiene la marca de tiempo del error.
     * 
     * @return Marca de tiempo del error.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * Establece la marca de tiempo del error.
     * 
     * @param timestamp Nueva marca de tiempo del error.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Obtiene el código de estado HTTP.
     * 
     * @return Código de estado HTTP.
     */
    public Integer getStatus() {
        return status;
    }
    
    /**
     * Establece el código de estado HTTP.
     * 
     * @param status Nuevo código de estado HTTP.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * Obtiene el estado HTTP asociado al error.
     * 
     * @return Estado HTTP asociado al error.
     */
    public HttpStatus getError() {
        return error;
    }
    
    /**
     * Establece el estado HTTP asociado al error.
     * 
     * @param error Nuevo estado HTTP del error.
     */
    public void setError(HttpStatus error) {
        this.error = error;
    }
    
    /**
     * Obtiene el mensaje de error.
     * 
     * @return Mensaje descriptivo del error.
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Establece el mensaje de error.
     * 
     * @param message Nuevo mensaje de error.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Obtiene la ruta de la solicitud donde ocurrió el error.
     * 
     * @return Ruta de la solicitud.
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Establece la ruta de la solicitud donde ocurrió el error.
     * 
     * @param path Nueva ruta de la solicitud.
     */
    public void setPath(String path) {
        this.path = path;
    }
}
