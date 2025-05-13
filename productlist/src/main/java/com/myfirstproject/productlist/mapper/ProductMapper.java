package com.myfirstproject.productlist.mapper;

import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.entity.Category;
import com.myfirstproject.productlist.entity.Product;

public class ProductMapper {

    // Entity to DTO

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );

    }

    //DTO to Entity

    public static Product toProductEntity (ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return  product;


    }
}
