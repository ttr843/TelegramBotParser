package ru.ttr843.telegrambotparser.service;

import ru.ttr843.telegrambotparser.dto.MessageDto;

/**
 * 22.07.2020
 * UploadInfoIntoSpreadSheetService
 *
 * @author Ruslan Pashin
 * High school ITIS
 * @version v1.0
 */
public interface UploadInfoIntoSpreadSheetService {
    public void sendDataToSpreadsheet(MessageDto messageDto);
}
