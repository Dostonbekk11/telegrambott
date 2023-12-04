package org.example.command;

import lombok.SneakyThrows;
import org.example.Servis.ButtonUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CommandHandler {
    @SneakyThrows
    public static void handle(final Message message, final TelegramLongPollingBot bot) {

        switch (CommandEnum.of(message.getText())) {
            case START -> handleCommandStart(message, bot);
            case HELP -> handleCommandHelp(message, bot);
//            case Pul -> handleCommandPul(message, bot);
        }
    }



    private static void handleCommandHelp(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(),"❓Botda qanday qilib pul ishlayman?\n" +
                "— Botga do'stlaringizni taklif qiling va har 1ta yangi taklif qilgan do'stlaringizga 1500 so'mdan balansingizga qo'shiladi.\n" +
                "    \n" +
                "❓Pulni qanday qilib olish mumkin?\n" +
                "— Botda ishlagan pullaringizni plastik kartangizga chiqarib olishingiz mumkin (UzCard, Humo).\n" +
                "    yoki telefon raqmizga.misol(+998*********)\n" +
                "\uD83D\uDC65 Referal qachon aktiv xolatga o'tadi?\n" +
                "— Siz chaqirgan do'stingiz bizning Botda ro'yxatdan o'tkandan so'ng sizning referalingiz hisoblanadi va sizning balansingizga pul tushadi!\n" +
                "    \n" +
                "\uD83D\uDCCD Nakrutka qilinsa blokka tushasiz!\n" +
                "    \n" +
                "✅ To'lovlar soni cheklanmagan, xohlaganingizcha shartlarni bajaring va pul ishlang!\n" +
                "    \n" +
                "Yordam uchun\n" +
                "\uD83D\uDCF2 @s_dostonbek");
             bot.execute(sendMessage);
    }

    @SneakyThrows
    public static void handleCommandStart(final Message message, final TelegramLongPollingBot bot) {
        bot.execute(
                SendMessage.builder().chatId(message.getChatId())
                        .text("Assalomu alaykum! Botimizga xush kelibsiz!\n"  +
                                "                        \"Pul ishlashni boshlash uchun pasdagi havola orqali kanalga obuna bo'ling! keyin (Tekshirish) tugmasin bosing✅\n"  +
                                "                        \"Kanalga qo'shilganiz uchun sizga 2500.00 so'm pul taqdim etiladi")
                        .replyMarkup(ButtonUtils.START_MARKUP)
                        .build()
        );

    }

}


