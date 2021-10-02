package com.tutrit.qs.webtgbot.botcontroller;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.objects.Update;

@SpringBootTest
class UpdateControllerTest {

  @Autowired
  UpdateController updateController;
  @Autowired
  ObjectMapper objectMapper;

  @Test
  void onUpdateReceived() throws IOException {
    Update update = objectMapper.readValue(new File("src/test/resources/commands/update_start.json"), Update.class);
    updateController.onUpdateReceived(update);
  }
}