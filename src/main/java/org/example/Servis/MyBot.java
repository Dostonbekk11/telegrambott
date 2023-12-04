package org.example.Servis;


import org.example.handler.UpdateHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.Servis.BotConfig.BOT_TOKEN;
import static org.example.Servis.BotConfig.BOT_USERNAME;

public class MyBot extends TelegramLongPollingBot {



    public  MyBot(){
        super(BOT_TOKEN);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        UpdateHandler.handle(update, this);
    }
}
