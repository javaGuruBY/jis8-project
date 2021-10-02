package com.tutrit.qs.webtgbot.service;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

import com.tutrit.qs.webtgbot.annotations.BotCommand;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class CommandContext {

  private final ConfigurableApplicationContext ctx;
  private static Map<String, Method> commands;

  public CommandContext(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  public void execute(Update update) throws InvocationTargetException, IllegalAccessException {
    String command = update.getMessage().getText();
    Method method = commands.get(command);
    Object obj = ctx.getBean(method.getDeclaringClass());
    Object result = method.invoke(obj, update);
  }

  public boolean containsCommand(Update update) {
    if (commands == null) {
      loadCommands();
    }
    return commands.containsKey(update.getMessage().getText());
  }

  public void loadCommands() {
    commands = stream(ctx.getBeanDefinitionNames())
        .map(name -> ctx.getBean(name))
        .map(obj -> obj.getClass())
        .flatMap(clazz -> stream(clazz.getDeclaredMethods()))
        .filter(method -> method.isAnnotationPresent(BotCommand.class))
        .collect(toMap(method -> method.getAnnotation(BotCommand.class).value(), method -> method));
  }
}
