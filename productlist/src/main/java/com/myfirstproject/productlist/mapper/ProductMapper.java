package com.myfirstproject.productlist.mapper;

import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.entity.Category;
import com.myfirstproject.productlist.entity.Product;

public class ProductMapper {

    // Entity to DTO

    public static ProductDTO toProductDTO(Product product){

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryID(product.getCategory().getId());
        return productDTO;



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
