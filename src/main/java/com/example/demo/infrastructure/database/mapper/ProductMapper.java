package com.example.demo.infrastructure.database.mapper;

import com.example.demo.infrastructure.database.entity.ProductEntity;
import com.example.demo.application.rest.request.ProductRequest;
import com.example.demo.application.rest.response.ProductResponse;
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
