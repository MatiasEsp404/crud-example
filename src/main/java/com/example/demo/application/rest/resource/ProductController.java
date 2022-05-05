package com.example.demo.application.rest.resource;

import com.example.demo.application.rest.request.ProductRequest;
import com.example.demo.application.rest.response.ProductResponse;
import com.example.demo.application.service.abstraction.IProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

  @Autowired
  private IProductService productService;

  //Create
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest productRequest) {

    ProductResponse productResponse = productService.create(productRequest);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(productResponse.getId())
        .toUri();

    return ResponseEntity.created(location).body(productResponse);
  }

  //Read
  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductResponse> read(@PathVariable Long id) {

    ProductResponse productResponse = productService.read(id);

    return ResponseEntity.ok().body(productResponse);

  }

  //Update
  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductResponse> update(@PathVariable Long id,
      @Valid @RequestBody ProductRequest productRequest) {

    ProductResponse productResponse = productService.update(id, productRequest);

    return ResponseEntity.ok().body(productResponse);

  }

  //Deleted
  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@PathVariable Long id){
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }


}
