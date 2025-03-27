package com.customer.common.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.api.dto.in.DtoProductIn;
import com.customer.api.dto.out.DtoProductListOut;
import com.customer.api.entity.Product;

/**
 * Servicio para mapear entre entidades de productos y sus correspondientes DTOs.
 */
@Service
public class MapperProduct {
    
    /**
     * Convierte una lista de entidades de productos a una lista de DTOs de salida.
     * 
     * @param products Lista de productos.
     * @return Lista de DTOs con la información de los productos.
     */
    public List<DtoProductListOut> fromProductList(List<Product> products) {
        List<DtoProductListOut> list = new ArrayList<>();
        for (Product product : products) {
            list.add(new DtoProductListOut(
                    product.getProduct_id(),
                    product.getGtin(),
                    product.getProduct(),
                    product.getPrice(),
                    product.getStatus()
            ));
        }
        return list;
    }

    /**
     * Convierte un DTO de entrada a una entidad de producto.
     * 
     * @param dto DTO con la información del producto.
     * @return Entidad de producto creada a partir del DTO.
     */
    public Product fromDto(DtoProductIn dto) {
        Product product = new Product();
        product.setGtin(dto.getGtin());
        product.setProduct(dto.getProduct());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory_id(dto.getCategory_id());
        product.setStatus(1);
        
        return product;
    }
    
    /**
     * Convierte un DTO de entrada a una entidad de producto con un ID específico.
     * 
     * @param id Identificador único del producto.
     * @param dto DTO con la información del producto.
     * @return Entidad de producto con el ID asignado.
     */
    public Product fromDto(Integer id, DtoProductIn dto) {
        Product product = fromDto(dto);
        product.setProduct_id(id);
        return product;
    }
}
