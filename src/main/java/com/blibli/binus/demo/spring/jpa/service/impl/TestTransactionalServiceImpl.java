package com.blibli.binus.demo.spring.jpa.service.impl;

import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;
import com.blibli.binus.demo.spring.jpa.entity.Subject;
import com.blibli.binus.demo.spring.jpa.service.api.MahasiswaService;
import com.blibli.binus.demo.spring.jpa.service.api.SubjectService;
import com.blibli.binus.demo.spring.jpa.service.api.TestTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestTransactionalServiceImpl implements TestTransactionalService {

  @Autowired
  private MahasiswaService mahasiswaService;

  @Autowired
  private SubjectService subjectService;

  /*
    this method is marked as 1 transaction (see the annotation @Transactional on top of this class name)
    in this case, this method will throw exception when trying to insert mahasiswa because of some problems in MahasiswaService.insertWithRequiredTransaction
    but the subject will be succesfully inserted since it's created new transaction
    thus only mahasiswa will be rollback-ed (not saved)
  */

  @Override
  public void insertMahasiswaAndSubject() {
    Subject subject = new Subject();
    subject.setCode("code-transactional");
    subject.setName("name-transactional");
    this.subjectService.insertWithRequiresNewTransaction(subject);

    Mahasiswa mahasiswa = new Mahasiswa();
    mahasiswa.setName("name-transactional");
    mahasiswa.setNim("nim-transactional");
    this.mahasiswaService.insertWithRequiredTransaction(mahasiswa);
  }
}
