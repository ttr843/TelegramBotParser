package ru.ttr843.telegrambotparser.util;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import lombok.SneakyThrows;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

/**
 * 23.07.2020
 * GoogleAuthorizeForSheetsUtil
 *
 * @author Ruslan Pashin
 * High school ITIS
 * @version v1.0
 */
public class GoogleAuthorizeForSheetsUtil {

    /**
     * Global instance of the application name.
     */
    private static final String APPLICATION_NAME = "ParserService";

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    @SneakyThrows
    public static Sheets getSheetsService() {
        try {
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            List<String> scopes = Collections.singletonList(SheetsScopes.SPREADSHEETS);
            GoogleCredential googleCredential = GoogleCredential
                    .fromStream(GoogleAuthorizeForSheetsUtil.class.getResourceAsStream("/credentials.json"))
                    .createScoped(scopes);
           return new Sheets.Builder(httpTransport, JSON_FACTORY, googleCredential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

