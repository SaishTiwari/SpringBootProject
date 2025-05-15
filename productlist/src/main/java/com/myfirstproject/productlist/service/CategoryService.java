
package com.myfirstproject.productlist.service;

import com.myfirstproject.productlist.dto.CategoryDTO;
import com.myfirstproject.productlist.exception.CategoryAlreadyExistException;
import com.myfirstproject.productlist.mapper.CategoryMapper;
import com.myfirstproject.productlist.repository.CategoryRepository;
import com.myfirstproject.productlist.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       Optional<Category> optionalCategory =  categoryRepository.findByName(categoryDTO.getName());

       //Exception Handling
       if(optionalCategory.isPresent()){
           throw new CategoryAlreadyExistException("Category" + categoryDTO.getName() + "already exists.");
       }

        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(savedCategory);
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO getCategoryByID(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("ID not found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
