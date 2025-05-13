package com.myfirstproject.productlist.controller;

import com.myfirstproject.productlist.dto.CategoryDTO;
import com.myfirstproject.productlist.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;



    //getAllCategories
    //createCategories

    @PostMapping
    public CategoryDTO createProduct (@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);

    }
    //getCategoriesByID

}
