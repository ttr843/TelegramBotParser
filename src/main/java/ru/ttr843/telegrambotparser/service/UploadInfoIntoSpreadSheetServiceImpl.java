package ru.ttr843.telegrambotparser.service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import ru.ttr843.telegrambotparser.dto.MessageDto;
import ru.ttr843.telegrambotparser.util.GoogleAuthorizeForSheetsUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * 22.07.2020
 * UploadInfoIntoSpreadSheetServiceImpl
 *
 * @author Ruslan Pashin
 * High school ITIS
 * @version v1.0
 */
public class UploadInfoIntoSpreadSheetServiceImpl implements UploadInfoIntoSpreadSheetService {

    /**
     * Global instance of the SpreadSheet_Id
     */
    private static final String SPREADSHEET_ID =
            "write your spreadsheet_id here";


    @Override
    public void sendDataToSpreadsheet(MessageDto messageDto) {
        try {
            Sheets sheetsService = GoogleAuthorizeForSheetsUtil.getSheetsService();
            ValueRange body = new ValueRange()
                    .setMajorDimension("COLUMNS")
                    .setValues(Arrays.asList(
                            Collections.singletonList(messageDto.getFirstName() + " " + messageDto.getLastName()),
                            Collections.singletonList(messageDto.getNickname()),
                            Collections.singletonList(messageDto.getDate().toString()),
                            Collections.singletonList(messageDto.getText())));
            Objects.requireNonNull(sheetsService).spreadsheets().values()
                    .append(SPREADSHEET_ID, "A1", body)
                    .setValueInputOption("RAW")
                    .setInsertDataOption("INSERT_ROWS")
                    .execute();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
