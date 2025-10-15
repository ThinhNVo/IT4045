package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}