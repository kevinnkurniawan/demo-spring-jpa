package com.blibli.binus.demo.spring.jpa.service.impl;

import com.blibli.binus.demo.spring.jpa.entity.ClassSchedule;
import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;
import com.blibli.binus.demo.spring.jpa.entity.Subject;
import com.blibli.binus.demo.spring.jpa.repository.ClassScheduleRepository;
import com.blibli.binus.demo.spring.jpa.service.api.ClassScheduleService;
import com.blibli.binus.demo.spring.jpa.service.api.MahasiswaService;
import com.blibli.binus.demo.spring.jpa.service.api.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {

  @Autowired
  private ClassScheduleRepository classScheduleRepository;

  @Autowired
  private MahasiswaService mahasiswaService;

  @Autowired
  private SubjectService subjectService;

  @Override
  public ClassSchedule findByCode(String code) {
    return this.classScheduleRepository.findByCode(code);
  }

  @Override
  public List<ClassSchedule> findByMahasiswaNim(String nim) {
    return this.classScheduleRepository.findByMahasiswa_Nim(nim);
  }

  @Override
  public List<ClassSchedule> findBySubjectCode(String subjectCode) {
    return this.classScheduleRepository.findBySubject_Code(subjectCode);
  }

  @Override
  public void insert(ClassSchedule classSchedule, String nim, String subjectCode) {
    Mahasiswa mahasiswa = this.mahasiswaService.findByNim(nim);
    Subject subject = this.subjectService.findByCode(subjectCode);
    classSchedule.setMahasiswa(mahasiswa);
    classSchedule.setSubject(subject);

    this.classScheduleRepository.save(classSchedule);
  }


  @Override
  public void update(ClassSchedule classSchedule, String nim, String subjectCode) {
    ClassSchedule existing = this.findByCode(classSchedule.getCode());
    Mahasiswa mahasiswa = this.mahasiswaService.findByNim(nim);
    Subject subject = this.subjectService.findByCode(subjectCode);
    BeanUtils.copyProperties(classSchedule, existing, "id", "code", "mahasiswa", "subject");

    existing.setMahasiswa(mahasiswa);
    existing.setSubject(subject);

    this.classScheduleRepository.save(existing);
  }

  @Override
  public void delete(String code) {
    ClassSchedule classSchedule = this.findByCode(code);
    this.classScheduleRepository.delete(classSchedule);
  }
}
