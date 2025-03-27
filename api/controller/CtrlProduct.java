package com.customer.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.dto.in.DtoProductIn;
import com.customer.api.dto.out.DtoProductListOut;
import com.customer.api.dto.out.DtoProductOut;
import com.customer.api.service.SvcProduct;
import com.customer.common.dto.ApiResponse;
import com.customer.exception.ApiException;

import jakarta.validation.Valid;

/**
 * Controlador REST para la gestión de productos.
 * Proporciona endpoints para obtener, crear, actualizar y cambiar el estado de los productos.
 */
@RestController
@RequestMapping("/product")
public class CtrlProduct {

    /** Servicio de productos. */
    @Autowired
    SvcProduct svc;

    /**
     * Obtiene la lista de productos.
     * 
     * @return Lista de productos en formato de respuesta HTTP.
     */
    @GetMapping
    public ResponseEntity<List<DtoProductListOut>> getProducts() {
        return svc.getProducts();
    }

    /**
     * Obtiene un producto específico según su ID.
     * 
     * @param id Identificador único del producto.
     * @return Producto correspondiente al ID proporcionado en formato de respuesta HTTP.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DtoProductOut> getProduct(@PathVariable Integer id) {
        return svc.getProduct(id);
    }

    /**
     * Crea un nuevo producto.
     * 
     * @param in Datos de entrada del producto.
     * @param bindingResult Validación de la entrada.
     * @return Respuesta de la API con el resultado de la creación.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody DtoProductIn in, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

        return svc.createProduct(in);
    }

    /**
     * Actualiza un producto existente.
     * 
     * @param id Identificador del producto.
     * @param in Datos de entrada actualizados.
     * @param bindingResult Validación de la entrada.
     * @return Respuesta de la API con el resultado de la actualización.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer id, @Valid @RequestBody DtoProductIn in,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

        return svc.updateProduct(id, in);
    }

    /**
     * Habilita un producto por su ID.
     * 
     * @param id Identificador del producto a habilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @PatchMapping("/{id}/enable")
    public ResponseEntity<ApiResponse> enableProduct(@PathVariable Integer id) {
        return svc.enableProduct(id);
    }

    /**
     * Deshabilita un producto por su ID.
     * 
     * @param id Identificador del producto a deshabilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @PatchMapping("/{id}/disable")
    public ResponseEntity<ApiResponse> disableProduct(@PathVariable Integer id) {
        return svc.disableProduct(id);
    }
}
