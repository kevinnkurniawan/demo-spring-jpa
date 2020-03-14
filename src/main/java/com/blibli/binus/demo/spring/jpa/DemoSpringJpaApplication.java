package com.blibli.binus.demo.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = {"com.blibli.binus"})
@EnableJpaRepositories(basePackages = {"com.blibli.binus"})
public class DemoSpringJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringJpaApplication.class, args);
  }

}
