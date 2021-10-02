package com.tutrit.qs.webtgbot;

import com.tutrit.qs.webtgbot.service.CommandContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class Application {

  public static ConfigurableApplicationContext ctx;

  public static void main(String[] args) {
    ctx = SpringApplication.run(Application.class, args);
    ctx.getBean(CommandContext.class).loadCommands();
  }
}
