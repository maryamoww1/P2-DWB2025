package com.product.api.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DtoProductIn {

	@JsonProperty("gtin")
	@Pattern(regexp = "^\\+?\\d{13}$", message = "El gtin tiene un formato inválido")
	@NotNull(message="El gtin es obligatorio")
	private String gtin;
	  
    /** Nombre del producto. */
    @JsonProperty("product")
    @NotNull(message = "El product es obligatorio")
    private String product;
    
    /** Descripción del producto. */
    @JsonProperty("description")
    @NotNull(message = "El description es obligatorio")
    private String description;
    
    /** Precio del producto. */
    @JsonProperty("price")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @NotNull(message = "El price es obligatorio")
    private Float price;
    
    /** Stock disponible del producto. */
    @JsonProperty("stock")
    @NotNull(message = "El stock es obligatorio")
    private Integer stock;

    /** Identificador de la categoría a la que pertenece el producto. */
    @JsonProperty("category_id")
    @NotNull(message = "El category_id es obligatorio")
    private Integer category_id;

    /**
     * Obtiene el GTIN del producto.
     * 
     * @return Código GTIN.
     */
    public String getGtin() {
        return gtin;
    }

    /**
     * Establece el GTIN del producto.
     * 
     * @param gtin Código GTIN.
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
     * Obtiene la descripción del producto.
     * 
     * @return Descripción del producto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del producto.
     * 
     * @param description Descripción del producto.
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Obtiene el stock del producto.
     * 
     * @return Cantidad en stock.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     * 
     * @param stock Cantidad en stock.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Obtiene el ID de la categoría del producto.
     * 
     * @return ID de la categoría.
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * Establece el ID de la categoría del producto.
     * 
     * @param category_id ID de la categoría.
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
