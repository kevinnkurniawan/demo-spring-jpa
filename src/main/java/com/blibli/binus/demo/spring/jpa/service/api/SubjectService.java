package com.blibli.binus.demo.spring.jpa.service.api;

import com.blibli.binus.demo.spring.jpa.entity.Subject;

public interface SubjectService {
  Subject findById(Long id);

  Subject findByCode(String code);

  void insert(Subject subject);

  void insertWithRequiresNewTransaction(Subject subject);

  void delete(String code);

  void update(Subject subject);

}
