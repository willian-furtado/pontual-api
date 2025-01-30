package com.api.pontualapi.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConverter {

    public static LocalDate stringToLocalDate(String dateStr) {
        try {
            if(dateStr == null){
                return null;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data no formato inválido: " + dateStr);
        }
    }

    public static String localDateToString(LocalDate date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static String localDateTimeToStringTime(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(formatter);
    }

    public static String localDateToStringTime(LocalDate date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        return date.format(formatter);
    }

    public static LocalDateTime stringToLocalDateTime(String dateStr) {
        try {
            DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateStr, isoFormatter);
            return offsetDateTime.withOffsetSameInstant(ZoneOffset.of("-03:00")).toLocalDateTime();
        } catch (DateTimeParseException e) {
            try {
                DateTimeFormatter brFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                return LocalDateTime.parse(dateStr, brFormatter);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("Data no formato inválido: " + dateStr);
            }
        }
    }

}
