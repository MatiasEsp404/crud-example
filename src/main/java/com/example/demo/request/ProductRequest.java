package com.example.demo.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequest {

  //TODO Validation errors need to be developed

  @NotBlank(message = "Name cannot be empty")
  private String name;

  private String description;

  @Min(value = 0, message = "Price cannot be negative")
  private Float price;

  @Min(value = 0, message = "Stock cannot be negative")
  private Integer stock;

}
