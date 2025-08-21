package com.exercise.knowacki.SpokenTimeApp.service;

import org.springframework.stereotype.Component;

import static com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils.*;
@Component
public class PastConverter implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {

        return String.format("%s past %s", getWordForMinute(minute), getWordForHour(hour));
    }
}
