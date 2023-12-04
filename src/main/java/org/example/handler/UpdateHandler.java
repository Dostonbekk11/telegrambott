package org.example.handler;

import org.example.message.MessageHendler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateHandler {
    public static void handle(final Update update, final TelegramLongPollingBot bot) {
        if (update.hasMessage()) {
            MessageHendler.handle(update.getMessage(), bot);
        } else if (update.hasCallbackQuery()) {
            CallbackQueryHandler.handle(update.getCallbackQuery(), bot);
        }
    }
}
