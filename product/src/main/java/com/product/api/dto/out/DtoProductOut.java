package com.product.api.dto.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * DTO (Data Transfer Object) para la salida de datos de un producto.
 * Representa la información detallada de un producto, incluyendo su descripción, precio, stock y estado.
 */
@Entity
@Table(name = "product")
public class DtoProductOut {

    /** Identificador único del producto. */
    @Id
    private Integer product_id;
    
    /** Nombre del producto. */
    private String product;
    
    /** Descripción del producto. */
    private String description;
    
    /** Precio del producto. */
    private Float price;
    
    /** Cantidad disponible en stock del producto. */
    private Integer stock;
    
    /** Identificador de la categoría a la que pertenece el producto. */
    private Integer category_id;
    
    /** Estado del producto (1 = Activo, 0 = Inactivo). */
    private Integer status;
    
    /** Imagen del producto, campo transitorio que no se almacena en la base de datos. */
    @Transient
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
     * @param product_id Nuevo identificador único del producto.
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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
     * @param description Nueva descripción del producto.
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
     * @param price Nuevo precio del producto.
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Obtiene la cantidad en stock del producto.
     * 
     * @return Cantidad en stock.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece la cantidad en stock del producto.
     * 
     * @param stock Nueva cantidad en stock.
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
     * @param category_id Nuevo ID de la categoría.
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
     * @param status Nuevo estado del producto.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Obtiene la imagen del producto.
     * 
     * @return URL o representación en base64 de la imagen del producto.
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece la imagen del producto.
     * 
     * @param image Nueva imagen del producto (URL o base64).
     */
    public void setImage(String image) {
        this.image = image;
    }
}
