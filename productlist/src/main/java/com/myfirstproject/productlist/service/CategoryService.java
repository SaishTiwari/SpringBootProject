
package com.myfirstproject.productlist.service;

import com.myfirstproject.productlist.dto.CategoryDTO;
import com.myfirstproject.productlist.mapper.CategoryMapper;
import com.myfirstproject.productlist.repository.CategoryRepository;
import com.myfirstproject.productlist.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(savedCategory);
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toCategoryDTO).toList();
    }

}
