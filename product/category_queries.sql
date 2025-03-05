-- Crear tabla Category
CREATE TABLE category (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(255) NOT NULL,
    tag VARCHAR(255),
    status INT NOT NULL DEFAULT 1
);

-- Insertar datos en Category
INSERT INTO category (category, tag, status) VALUES 
('Electrónica', 'gadgets', 1),
('Ropa', 'fashion', 1),
('Alimentos', 'comida', 1),
('Juguetes', 'infantil', 1),
('Deportes', 'fitness', 1),
('Hogar', 'muebles', 1),
('Libros', 'educación', 1),
('Automotriz', 'autos', 1),
('Salud', 'medicina', 1),
('Mascotas', 'animales', 1);
