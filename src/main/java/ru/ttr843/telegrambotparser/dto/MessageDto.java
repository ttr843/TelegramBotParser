package ru.ttr843.telegrambotparser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 22.07.2020
 * MessageDto
 *
 * @author Ruslan Pashin
 * High school ITIS
 * @version v1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MessageDto {
    private String firstName;

    private String lastName;

    private String nickname;

    private Date date;

    private String text;
}
