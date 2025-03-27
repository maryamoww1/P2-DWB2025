package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * La clase {CustomerApplication} es la clase principal de la aplicación
 * Spring Boot para la gestión de clientes. Esta clase inicializa y ejecuta la
 * aplicación mediante el método main.
 * 
 */
@SpringBootApplication
public class CustomerApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * 
     * @param args Argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
