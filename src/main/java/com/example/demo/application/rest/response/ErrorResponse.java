package com.example.demo.application.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

  private int statusCode;
  private String message;
  @JsonInclude(Include.NON_EMPTY)
  private List<String> moreInfo;

}
