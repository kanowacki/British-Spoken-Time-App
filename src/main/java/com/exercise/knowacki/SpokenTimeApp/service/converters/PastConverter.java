package com.exercise.knowacki.SpokenTimeApp.service.converters;

import com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils;
import org.springframework.stereotype.Component;

@Component
public class PastConverter implements TimeConverter {

    @Override
    public boolean canHandle(int hour, int minute) {
        return minute > 0 && minute < 30;
    }

    @Override
    public String convert(int hour, int minute) {

        return TimeWordUtils.getWordForMinute(minute) + TimeWordUtils.PAST + TimeWordUtils.getWordForHour(hour);
    }
}
