package com.myfirstproject.productlist.dto;

import java.util.List;

public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;

    // No-arg constructor
    public CategoryDTO() {
    }

    // All-args constructor
    public CategoryDTO(Long id, String name, List<ProductDTO> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}