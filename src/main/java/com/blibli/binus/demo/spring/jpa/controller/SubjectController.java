package com.blibli.binus.demo.spring.jpa.controller;

import com.blibli.binus.demo.spring.jpa.entity.Subject;
import com.blibli.binus.demo.spring.jpa.request.SubjectRequest;
import com.blibli.binus.demo.spring.jpa.response.BaseResponse;
import com.blibli.binus.demo.spring.jpa.response.SubjectResponse;
import com.blibli.binus.demo.spring.jpa.service.api.SubjectService;
import com.blibli.binus.demo.spring.jpa.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @PostMapping("/api/subject/insert")
  public BaseResponse insert(@RequestBody SubjectRequest request) {
    Subject subject = Converter.convertSubjectRequestToSubject(request);
    try {
      this.subjectService.insert(subject);
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @GetMapping("/api/subject/findByCode")
  public SubjectResponse findByCode(@RequestParam String code) {
    Subject subject = this.subjectService.findByCode(code);
    return Converter.convertSubjectToSubjectResponse(subject);
  }

  @PutMapping("/api/subject/update")
  public BaseResponse update(@RequestBody SubjectRequest request) {
    try {
      this.subjectService.update(Converter.convertSubjectRequestToSubject(request));
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @DeleteMapping("/api/subject/delete")
  public BaseResponse delete(@RequestParam String code) {
    try {
      this.subjectService.delete(code);
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }
}
