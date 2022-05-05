package com.example.demo.application.service.abstraction;

import com.example.demo.application.rest.request.ProductRequest;
import com.example.demo.application.rest.response.ProductResponse;

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
