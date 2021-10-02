package com.tutrit.qs.webtgbot.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RegisterServiceClient {

  public void setStartInfo(String text, Long chatId) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getForEntity(String.format(
        "http://localhost:8080/register-user/%s/%s",
        text,
        chatId), Void.class);
  }
}
