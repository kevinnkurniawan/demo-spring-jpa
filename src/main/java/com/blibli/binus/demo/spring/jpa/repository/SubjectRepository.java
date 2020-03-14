package com.blibli.binus.demo.spring.jpa.repository;

import com.blibli.binus.demo.spring.jpa.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

  Subject findById(Long id);

  Subject findByCode(String code);
}
