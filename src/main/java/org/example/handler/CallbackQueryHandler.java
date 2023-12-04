package org.example.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

import static org.example.Servis.ButtonProps.*;

public class CallbackQueryHandler {
    @SneakyThrows
    public static void handle(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot){

        String data = callbackQuery.getData();



            switch (data) {
                case "kanal"->{



                }

                case "tekshirish" -> {
                    ReplyKeyboardMarkup MENU = ReplyKeyboardMarkup.builder()
                            .keyboardRow(new KeyboardRow(
                                    List.of(KeyboardButton.builder().text(PUL_ISHLASH).build())
                            )).keyboardRow(new KeyboardRow(
                                    List.of(
                                            KeyboardButton.builder().text(BALANS).build()
                                    ))).keyboardRow(new KeyboardRow(
                                    List.of(
                                            KeyboardButton.builder().text(PUL_YECHISH).build()
                                    ))).keyboardRow(new KeyboardRow(
                                    List.of(
                                            KeyboardButton.builder().text(STATISTIKA).build()
                                    )))
                            .resizeKeyboard(true)
                            .build();
                    SendMessage sendMessage = new SendMessage(callbackQuery.getMessage().getChatId().toString(),
                            "\uD83D\uDDA5 Asosiy menyudasiz.");
                    sendMessage.setReplyMarkup(MENU);
                    bot.execute(sendMessage);
                }
            }

    }
}
