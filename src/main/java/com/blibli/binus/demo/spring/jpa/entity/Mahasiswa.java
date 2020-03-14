package com.blibli.binus.demo.spring.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "mahasiswa")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nim"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mahasiswa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nim")
  private String nim;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "mahasiswa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<ClassSchedule> classSchedules = new ArrayList<>();

}
