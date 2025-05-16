package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.dto.ProductDTO;
import com.myfirstproject.productlist.entity.Product;
import com.myfirstproject.productlist.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product API",
        description = "CRUD operation on product API"
)

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    //Dependency Injection through constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "RestAPI to fetch all product",
            description = "Fetch all products"
    )

    //getAllProducts
    @GetMapping
    public List<ProductDTO> getAllProducts (){

      return productService.getAllProducts();
    }

    //createProducts
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO){
        return new ResponseEntity<> (productService.createProduct(productDTO), HttpStatus.CREATED);
    }


    //updateProducts
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct (@PathVariable Long id, @RequestBody ProductDTO productDTO){

      return productService.updateProduct(id, productDTO);
    }


    //deleteProducts
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id){
        productService.deleteProduct(id);
    }



    //getProductsByID
    @GetMapping("/{id}")
    public ProductDTO getProductByID (@PathVariable Long id ){
        return productService.getProductByID(id);
    }

    //filterByPriceCheaperthan
    @GetMapping("cheaper-than/{price}")
    public List<ProductDTO> getProductByPrice(@PathVariable double price){
       return productService.getProductByPrice(price);

    }


}
