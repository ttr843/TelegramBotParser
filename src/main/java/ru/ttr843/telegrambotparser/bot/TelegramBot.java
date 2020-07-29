package ru.ttr843.telegrambotparser.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import ru.ttr843.telegrambotparser.dto.MessageDto;
import ru.ttr843.telegrambotparser.service.UploadInfoIntoSpreadSheetServiceImpl;

import java.time.Instant;
import java.util.Date;

/**
 * 22.07.2020
 * TelegramBot
 *
 * @author Ruslan Pashin
 * High school ITIS
 * @version v1.0
 */
public class TelegramBot extends TelegramLongPollingBot {

    /**
     * Global instance of the BOT_NAME
     */
    private static final String BOT_NAME = "write your bot_name here";

    /**
     * Global instance of the BOT_TOKEN
     */
    private static final String BOT_TOKEN = "Write your bot_token here";


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Instant instant = Instant.ofEpochSecond(update.getMessage().getDate());
        Date date = Date.from(instant);
        MessageDto messageDto;
        if (update.getMessage().getFrom().getLastName() == null) {
            messageDto = MessageDto.builder()
                    .firstName(update.getMessage().getFrom().getFirstName())
                    .lastName("")
                    .nickname(update.getMessage().getFrom().getUserName())
                    .date(date)
                    .text(update.getMessage().getText())
                    .build();
        } else {
            messageDto = MessageDto.builder()
                    .firstName(update.getMessage().getFrom().getFirstName())
                    .lastName(update.getMessage().getFrom().getLastName())
                    .nickname(update.getMessage().getFrom().getUserName())
                    .date(date)
                    .text(update.getMessage().getText())
                    .build();
        }
        UploadInfoIntoSpreadSheetServiceImpl uploadInfoIntoSpreadSheetService = new UploadInfoIntoSpreadSheetServiceImpl();
        uploadInfoIntoSpreadSheetService.sendDataToSpreadsheet(messageDto);
        System.out.println("uploaded update id: " + update.getUpdateId());
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
