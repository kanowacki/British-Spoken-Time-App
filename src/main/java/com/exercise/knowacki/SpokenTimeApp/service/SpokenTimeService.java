package com.exercise.knowacki.SpokenTimeApp.service;

import com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class SpokenTimeService {

    private final PastConverter pastConverter;
    private final ToConverter toConverter;

    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public String convertToSpokenForm(String timeInput) {
        try {
            LocalTime time = LocalTime.parse(timeInput, INPUT_FORMATTER);
            return convertTimeToWords(time);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:mm (e.g., 14:30)");
        }
    }

    private String convertTimeToWords(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        if (minute == 0) {
            if (hour == 0) {
                return "midnight";
            } else if (hour == 12) {
                return "noon";
            } else {
                return TimeWordUtils.getWordForHour(hour) + " o'clock";
            }
        } else if (minute == 30) {
            return "half past " + TimeWordUtils.getWordForHour(hour);
        } else if (minute <= 34) {
            return pastConverter.convert(hour, minute);
        } else {
            return toConverter.convert(hour, minute);
        }
    }


}
