package com.blibli.binus.demo.spring.jpa.util;

import com.blibli.binus.demo.spring.jpa.entity.ClassSchedule;
import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;
import com.blibli.binus.demo.spring.jpa.entity.Subject;
import com.blibli.binus.demo.spring.jpa.request.ClassScheduleRequest;
import com.blibli.binus.demo.spring.jpa.request.MahasiswaRequest;
import com.blibli.binus.demo.spring.jpa.request.SubjectRequest;
import com.blibli.binus.demo.spring.jpa.response.ClassScheduleResponse;
import com.blibli.binus.demo.spring.jpa.response.MahasiswaResponse;
import com.blibli.binus.demo.spring.jpa.response.SubjectResponse;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.stream.Collectors;

public class Converter {
  public static Mahasiswa convertMahasiswaRequestToMahasiswa(MahasiswaRequest request) {
    Mahasiswa mahasiswa = new Mahasiswa();
    BeanUtils.copyProperties(request, mahasiswa);
    return mahasiswa;
  }

  public static MahasiswaResponse convertMahasiswaToMahasiswaResponse(Mahasiswa mahasiswa) {
    MahasiswaResponse response = new MahasiswaResponse();
    BeanUtils.copyProperties(Optional.ofNullable(mahasiswa)
        .orElse(new Mahasiswa()), response);
    return response;
  }
  
  public static Subject convertSubjectRequestToSubject(SubjectRequest request) {
    Subject subject = new Subject();
    BeanUtils.copyProperties(request, subject);
    return subject;
  }

  public static SubjectResponse convertSubjectToSubjectResponse(Subject subject) {
    SubjectResponse response = new SubjectResponse();
    BeanUtils.copyProperties(Optional.ofNullable(subject)
        .orElse(new Subject()), response);

    return response;
  }

  public static ClassSchedule convertClassScheduleRequestToClassSchedule(ClassScheduleRequest request) {
    ClassSchedule classSchedule = new ClassSchedule();
    BeanUtils.copyProperties(request, classSchedule);
    return classSchedule;
  }

  public static ClassScheduleResponse convertClassScheduleToClassScheduleResponse(ClassSchedule classSchedule) {
    ClassScheduleResponse response = new ClassScheduleResponse();
    BeanUtils.copyProperties(Optional.ofNullable(classSchedule)
        .orElse(new ClassSchedule()), response);
    response.setMahasiswa(convertMahasiswaToMahasiswaResponse(classSchedule.getMahasiswa()));
    response.setSubject(convertSubjectToSubjectResponse(classSchedule.getSubject()));
    return response;
  }
}
