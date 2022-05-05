package com.example.demo.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequest {

  @NotBlank(message = "Name can't be empty")
  private String name;

  private String description;

  @NotNull(message = "Price can't be null")
  @Min(value = 0, message = "Price can't be negative")
  private Float price;

  @NotNull(message = "Price can't be null")
  @Min(value = 0, message = "Stock can't be negative")
  private Integer stock;

}
