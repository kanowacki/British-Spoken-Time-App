package com.exercise.knowacki.SpokenTimeApp.service.converters;

import com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils;
import org.springframework.stereotype.Component;

@Component
public class NoonConverter implements TimeConverter {

    @Override
    public boolean canHandle(int hour, int minute) {
        return hour == 12 && minute == 0;
    }

    @Override
    public String convert(int hour, int minute) {
        return TimeWordUtils.NOON;
    }
}
