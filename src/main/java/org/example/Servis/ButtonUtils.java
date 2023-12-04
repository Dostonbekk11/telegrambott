package org.example.Servis;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonUtils {


    public static final InlineKeyboardMarkup
            START_MARKUP = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
            InlineKeyboardButton.builder().text("➕1-obuna b'lish")
                    .url("https://t.me/+QUELWTGD1uEyZDFi").callbackData("kanal").build()

    )).keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Tekshirish").callbackData("tekshirish").build()
            )).build();


}
