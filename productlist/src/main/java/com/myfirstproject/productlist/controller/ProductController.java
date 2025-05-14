package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //getAllProducts
    
    //createProducts
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO){
        return new ResponseEntity<> (productService.createProduct(productDTO), HttpStatus.CREATED);


    }

    //updateProducts
    //deleteProducts
    //getProductsByID

}
