package com.exercise.knowacki.SpokenTimeApp.service;

import org.springframework.stereotype.Component;

import static com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils.getWordForHour;
import static com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils.getWordForMinute;

@Component
public class ToConverter implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        int minutesToNextHour = 60 - minute;
        int nextHour = (hour + 1) % 24;

        return String.format("%s to %s", getWordForMinute(minutesToNextHour), getWordForHour(nextHour));
    }
}
