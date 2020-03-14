package com.blibli.binus.demo.spring.jpa.repository;

import com.blibli.binus.demo.spring.jpa.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String> {

  Mahasiswa findById(Long id);

  Mahasiswa findByNim(String nim);
}
