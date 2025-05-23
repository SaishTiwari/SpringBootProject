package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.dto.CategoryDTO;
import com.myfirstproject.productlist.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Category API",
        description = "CRUD operation of category API"
)

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // Constructor injection
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // POST /api/categories
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory (@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<> (categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    // getAllCategories

    @GetMapping
    public List<CategoryDTO> getAllCategory (){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryByID(@PathVariable long id){
        return categoryService.getCategoryByID(id);

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
    }


}