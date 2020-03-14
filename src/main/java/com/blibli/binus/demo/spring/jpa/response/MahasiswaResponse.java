package com.blibli.binus.demo.spring.jpa.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MahasiswaResponse {
  private Long id;
  private String nim;
  private String name;
}
