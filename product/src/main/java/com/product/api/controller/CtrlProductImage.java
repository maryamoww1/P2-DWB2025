package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.service.SvcProductImage;
import com.product.common.dto.ApiResponse;
import com.product.exception.ApiException;

import jakarta.validation.Valid;

/**
 * Controlador REST para la gestión de imágenes de productos.
 * Proporciona un endpoint para la carga de imágenes asociadas a productos.
 */
@RestController
@RequestMapping("/product-image")
public class CtrlProductImage {
    
    /** Servicio para la gestión de imágenes de productos. */
    @Autowired
    SvcProductImage svc;

    /**
     * Sube una imagen de producto.
     * 
     * @param in Datos de entrada de la imagen del producto.
     * @param bindingResult Validación de la entrada.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> createProductImage(@Valid @RequestBody DtoProductImageIn in, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

        return svc.uploadProductImage(in);
    }
}
