package ru.ttr843.telegrambotparser;


import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import ru.ttr843.telegrambotparser.bot.TelegramBot;

/**
 * 22.07.2020
 * TelegramBotInitializer
 *
 * @author Ruslan Pashin
 * High school ITIS
 * @version v1.0
 */
public class TelegramBotInitializer {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramBot());
        } catch (TelegramApiRequestException e) {
            throw new IllegalStateException(e);
        }
    }
}