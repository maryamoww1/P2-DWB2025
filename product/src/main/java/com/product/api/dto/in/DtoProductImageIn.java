package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object para la entrada de datos de imágenes de productos.
 * Esta clase se utiliza para validar y transferir los datos de entrada
 * al asociar una imagen a un producto.
 */
public class DtoProductImageIn {
    
    /** Identificador único del producto. */
    @JsonProperty("product_id")
    @NotNull(message = "El product_id es obligatorio")
    private Integer product_id;
    
    /** Imagen en formato base64 o URL. */
    @JsonProperty("image")
    @NotNull(message = "El image es obligatorio")
    private String image;

    /**
     * Obtiene el ID del producto.
     * 
     * @return Identificador único del producto.
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * Establece el ID del producto.
     * 
     * @param product_id Identificador único del producto.
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * Obtiene la imagen del producto.
     * 
     * @return Imagen en formato base64 o URL.
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece la imagen del producto.
     * 
     * @param image Nueva imagen en formato base64 o URL.
     */
    public void setImage(String image) {
        this.image = image;
    }
}