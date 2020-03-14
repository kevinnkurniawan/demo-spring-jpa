package com.blibli.binus.demo.spring.jpa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassScheduleRequest {
  private Long id;
  private String name;
  private String code;
  private Date date;
  private String nim;
  private String subjectCode;
}
