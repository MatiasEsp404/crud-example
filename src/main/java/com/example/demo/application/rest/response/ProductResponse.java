package com.example.demo.application.rest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponse {

  private Long id;
  private String name;
  private String description;
  private Float price;
  private Integer stock;

}
