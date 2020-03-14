package com.blibli.binus.demo.spring.jpa.controller;

import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;
import com.blibli.binus.demo.spring.jpa.request.MahasiswaRequest;
import com.blibli.binus.demo.spring.jpa.response.BaseResponse;
import com.blibli.binus.demo.spring.jpa.response.MahasiswaResponse;
import com.blibli.binus.demo.spring.jpa.service.api.MahasiswaService;
import com.blibli.binus.demo.spring.jpa.service.api.TestTransactionalService;
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
public class MahasiswaController {

  @Autowired
  private MahasiswaService mahasiswaService;

  @Autowired
  private TestTransactionalService testTransactionalService;

  @PostMapping("/api/mahasiswa/insert")
  public BaseResponse insert(@RequestBody MahasiswaRequest request) {
    Mahasiswa mahasiswa = Converter.convertMahasiswaRequestToMahasiswa(request);
    try {
      this.mahasiswaService.insert(mahasiswa);
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @GetMapping("/api/mahasiswa/findByNim")
  public MahasiswaResponse findByNim(@RequestParam String nim) {
    Mahasiswa mahasiswa = this.mahasiswaService.findByNim(nim);
    return Converter.convertMahasiswaToMahasiswaResponse(mahasiswa);
  }

  @PutMapping("/api/mahasiswa/update")
  public BaseResponse update(@RequestBody MahasiswaRequest request) {
    try {
      this.mahasiswaService.update(Converter.convertMahasiswaRequestToMahasiswa(request));
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @DeleteMapping("/api/mahasiswa/delete")
  public BaseResponse delete(@RequestParam String nim) {
    try {
      this.mahasiswaService.delete(nim);
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }

  @PostMapping("/api/test-transactional")
  public BaseResponse testTransactional() {
    try {
      this.testTransactionalService.insertMahasiswaAndSubject();
      return new BaseResponse(Boolean.TRUE, null);
    } catch (Exception ex) {
      return new BaseResponse(Boolean.FALSE, ex.getMessage());
    }
  }
}
