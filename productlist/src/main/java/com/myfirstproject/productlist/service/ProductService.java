package com.myfirstproject.productlist.service;

import com.myfirstproject.productlist.controller.ProductController;
import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.entity.Category;
import com.myfirstproject.productlist.entity.Product;
import com.myfirstproject.productlist.mapper.ProductMapper;
import com.myfirstproject.productlist.repository.CategoryRepository;
import com.myfirstproject.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service

public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public ProductDTO createProduct (ProductDTO productDTO){

        //Check if category exist or not
        Category category = categoryRepository.findById(productDTO.getCategoryID())
                . orElseThrow(()-> new RuntimeException("Category Not found"));

        //DTO -> Entity
        Product product = ProductMapper.toProductEntity(productDTO, category);

        //Save Entity
        Product savedProduct = productRepository.save(product);

        //Entity -> DTO
        return ProductMapper.toProductDTO(product);




    }


}
