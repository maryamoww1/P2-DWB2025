package com.product.api.controller;

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

import com.product.api.dto.in.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;
import com.product.common.dto.ApiResponse;
import com.product.exception.ApiException;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador REST para la gestión de categorías.
 * Proporciona endpoints para realizar operaciones CRUD y gestión de estados
 * de las categorías en el sistema.
 */
@RestController
@RequestMapping("/category")
@Tag(name = "Category", description = "Catálogo de categorías")
public class CtrlCategory {

    /** Servicio de categorías. */
    @Autowired
    SvcCategory svc;

    /**
     * Obtiene la lista de todas las categorías.
     * 
     * @return Lista de categorías en formato de respuesta HTTP.
     */
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return svc.getCategories();
    }

    /**
     * Obtiene la lista de categorías activas.
     * 
     * @return Lista de categorías con estado activo en formato de respuesta HTTP.
     */
    @GetMapping("/active")
    public ResponseEntity<List<Category>> getActiveCategories() {
        return svc.getActiveCategories();
    }

    /**
     * Obtiene una categoría específica según su ID.
     * 
     * @param id Identificador único de la categoría.
     * @return Categoría correspondiente al ID proporcionado en formato de respuesta HTTP.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        return svc.getCategory(id);
    }

    /**
     * Crea una nueva categoría.
     * 
     * @param in Datos de entrada de la categoría.
     * @param bindingResult Validación de la entrada.
     * @return Respuesta de la API con el resultado de la creación.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody DtoCategoryIn in, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

        return svc.createCategory(in);
    }

    /**
     * Actualiza una categoría existente.
     * 
     * @param id Identificador de la categoría.
     * @param in Datos de entrada actualizados.
     * @param bindingResult Validación de la entrada.
     * @return Respuesta de la API con el resultado de la actualización.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Integer id, @Valid @RequestBody DtoCategoryIn in,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

        return svc.updateCategory(id, in);
    }

    /**
     * Habilita una categoría por su ID.
     * 
     * @param id Identificador de la categoría a habilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @PatchMapping("/{id}/enable")
    public ResponseEntity<ApiResponse> enableCategory(@PathVariable Integer id) {
        return svc.enableCategory(id);
    }

    /**
     * Deshabilita una categoría por su ID.
     * 
     * @param id Identificador de la categoría a deshabilitar.
     * @return Respuesta de la API con el resultado de la operación.
     */
    @PatchMapping("/{id}/disable")
    public ResponseEntity<ApiResponse> disableCategory(@PathVariable Integer id) {
        return svc.disableCategory(id);
    }
}
