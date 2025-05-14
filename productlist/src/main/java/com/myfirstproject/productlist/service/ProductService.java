package com.myfirstproject.productlist.service;

import com.myfirstproject.productlist.controller.ProductController;
import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.entity.Category;
import com.myfirstproject.productlist.entity.Product;
import com.myfirstproject.productlist.mapper.CategoryMapper;
import com.myfirstproject.productlist.mapper.ProductMapper;
import com.myfirstproject.productlist.repository.CategoryRepository;
import com.myfirstproject.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public ProductDTO createProduct(ProductDTO productDTO) {

        //Check if category exist or not
        Category category = categoryRepository.findById(productDTO.getCategoryID())
                .orElseThrow(() -> new RuntimeException("Category Not found"));

        //DTO -> Entity
        Product product = ProductMapper.toProductEntity(productDTO, category);

        //Save Entity
        Product savedProduct = productRepository.save(product);

        //Entity -> DTO
        return ProductMapper.toProductDTO(product);


    }

    //Get Product By ID
    public ProductDTO getProductByID(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No such id found"));
        return ProductMapper.toProductDTO(product);
    }

    //Delete Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //Get All Product
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }


    //Update Product

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No such product found"));
        Category category = categoryRepository.findById(productDTO.getCategoryID()).orElseThrow(() -> new RuntimeException("No such category available"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }
}


