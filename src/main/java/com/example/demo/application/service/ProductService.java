package com.example.demo.application.service;

import com.example.demo.infrastructure.database.entity.ProductEntity;
import com.example.demo.application.exception.EntityNotFoundException;
import com.example.demo.infrastructure.database.mapper.ProductMapper;
import com.example.demo.infrastructure.database.repository.ProductRepository;
import com.example.demo.application.rest.request.ProductRequest;
import com.example.demo.application.rest.response.ProductResponse;
import com.example.demo.application.service.abstraction.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  @Override
  public ProductResponse create(ProductRequest productRequest) {
    ProductEntity productEntity = productMapper.toProductEntity(productRequest);
    productEntity = productRepository.save(productEntity);
    return productMapper.toProductResponse(productEntity);
  }

  @Override
  public ProductResponse read(Long id) {
    checkIfExist(id);
    ProductEntity productEntity = productRepository.getById(id);
    return productMapper.toProductResponse(productEntity);
  }

  @Override
  public ProductResponse update(Long id, ProductRequest productRequest) {
    checkIfExist(id);
    ProductEntity productEntity = productMapper.toProductEntity(productRequest);
    productEntity.setId(id);
    productEntity = productRepository.save(productEntity);
    return productMapper.toProductResponse(productEntity);
  }

  @Override
  public void delete(Long id) {
    checkIfExist(id);
    productRepository.deleteById(id);
  }

  private void checkIfExist(Long id) {
    if (!productRepository.existsById(id)) {
      throw new EntityNotFoundException("Product not found");
    }
  }

}
