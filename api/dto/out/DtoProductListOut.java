package com.customer.api.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para la salida de datos de la lista de productos.
 * Contiene información básica sobre los productos disponibles.
 */
public class DtoProductListOut {
	
    /** Identificador único del producto. */
	@JsonProperty("product_id")
	private Integer product_id;
	
    /** Código GTIN del producto. */
	@JsonProperty("gtin")
	private String gtin;

    /** Nombre del producto. */
	@JsonProperty("product")
	private String product;

    /** Precio del producto. */
	@JsonProperty("price")
	private Float price;

    /** Estado del producto (1 = Activo, 0 = Inactivo). */
	@JsonProperty("status")
	private Integer status;

    /**
     * Constructor con parámetros para inicializar el DTO.
     * 
     * @param product_id Identificador único del producto.
     * @param gtin Código GTIN del producto.
     * @param product Nombre del producto.
     * @param price Precio del producto.
     * @param status Estado del producto.
     */
	public DtoProductListOut(Integer product_id, String gtin, String product, Float price, Integer status) {
		super();
		this.product_id = product_id;
		this.gtin = gtin;
		this.product = product;
		this.price = price;
		this.status = status;
	}

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
     * Obtiene el GTIN del producto.
     * 
     * @return Código GTIN del producto.
     */
	public String getGtin() {
		return gtin;
	}

    /**
     * Establece el GTIN del producto.
     * 
     * @param gtin Código GTIN del producto.
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
     * @param product Nombre del producto.
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
     * @param price Precio del producto.
     */
	public void setPrice(Float price) {
		this.price = price;
	}

    /**
     * Obtiene el estado del producto.
     * 
     * @return Estado del producto (1 = Activo, 0 = Inactivo).
     */
	public Integer getStatus() {
		return status;
	}

    /**
     * Establece el estado del producto.
     * 
     * @param status Estado del producto.
     */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
