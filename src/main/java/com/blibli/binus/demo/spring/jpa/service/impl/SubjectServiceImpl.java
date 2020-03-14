package com.blibli.binus.demo.spring.jpa.service.impl;

import com.blibli.binus.demo.spring.jpa.entity.Subject;
import com.blibli.binus.demo.spring.jpa.repository.SubjectRepository;
import com.blibli.binus.demo.spring.jpa.service.api.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  public Subject findById(Long id) {
    return this.subjectRepository.findById(id);
  }

  @Override
  public Subject findByCode(String code) {
    return this.subjectRepository.findByCode(code);
  }

  @Override
  public void insert(Subject subject) {
    this.subjectRepository.save(subject);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void insertWithRequiresNewTransaction(Subject subject) {
    this.subjectRepository.save(subject);
  }

  @Override
  public void delete(String code) {
    Subject subject = this.findByCode(code);
    this.subjectRepository.delete(subject);
  }

  @Override
  public void update(Subject subject) {
    Subject existing = this.findByCode(subject.getCode());
    BeanUtils.copyProperties(subject, existing, "id", "code");
    this.subjectRepository.save(existing);
  }
}
