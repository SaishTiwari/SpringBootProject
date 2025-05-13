package com.myfirstproject.productlist.service;

import com.myfirstproject.productlist.dto.CategoryDTO;
import com.myfirstproject.productlist.entity.Category;
import com.myfirstproject.productlist.mapper.CategoryMapper;
import com.myfirstproject.productlist.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    //create category

    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);


    }
}
