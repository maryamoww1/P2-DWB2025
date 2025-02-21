package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CtrlProduct {

    //Metodo para obtener la lista de categories
    @GetMapping
    public List<Category> getCategories() {
        //creamos las categorias en tiempo de ejecucion
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Lentes", "Lts", 1));
        categories.add(new Category(2, "Relojes", "Rljs", 1));
        categories.add(new Category(3, "Collares", "Cllrs", 3));
        return categories;
    }
}
	