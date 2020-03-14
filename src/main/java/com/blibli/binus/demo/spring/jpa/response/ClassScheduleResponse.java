package com.blibli.binus.demo.spring.jpa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassScheduleResponse {
  private Long id;
  private String name;
  private String code;
  private Date date;
  private SubjectResponse subject;
  private MahasiswaResponse mahasiswa;
}
