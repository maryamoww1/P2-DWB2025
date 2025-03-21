package com.product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Category {
    private static List<Category> categorias = new ArrayList<>();
    private Integer category_id;
    private String category;
    private String tag;
    private Integer status;

    // Constructor de la clase Category
    public Category(Integer category_id, String category, String tag, Integer status) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    // Getters y setters
    public Integer getCategory_id() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public String getTag() {
        return tag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    //Médtodos para validar si el ID, nombre o tag ya existen
    public static boolean idExiste(Integer id) {
        for (Category c : categorias) {
            if (c.getCategory_id().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean nombreExiste(String nombre) {
        for (Category c : categorias) {
            if (c.getCategory().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tagExiste(String tag) {
        for (Category c : categorias) {
            if (c.getTag().equalsIgnoreCase(tag)) {
                return true;
            }
        }
        return false;
    }
    //Métodos para crear las categorias validando que no se repitan valores.

    public static void createCategory() {
        Scanner scanner = new Scanner(System.in);
        Integer category_id;
        String category, tag;

        // Validar ID primero
        while (true) {
            System.out.print("Ingresa el ID de la categoría: ");
            category_id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (idExiste(category_id)) {
                System.out.println("Error: El ID de la categoría ya existe. Ingresa un ID único.");
            } else {
                break; // ID válido, continuar con el proceso
            }
        }

        // Validar nombre
        while (true) {
            System.out.print("Ingresa el nombre de la categoría: ");
            category = scanner.nextLine();

            if (nombreExiste(category)) {
                System.out.println("Error: La categoría ya existe. Ingresa un nombre único.");
            } else {
                break; // Nombre válido, continuar
            }
        }

        // Validar tag
        while (true) {
            System.out.print("Ingresa el tag de la categoría: ");
            tag = scanner.nextLine();

            if (tagExiste(tag)) {
                System.out.println("Error: El tag de la categoría ya existe. Ingresa un tag único.");
            } else {
                break; // Tag válido, continuar
            }
        }

        // Crear la categoría
        Category nuevaCategoria = new Category(category_id, category, tag, 1);
        categorias.add(nuevaCategoria);
        System.out.println("Categoría creada con éxito!");
    }
    //Método para eliminar una categoría
    public static void deleteCategory(Integer category_id) {
        boolean encontrado = false;
        for (Category c : categorias) {
            if (c.getCategory_id().equals(category_id)) {
                c.setStatus(0);  // Eliminar la categoría de la lista
                System.out.println("Status cambiado a 0. La categoría ha sido eliminada.");
                System.out.println("ID: " + c.getCategory_id() + ", Nombre: " + c.getCategory() + ", Tag: " + c.getTag() + ", Status: " + c.getStatus());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Error: No se encontró una categoría con ese ID.");
        }
    }
    //Método para mostrar las categorías

    public static void mostrarCategorias() {
        System.out.println("\nCategorías actuales:");
    
        if (categorias.isEmpty()) {
            System.out.println("No existen categorías registradas.");
            return;
        }
    
        boolean hayActivas = false;
        for (Category c : categorias) {
            if (c.getStatus() == 1) {  // Mostrar solo categorías activas
                System.out.println("ID: " + c.getCategory_id() + ", Nombre: " + c.getCategory() + 
                                   ", Tag: " + c.getTag() + ", Status: " + c.getStatus());
                hayActivas = true;
            }
        }
    
        if (!hayActivas) {
            System.out.println("No hay categorías activas. Puede que se hayan eliminado o desactivado.");
        }
    }
    
}
