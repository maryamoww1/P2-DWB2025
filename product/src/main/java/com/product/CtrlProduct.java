package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para la gestión de categorías de productos.
 * Proporciona un endpoint para obtener la lista de categorías.
 */
@RestController
@RequestMapping("/category")
public class CtrlProduct {

    /**
     * Método para obtener la lista de categorías disponibles.
     * 
     * @return Lista de objetos de tipo Category.
     */
    @GetMapping
    public List<Category> getCategories() {
        // Creación de categorías en tiempo de ejecución
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Lentes", "Lts", 1));
        categories.add(new Category(2, "Relojes", "Rljs", 1));
        categories.add(new Category(3, "Collares", "Cllrs", 3));
        return categories;
    }
}
