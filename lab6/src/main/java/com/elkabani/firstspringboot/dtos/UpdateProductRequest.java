package com.elkabani.firstspringboot.dtos;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private String name;
    private String description;
    private Double price;
}
