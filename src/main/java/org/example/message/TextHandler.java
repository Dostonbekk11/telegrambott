package org.example.message;

import lombok.SneakyThrows;
import org.example.Servis.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.example.Servis.ButtonProps.*;

public class TextHandler {
    private static String generateReferralLink(String botUsername, String referralCode) {
        return "https://t.me/" + botUsername + "?start=" + referralCode;
    }

    @SneakyThrows
    public static void handle( final Message message, final TelegramLongPollingBot bot) {
        handleReplyMarkup( message, bot);
    }

    private static void handleReplyMarkup( Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        switch (message.getText()) {
            case PUL_ISHLASH -> handlPulishlash( message, bot);
            case BALANS -> handlBalans(message, bot);
            case PUL_YECHISH -> handlPulYechish(message, bot);
            case STATISTIKA -> handlStatistika(message, bot);
        }
    }

    private static void handlStatistika(Message message, TelegramLongPollingBot bot) {
        Long chatId = message.getChatId();


        List<User> users = new ArrayList<>();


        StringBuilder topUsers = new StringBuilder("🏆 TOP 5 ta eng koʻp pul ishlagan foydalanuvchilar:\n");
        for (int i = 0; i < 5; i++) {
            topUsers.append(i + 1).append(". ").append(users.get(i)).append("\n");
        }

        double totalAmount = users.stream().mapToDouble(User::getAmount).sum();
        topUsers.append("\n💳 Umumiy to'langan mablag: ").append(totalAmount).append(" soʻm\n");
        topUsers.append("📊 Botdagi foydalanuvchilar soni: ").append(users.size()).append(" odam");

        SendMessage sendMessage = new SendMessage(chatId.toString(), topUsers.toString());
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private static void handlPulYechish(Message message, TelegramLongPollingBot bot) {

        int hisobingiz = 0;


        String userMessage = message.getText();


        if (userMessage.equals("Pul yechish \uD83D\uDCB3")) {

            SendMessage sendMessage = getSendMessage(message, hisobingiz);

                bot.execute(sendMessage);
        } else if (userMessage.equals("Pulni yechish")) {
            if (hisobingiz >= 50000) {
                hisobingiz -= 50000;

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(message.getChatId().toString());
                sendMessage.setText("Pul muvaffaqiyatli yechildi. Yangi hisobingiz miqdori: " + hisobingiz + " so’m");


                bot.execute(sendMessage);

            } else {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(message.getChatId().toString());
                sendMessage.setText("Kechirasiz, hisobingizda minimal pul miqdori bo'lmagani uchun pul yechish amalga oshmadi.");


                bot.execute(sendMessage);

            }
        }
    }

    private static SendMessage getSendMessage(Message message, int hisobingiz) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Pulni yechish");
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("💰 Hisobingiz: " + hisobingiz + " so’m\n\n" +
                "📥 Hisobingizdagi pulni yechish uchun pastdagi tugmani bosing.");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @SneakyThrows
    private static void handlBalans(Message message, TelegramLongPollingBot bot) {
        Long chatId = message.getChatId();
        String receivedMessage = message.getText();


        String userId = String.valueOf(chatId);


        int asosiyBalans = 0;
        int takliflarSon = 0;
        int yechibOlganPul = 0;


        String responseMessage = "🔑 Sizning ID raqamingiz: " + userId + "\n" +
                "💵 Asosiy balansingiz: " + asosiyBalans + " Soʻm\n" +
                "👤 Takliflaringiz soni: " + takliflarSon + " ta\n" +
                "💳 Yechib olgan pullaringiz: " + yechibOlganPul + " Soʻm";


        SendMessage sendMessage = new SendMessage(chatId.toString(), responseMessage);

        bot.execute(sendMessage);
    }



    private static User getUserFromDatabase(Long chatId) {
    return null;
    }



    @SneakyThrows
    private static void handlPulishlash(final Message message, TelegramLongPollingBot bot) {
        Long chatId = message.getChatId();
        String receivedMessage = message.getText();


        String filePath = "src/main/java/org/resources/photo_2023-11-29_18-11-16.jpg";


        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId.toString());
        sendPhoto.setPhoto(new InputFile(new File(filePath)));


            bot.execute(sendPhoto);

        if (receivedMessage.equals("Pul ishlash\uD83D\uDCB8")) {
            String botUsername = "gamma_app_bot";
            String referralCode = String.valueOf(chatId);

            String referralLink = generateReferralLink(botUsername, referralCode);

            try {
                bot.execute(new SendMessage(
                        chatId.toString(),
                        "Do'stlaringizni taklif qilish uchun quyidagi havolani ulashing: " + referralLink + "\nhar bita do'stingiz uchun 1500 so'm pul hisobizga qoshiladi."

                ));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }







    @SneakyThrows
        private static void referall(Update update, TelegramLongPollingBot bot) {
            Message message = update.getMessage();
            handlPulishlash(message, bot);
        }


}



