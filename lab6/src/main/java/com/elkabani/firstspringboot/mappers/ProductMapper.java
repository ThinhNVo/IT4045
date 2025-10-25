package com.elkabani.firstspringboot.mappers;

import com.elkabani.firstspringboot.dtos.CreateNewProductRequest;
import com.elkabani.firstspringboot.dtos.ProductDto;
import com.elkabani.firstspringboot.dtos.UpdateProductRequest;
import com.elkabani.firstspringboot.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    Product toEntity(CreateNewProductRequest request);

    @Mapping(target="id", ignore = true)
    void update(ProductDto productDto, @MappingTarget Product product);
}
