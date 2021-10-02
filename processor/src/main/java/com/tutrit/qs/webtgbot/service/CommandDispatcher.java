package com.tutrit.qs.webtgbot.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommandDispatcher {
  CommandContext context;

  public void dispatch(final Update update) {
    if (context.containsCommand(update)) {
      try {
        context.execute(update);
      } catch (Exception e) {

      }
    }
  }
}
