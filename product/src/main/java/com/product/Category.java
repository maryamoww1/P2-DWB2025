package com.product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Category representa una categoría de productos con un ID,
 * nombre, etiqueta (tag) y estado. Permite la gestión de categorías mediante
 * métodos para validación, creación, eliminación y visualización.
 */
public class Category {
    /** Lista estática para almacenar las categorías creadas. */
    private static List<Category> categorias = new ArrayList<>();
    
    /** Identificador único de la categoría. */
    private Integer category_id;
    
    /** Nombre de la categoría. */
    private String category;
    
    /** Etiqueta de la categoría. */
    private String tag;
    
    /** Estado de la categoría (1 = Activa, 0 = Inactiva). */
    private Integer status;

    /**
     * Constructor de la clase Category.
     * 
     * @param category_id Identificador único de la categoría.
     * @param category Nombre de la categoría.
     * @param tag Etiqueta de la categoría.
     * @param status Estado de la categoría (1 para activa, 0 para inactiva).
     */
    public Category(Integer category_id, String category, String tag, Integer status) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    /**
     * Obtiene el ID de la categoría.
     * @return El identificador único de la categoría.
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * Obtiene el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Obtiene el tag de la categoría.
     * @return La etiqueta de la categoría.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Obtiene el estado de la categoría.
     * @return Estado de la categoría (1 = Activa, 0 = Inactiva).
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Establece un nuevo estado para la categoría.
     * @param status Nuevo estado de la categoría.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    /**
     * Verifica si un ID de categoría ya existe.
     * @param id Identificador a validar.
     * @return true si el ID ya existe, false en caso contrario.
     */
    public static boolean idExiste(Integer id) {
        for (Category c : categorias) {
            if (c.getCategory_id().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un nombre de categoría ya existe.
     * @param nombre Nombre de la categoría a validar.
     * @return true si el nombre ya existe, false en caso contrario.
     */
    public static boolean nombreExiste(String nombre) {
        for (Category c : categorias) {
            if (c.getCategory().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un tag de categoría ya existe.
     * @param tag Tag a validar.
     * @return true si el tag ya existe, false en caso contrario.
     */
    public static boolean tagExiste(String tag) {
        for (Category c : categorias) {
            if (c.getTag().equalsIgnoreCase(tag)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Crea una nueva categoría asegurando que el ID, nombre y tag sean únicos.
     */
    public static void createCategory() {
        Scanner scanner = new Scanner(System.in);
        Integer category_id;
        String category, tag;

        // Validar ID único
        while (true) {
            System.out.print("Ingresa el ID de la categoría: ");
            category_id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (idExiste(category_id)) {
                System.out.println("Error: El ID de la categoría ya existe. Ingresa un ID único.");
            } else {
                break;
            }
        }

        // Validar nombre único
        while (true) {
            System.out.print("Ingresa el nombre de la categoría: ");
            category = scanner.nextLine();

            if (nombreExiste(category)) {
                System.out.println("Error: La categoría ya existe. Ingresa un nombre único.");
            } else {
                break;
            }
        }

        // Validar tag único
        while (true) {
            System.out.print("Ingresa el tag de la categoría: ");
            tag = scanner.nextLine();

            if (tagExiste(tag)) {
                System.out.println("Error: El tag de la categoría ya existe. Ingresa un tag único.");
            } else {
                break;
            }
        }

        // Crear categoría
        Category nuevaCategoria = new Category(category_id, category, tag, 1);
        categorias.add(nuevaCategoria);
        System.out.println("Categoría creada con éxito!");
    }
    
    /**
     * Cambia el estado de una categoría a inactiva (eliminada).
     * @param category_id ID de la categoría a eliminar.
     */
    public static void deleteCategory(Integer category_id) {
        boolean encontrado = false;
        for (Category c : categorias) {
            if (c.getCategory_id().equals(category_id)) {
                c.setStatus(0);
                System.out.println("Status cambiado a 0. La categoría ha sido eliminada.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: No se encontró una categoría con ese ID.");
        }
    }
    
    /**
     * Muestra las categorías activas en la lista.
     */
    public static void mostrarCategorias() {
        System.out.println("\nCategorías actuales:");
        if (categorias.isEmpty()) {
            System.out.println("No existen categorías registradas.");
            return;
        }
        boolean hayActivas = false;
        for (Category c : categorias) {
            if (c.getStatus() == 1) {
                System.out.println("ID: " + c.getCategory_id() + ", Nombre: " + c.getCategory() + ", Tag: " + c.getTag());
                hayActivas = true;
            }
        }
        if (!hayActivas) {
            System.out.println("No hay categorías activas.");
        }
    }
}
