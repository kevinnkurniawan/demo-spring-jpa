package com.blibli.binus.demo.spring.jpa.service.api;

import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;

public interface MahasiswaService {

  Mahasiswa findById(Long id);

  Mahasiswa findByNim(String nim);

  void insert(Mahasiswa mahasiswa);

  void insertWithRequiredTransaction(Mahasiswa mahasiswa);

  void delete(String nim);

  void update(Mahasiswa mahasiswa);
}
