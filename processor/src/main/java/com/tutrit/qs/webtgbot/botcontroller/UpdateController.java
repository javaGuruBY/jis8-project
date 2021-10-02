package com.tutrit.qs.webtgbot.botcontroller;

import com.tutrit.qs.webtgbot.proxy.BotProxy;
import com.tutrit.qs.webtgbot.service.CommandDispatcher;
import com.tutrit.qs.webtgbot.service.RequestDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UpdateController {
    private final ServerProperties serverProperties;
    private final BotProxy botProxy;
    private final CommandDispatcher commandDispatcher;

    @PostMapping("/onUpdate")
    public void onUpdateReceived(@RequestBody Update update) {
        commandDispatcher.dispatch(update);
    }
}
