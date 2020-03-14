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

@Entity(name = "subject")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "code")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<ClassSchedule> classSchedules = new ArrayList<>();
}
