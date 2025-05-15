package com.myfirstproject.productlist.repository;

import com.myfirstproject.productlist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //method of JPA  for SELECT * FROM category WHERE name = ?;
    Optional<Category> findByName(String name);
}

