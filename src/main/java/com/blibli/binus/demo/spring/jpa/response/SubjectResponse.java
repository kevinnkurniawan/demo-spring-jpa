package com.blibli.binus.demo.spring.jpa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectResponse {

  private Long id;
  private String code;
  private String name;
}