package com.customer.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.customer.api.dto.in.DtoProductIn;
import com.customer.api.dto.out.DtoProductListOut;
import com.customer.api.dto.out.DtoProductOut;
import com.customer.common.dto.ApiResponse;

/**
 * Servicio para la gestión de productos.
 * Define las operaciones disponibles para obtener, crear, actualizar y gestionar el estado de los productos.
 */
public interface SvcProduct {

    /**
     * Obtiene la lista de productos.
     * 
     * @return Lista de productos en formato de respuesta HTTP.
     */
    public ResponseEntity<List<DtoProductListOut>> getProducts();

    /**
     * Obtiene un producto específico según su ID.
     * 
     * @param id Identificador único del producto.
     * @return Producto correspondiente al ID proporcionado en formato de respuesta HTTP.
     */
    public ResponseEntity<DtoProductOut> getProduct(Integer id);

    /**
     * Crea un nuevo producto.
     * 
     * @param in Datos de entrada del producto.
     * @return Respuesta de la API con el resultado de la creación.
     */
    public ResponseEntity<ApiResponse> createProduct(DtoProductIn in);

    /**
     * Actualiza un producto existente.
     * 
     * @param id Identificador del producto.
     * @param in Datos de entrada actualizados.
     * @return Respuesta de la API con el resultado de la actualización.
     */
    public ResponseEntity<ApiResponse> updateProduct(Integer id, DtoProductIn in);

    /**
     * Habilita un producto por su ID.
     * 
     * @param id Identificador del producto a habilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    public ResponseEntity<ApiResponse> enableProduct(Integer id);

    /**
     * Deshabilita un producto por su ID.
     * 
     * @param id Identificador del producto a deshabilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    public ResponseEntity<ApiResponse> disableProduct(Integer id);
}
