package com.customer.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.api.dto.in.DtoProductIn;
import com.customer.api.dto.out.DtoProductListOut;
import com.customer.api.dto.out.DtoProductOut;
import com.customer.api.entity.Product;
import com.customer.api.repository.RepoProduct;
import com.customer.common.dto.ApiResponse;
import com.customer.common.mapper.MapperProduct;
import com.customer.exception.ApiException;
import com.customer.exception.DBAccessException;

/**
 * Implementación del servicio para la gestión de productos.
 * Proporciona métodos para obtener, crear, actualizar y gestionar el estado de los productos.
 */
@Service
public class SvcProductImp implements SvcProduct {
    
    /** Repositorio para acceder a los datos de productos. */
    @Autowired
    RepoProduct repo;
    
    /** Mapper para convertir entre entidades y DTOs. */
    @Autowired
    MapperProduct mapper;

    /**
     * Obtiene la lista de productos.
     * 
     * @return Lista de productos en formato de respuesta HTTP.
     */
    @Override
    public ResponseEntity<List<DtoProductListOut>> getProducts() {
        try {
            List<Product> products = repo.findAll();
            return new ResponseEntity<>(mapper.fromProductList(products), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    /**
     * Obtiene un producto específico según su ID.
     * 
     * @param id Identificador único del producto.
     * @return Producto correspondiente al ID proporcionado en formato de respuesta HTTP.
     */
    @Override
    public ResponseEntity<DtoProductOut> getProduct(Integer id) {
        try {
            validateProductId(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    /**
     * Crea un nuevo producto.
     * 
     * @param in Datos de entrada del producto.
     * @return Respuesta de la API con el resultado de la creación.
     */
    @Override
    public ResponseEntity<ApiResponse> createProduct(DtoProductIn in) {
        try {
            Product product = mapper.fromDto(in);
            repo.save(product);
            return new ResponseEntity<>(new ApiResponse("El producto ha sido registrado"), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            handleDatabaseException(e);
            return null;
        }
    }

    /**
     * Actualiza un producto existente.
     * 
     * @param id Identificador del producto.
     * @param in Datos de entrada actualizados.
     * @return Respuesta de la API con el resultado de la actualización.
     */
    @Override
    public ResponseEntity<ApiResponse> updateProduct(Integer id, DtoProductIn in) {
        try {
            validateProductId(id);
            Product product = mapper.fromDto(id, in);
            repo.save(product);
            return new ResponseEntity<>(new ApiResponse("El producto ha sido actualizado"), HttpStatus.OK);
        } catch (DataAccessException e) {
            handleDatabaseException(e);
            return null;
        }
    }

    /**
     * Habilita un producto por su ID.
     * 
     * @param id Identificador del producto a habilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @Override
    public ResponseEntity<ApiResponse> enableProduct(Integer id) {
        try {
            validateProductId(id);
            Product product = repo.findById(id).get();
            product.setStatus(1);
            repo.save(product);
            return new ResponseEntity<>(new ApiResponse("El producto ha sido activado"), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    /**
     * Deshabilita un producto por su ID.
     * 
     * @param id Identificador del producto a deshabilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @Override
    public ResponseEntity<ApiResponse> disableProduct(Integer id) {
        try {
            validateProductId(id);
            Product product = repo.findById(id).get();
            product.setStatus(0);
            repo.save(product);
            return new ResponseEntity<>(new ApiResponse("El producto ha sido desactivado"), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }
    
    /**
     * Valida si un ID de producto existe en la base de datos.
     * 
     * @param id Identificador único del producto.
     */
    private void validateProductId(Integer id) {
        try {
            if (repo.findById(id).isEmpty()) {
                throw new ApiException(HttpStatus.NOT_FOUND, "El id del producto no existe");
            }
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    /**
     * Maneja excepciones de acceso a la base de datos.
     * 
     * @param e Excepción de acceso a la base de datos.
     */
    private void handleDatabaseException(DataAccessException e) {
        if (e.getLocalizedMessage().contains("ux_product_gtin"))
            throw new ApiException(HttpStatus.CONFLICT, "El gtin del producto ya está registrado");
        if (e.getLocalizedMessage().contains("ux_product_product"))
            throw new ApiException(HttpStatus.CONFLICT, "El nombre del producto ya está registrado");
        if (e.getLocalizedMessage().contains("fk_product_category"))
            throw new ApiException(HttpStatus.NOT_FOUND, "El id de categoría no existe");

        throw new DBAccessException(e);
    }
}
