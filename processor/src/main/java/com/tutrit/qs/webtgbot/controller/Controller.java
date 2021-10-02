package com.tutrit.qs.webtgbot.controller;

import com.tutrit.qs.webtgbot.annotations.BotCommand;
import com.tutrit.qs.webtgbot.client.RegisterServiceClient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Controller {
  RegisterServiceClient registerServiceClient;

  @BotCommand("/start")
  public void start(Update update) {
    String text = update.getMessage().getText();
    Long chatId = update.getMessage().getChatId();
    registerServiceClient.setStartInfo(text, chatId);
  }
}
