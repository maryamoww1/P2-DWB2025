package com.customer.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla "product" en la base de datos.
 * Contiene los atributos de un producto y su mapeo a la base de datos.
 */
@Entity
@Table(name = "product")
public class Product {
	
    /** Identificador único del producto, generado automáticamente. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer product_id;
	
    /** Código GTIN del producto. */
	@Column(name = "gtin")
	private String gtin;

    /** Nombre del producto. */
	@Column(name = "product")
	private String product;

    /** Descripción del producto. */
	@Column(name = "description")
	private String description;

    /** Precio del producto. */
	@Column(name = "price")
	private Float price;

    /** Cantidad de stock disponible del producto. */
	@Column(name = "stock")
	private Integer stock;

    /** Identificador de la categoría a la que pertenece el producto. */
	@Column(name = "category_id")
	private Integer category_id;

    /** Estado del producto (1 = Activo, 0 = Inactivo). */
	@Column(name = "status")
	private Integer status;

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
     * @return Cantidad de stock disponible.
     */
	public Integer getStock() {
		return stock;
	}

    /**
     * Establece el stock del producto.
     * 
     * @param stock Cantidad de stock disponible.
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
