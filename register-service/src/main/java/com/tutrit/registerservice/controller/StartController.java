package com.tutrit.registerservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StartController {

  @GetMapping("/register-user/{text}/{id}")
  public void start(@PathVariable String text, @PathVariable String id) {
    log.info("Message {} form chatId {} received:", text, id);
  }
}
