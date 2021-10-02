package com.tutrit.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RegisterServiceApplication {
  public static ConfigurableApplicationContext ctx;

  public static void main(String[] args) {
    ctx = SpringApplication.run(RegisterServiceApplication.class, args);
  }
}
