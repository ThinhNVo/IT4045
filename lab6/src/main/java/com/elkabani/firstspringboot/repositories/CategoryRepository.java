package com.elkabani.firstspringboot.repositories;

import com.elkabani.firstspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}