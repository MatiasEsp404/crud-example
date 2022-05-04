package com.example.demo.mapper;

import com.example.demo.entity.ProductEntity;
import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductEntity toProductEntity(ProductRequest productRequest) {
    return ProductEntity.builder()
        .name(productRequest.getName())
        .description(productRequest.getDescription())
        .price(productRequest.getPrice())
        .stock(productRequest.getStock())
        .build();
  }

  public ProductResponse toProductResponse(ProductEntity productEntity) {
    return ProductResponse.builder()
        .id(productEntity.getId())
        .name(productEntity.getName())
        .description(productEntity.getDescription())
        .price(productEntity.getPrice())
        .stock(productEntity.getStock())
        .build();
  }
}
