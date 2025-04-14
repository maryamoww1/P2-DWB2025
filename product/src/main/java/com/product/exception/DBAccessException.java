package com.product.exception;

import org.springframework.dao.DataAccessException;

/**
 * Excepción personalizada para manejar errores de acceso a la base de datos.
 * Extiende RuntimeException y encapsula una excepción de acceso a datos.
 */
public class DBAccessException extends RuntimeException {

    /** Serial UID para la serialización. */
    private static final long serialVersionUID = 1L;
    
    /** Excepción de acceso a datos subyacente. */
    private DataAccessException exception;
    
    /**
     * Constructor que inicializa la excepción con una excepción de acceso a datos.
     * 
     * @param e Excepción de acceso a datos ocurrida.
     */
    public DBAccessException(DataAccessException e) {
        this.exception = e;
    }

    /**
     * Obtiene la excepción de acceso a datos encapsulada.
     * 
     * @return Excepción de acceso a datos.
     */
    public DataAccessException getException() {
        return exception;
    }

    /**
     * Establece la excepción de acceso a datos encapsulada.
     * 
     * @param exception Nueva excepción de acceso a datos.
     */
    public void setException(DataAccessException exception) {
        this.exception = exception;
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
