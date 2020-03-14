package com.blibli.binus.demo.spring.jpa.controller;

import com.blibli.binus.demo.spring.jpa.entity.ClassSchedule;
import com.blibli.binus.demo.spring.jpa.request.ClassScheduleRequest;
import com.blibli.binus.demo.spring.jpa.response.BaseResponse;
import com.blibli.binus.demo.spring.jpa.response.ClassScheduleResponse;
import com.blibli.binus.demo.spring.jpa.service.api.ClassScheduleService;
import com.blibli.binus.demo.spring.jpa.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClassScheduleController {
  
  @Autowired
  private ClassScheduleService classScheduleService;

  @PostMapping("/api/classSchedule/insert")
  public BaseResponse insert(@RequestBody ClassScheduleRequest request) {
    ClassSchedule classSchedule = Converter.convertClassScheduleRequestToClassSchedule(request);
    try {
      this.classScheduleService.insert(classSchedule, request.getNim(), request.getSubjectCode());
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @GetMapping("/api/classSchedule/findByCode")
  public ClassScheduleResponse findByCode(@RequestParam String code) {
    ClassSchedule classSchedule = this.classScheduleService.findByCode(code);
    return Converter.convertClassScheduleToClassScheduleResponse(classSchedule);
  }

  @GetMapping("/api/classSchedule/findByNim")
  public List<ClassScheduleResponse> findByNim(@RequestParam String nim) {
    List<ClassSchedule> classSchedule = this.classScheduleService.findByMahasiswaNim(nim);
    return classSchedule.stream()
        .map(Converter::convertClassScheduleToClassScheduleResponse)
        .collect(Collectors.toList());
  }

  @PutMapping("/api/classSchedule/update")
  public BaseResponse update(@RequestBody ClassScheduleRequest request) {
    try {
      this.classScheduleService.update(
          Converter.convertClassScheduleRequestToClassSchedule(request), request.getNim(),
          request.getSubjectCode());
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @DeleteMapping("/api/classSchedule/delete")
  public BaseResponse delete(@RequestParam String code) {
    try {
      this.classScheduleService.delete(code);
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }
}
