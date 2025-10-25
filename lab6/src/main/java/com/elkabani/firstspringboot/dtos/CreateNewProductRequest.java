package com.elkabani.firstspringboot.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CreateNewProductRequest {
    private String name;
    private String description;
    private double price;
    private int categoryId;
}
