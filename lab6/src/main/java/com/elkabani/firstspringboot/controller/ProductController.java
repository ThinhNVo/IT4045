package com.elkabani.firstspringboot.controller;


import com.elkabani.firstspringboot.dtos.CreateNewProductRequest;
import com.elkabani.firstspringboot.dtos.ProductDto;
import com.elkabani.firstspringboot.dtos.UpdateProductRequest;
import com.elkabani.firstspringboot.entity.Product;
import com.elkabani.firstspringboot.mappers.ProductMapper;
import com.elkabani.firstspringboot.repositories.CategoryRepository;
import com.elkabani.firstspringboot.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(@RequestParam(name = "categoryId",required = false, defaultValue = "-1") int categoryId) {
        if (categoryId == -1) {
            return productRepository.findAll().stream()
                    .map(product -> productMapper.toDto(product)).toList();
        }
        return productRepository.findProductByCategoryId(categoryId).stream()
                .map(product -> productMapper.toDto(product)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody CreateNewProductRequest request) {
        var product = productMapper.toEntity(request);
        product.setCategory(categoryRepository.findById(request.getCategoryId())
                .orElse(null));
        productRepository.save(product);
        var productDto = productMapper.toDto(product);
        return productDto;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id") int id,
                                                    @RequestBody ProductDto productDto) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productMapper.update(productDto, product);
        productRepository.save(product);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }
}
