package com.example.demo.service.abstraction;

import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;

public interface IProductService {

  //Create
  ProductResponse create(ProductRequest productRequest);

  //Read
  ProductResponse read(Long id);

  //Update
  ProductResponse update(Long id, ProductRequest productRequest);

  //Delete
  void delete(Long id);

}
