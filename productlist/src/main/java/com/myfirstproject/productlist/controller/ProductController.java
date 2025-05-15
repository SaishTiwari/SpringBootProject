package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.entity.Product;
import com.myfirstproject.productlist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    //Dependency Injection through constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //getAllProducts
    @GetMapping
    public List<ProductDTO> getAllProducts (){

      return productService.getAllProducts();
    }

    //createProducts
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO){
        return new ResponseEntity<> (productService.createProduct(productDTO), HttpStatus.CREATED);
    }


    //updateProducts
    @PutMapping("/{id}")
    public ProductDTO updateProduct (@PathVariable Long id, @RequestBody ProductDTO productDTO){

      return productService.updateProduct(id, productDTO);
    }


    //deleteProducts
    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id){
        productService.deleteProduct(id);
    }



    //getProductsByID
    @GetMapping("/{id}")
    public ProductDTO getProductByID (@PathVariable Long id ){
        return productService.getProductByID(id);
    }

    @GetMapping("cheaper-than/{price}")
    public List<ProductDTO> getProductByPrice(@PathVariable double price){
       return productService.getProductByPrice(price);

    }


}
