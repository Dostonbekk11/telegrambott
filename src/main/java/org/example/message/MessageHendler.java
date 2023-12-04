package org.example.message;

import org.example.command.CommandHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageHendler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        if (message.isCommand()) {
            CommandHandler.handle(message, bot);
        } else if (message.hasText()) {
            TextHandler.handle(message, bot);
        }
    }
}