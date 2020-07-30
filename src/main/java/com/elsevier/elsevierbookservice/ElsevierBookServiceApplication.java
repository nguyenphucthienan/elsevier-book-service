package com.elsevier.elsevierbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ElsevierBookServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElsevierBookServiceApplication.class, args);
  }
}
