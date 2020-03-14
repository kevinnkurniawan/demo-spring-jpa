package com.blibli.binus.demo.spring.jpa.service.impl;

import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;
import com.blibli.binus.demo.spring.jpa.repository.MahasiswaRepository;
import com.blibli.binus.demo.spring.jpa.service.api.MahasiswaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

  @Autowired
  private MahasiswaRepository mahasiswaRepository;

  @Override
  public Mahasiswa findById(Long id) {
    return this.mahasiswaRepository.findById(id);
  }

  @Override
  public Mahasiswa findByNim(String nim) {
    return this.mahasiswaRepository.findByNim(nim);
  }

  @Override
  public void insert(Mahasiswa mahasiswa) {
    this.mahasiswaRepository.save(mahasiswa);
  }

  /*
    this method will throw exception, because trying to save null object
  */
  @Override
  @Transactional
  public void insertWithRequiredTransaction(Mahasiswa mahasiswa) {
    this.mahasiswaRepository.save(null);
  }

  @Override
  public void delete(String nim) {
    Mahasiswa mahasiswa = this.findByNim(nim);
    this.mahasiswaRepository.delete(mahasiswa);
  }

  @Override
  public void update(Mahasiswa mahasiswa) {
    Mahasiswa existing = this.findByNim(mahasiswa.getNim());
    BeanUtils.copyProperties(mahasiswa, existing, "id", "nim");
    this.mahasiswaRepository.save(existing);
  }
}
