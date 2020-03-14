package com.blibli.binus.demo.spring.jpa.repository;

import com.blibli.binus.demo.spring.jpa.entity.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, String> {

  ClassSchedule findByCode(String code);

  List<ClassSchedule> findByMahasiswa_Nim(String nim);

  List<ClassSchedule> findBySubject_Code(String code);
}
