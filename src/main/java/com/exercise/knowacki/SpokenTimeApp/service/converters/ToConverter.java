package com.exercise.knowacki.SpokenTimeApp.service.converters;

import com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils;
import org.springframework.stereotype.Component;

@Component
public class ToConverter implements TimeConverter {

    @Override
    public boolean canHandle(int hour, int minute) {
        return minute > 30;
    }

    @Override
    public String convert(int hour, int minute) {
        int minutesToNextHour = 60 - minute;
        int nextHour = (hour + 1) % 24;

        return TimeWordUtils.getWordForMinute(minutesToNextHour) + TimeWordUtils.TO + TimeWordUtils.getWordForHour(nextHour);
    }
}
