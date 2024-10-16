package com.example.productservice.mapper;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {


    @Mapping(target = "availability", expression = "java(0)")
    public abstract ProductDTO toDto(Product product);
}
