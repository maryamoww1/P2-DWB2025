package com.product.api.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO (Data Transfer Object) para representar la información básica de un producto en una lista de productos.
 * Contiene detalles esenciales como el ID del producto, GTIN, nombre, precio y estado.
 */
public class DtoProductListOut {

    @JsonProperty("product_id")
    private Integer product_id;

    @JsonProperty("gtin")
    private String gtin;

    @JsonProperty("product")
    private String product;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("status")
    private Integer status;

    /**
     * Constructor para inicializar un objeto DtoProductListOut con los valores proporcionados.
     * 
     * @param product_id Identificador único del producto.
     * @param gtin Código GTIN (Global Trade Item Number) del producto.
     * @param product Nombre del producto.
     * @param price Precio del producto.
     * @param status Estado del producto (1 = activo, 0 = inactivo).
     */
    public DtoProductListOut(Integer product_id, String gtin, String product, Float price, Integer status) {
        this.product_id = product_id;
        this.gtin = gtin;
        this.product = product;
        this.price = price;
        this.status = status;
    }

    /**
     * Obtiene el identificador único del producto.
     * 
     * @return ID del producto.
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * Establece el identificador único del producto.
     * 
     * @param product_id Nuevo ID del producto.
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * Obtiene el código GTIN del producto.
     * 
     * @return Código GTIN.
     */
    public String getGtin() {
        return gtin;
    }

    /**
     * Establece el código GTIN del producto.
     * 
     * @param gtin Nuevo código GTIN.
     */
    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return Nombre del producto.
     */
    public String getProduct() {
        return product;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param product Nuevo nombre del producto.
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return Precio del producto.
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param price Nuevo precio del producto.
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Obtiene el estado del producto.
     * 
     * @return Estado del producto (1 = activo, 0 = inactivo).
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Establece el estado del producto.
     * 
     * @param status Nuevo estado del producto (1 = activo, 0 = inactivo).
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
