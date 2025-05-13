package com.myfirstproject.productlist.dto;

import com.myfirstproject.productlist.entity.Product;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {

    private Long id;
    private String name;

    private List<ProductDTO> products;

}
