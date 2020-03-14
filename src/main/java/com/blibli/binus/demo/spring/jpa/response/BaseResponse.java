package com.blibli.binus.demo.spring.jpa.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

  private boolean success;
  private String errorMessage;
}
