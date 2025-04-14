package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object para la entrada de datos de categorías.
 * Esta clase se utiliza para validar y transferir los datos de entrada
 * al crear o actualizar categorías, omitiendo campos autogenerados o
 * de control interno como el ID y el estado.
 */
public class DtoCategoryIn {
    
    /** Nombre de la categoría. */
    @JsonProperty("category")
    @NotNull(message = "La categoría es obligatoria")
    private String category;

    /** Etiqueta de la categoría. */
    @JsonProperty("tag")
    @NotNull(message = "El tag es obligatorio")
    private String tag;

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
}