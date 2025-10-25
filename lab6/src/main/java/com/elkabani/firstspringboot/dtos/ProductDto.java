package com.elkabani.firstspringboot.dtos;

import com.elkabani.firstspringboot.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private int categoryId;
}
