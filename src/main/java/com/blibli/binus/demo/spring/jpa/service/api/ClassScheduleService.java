package com.blibli.binus.demo.spring.jpa.service.api;

import com.blibli.binus.demo.spring.jpa.entity.ClassSchedule;

import java.util.List;

public interface ClassScheduleService {

  ClassSchedule findByCode(String code);

  List<ClassSchedule> findByMahasiswaNim(String nim);

  List<ClassSchedule> findBySubjectCode(String subjectCode);

  void insert(ClassSchedule classSchedule, String nim, String subjectCode);

  void update(ClassSchedule classSchedule, String nim, String subjectCode);

  void delete(String code);

}
