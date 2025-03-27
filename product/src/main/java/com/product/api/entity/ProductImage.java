package com.product.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla "product_image" en la base de datos.
 * Contiene los atributos de una imagen de producto y su mapeo a la base de datos.
 */
@Entity
@Table(name = "product_image")
public class ProductImage {

    /** Identificador único de la imagen del producto, generado automáticamente. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Integer product_image_id;
    
    /** Identificador del producto asociado a la imagen. */
    @Column(name = "product_id")
    private Integer product_id;
    
    /** URL o contenido en base64 de la imagen del producto. */
    @Column(name = "image")
    private String image;
    
    /** Estado de la imagen (1 = Activa, 0 = Inactiva). */
    @Column(name = "status")
    private Integer status;

    /**
     * Obtiene el ID de la imagen del producto.
     * 
     * @return Identificador único de la imagen del producto.
     */
    public Integer getProduct_image_id() {
        return product_image_id;
    }

    /**
     * Establece el ID de la imagen del producto.
     * 
     * @param product_image_id Nuevo identificador único de la imagen del producto.
     */
    public void setProduct_image_id(Integer product_image_id) {
        this.product_image_id = product_image_id;
    }

    /**
     * Obtiene el ID del producto asociado a la imagen.
     * 
     * @return Identificador del producto.
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * Establece el ID del producto asociado a la imagen.
     * 
     * @param product_id Nuevo identificador del producto.
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * Obtiene la imagen del producto.
     * 
     * @return URL o contenido en base64 de la imagen.
     */
    public String getImage() {
        return image;
    }

    /**
     * Establece la imagen del producto.
     * 
     * @param image Nueva imagen del producto en formato URL o base64.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Obtiene el estado de la imagen.
     * 
     * @return Estado de la imagen (1 = Activa, 0 = Inactiva).
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Establece el estado de la imagen.
     * 
     * @param status Nuevo estado de la imagen.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
