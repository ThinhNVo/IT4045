package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

    List<Product> findProductByCategoryId(int category_id);
}