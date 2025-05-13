package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.dto.CategoryDTO;
import com.myfirstproject.productlist.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // Constructor injection
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // POST /api/categories
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory (@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<> (categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    // TODO: Add getAllCategories and getCategoryById
}