package com.exercise.knowacki.SpokenTimeApp.service;

import com.exercise.knowacki.SpokenTimeApp.service.converters.TimeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpokenTimeService {

    private final List<TimeConverter> converters;

    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public String convertToSpokenForm(String timeInput) {
        try {
            LocalTime time = LocalTime.parse(timeInput, INPUT_FORMATTER);
            return convertTimeToWords(time);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)");
        }
    }

    private String convertTimeToWords(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        return converters.stream()
                .filter(converter -> converter.canHandle(hour, minute))
                .findFirst()
                .map(converter -> converter.convert(hour, minute))
                .orElseThrow(() -> new IllegalStateException("No converter found for requested time."));
    }


}
