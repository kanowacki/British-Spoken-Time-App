package com.exercise.knowacki.SpokenTimeApp.service.converters;

import com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils;
import org.springframework.stereotype.Component;

@Component
public class OClockConverter implements TimeConverter {

    @Override
    public boolean canHandle(int hour, int minute) {
        return hour != 0 && hour != 12 && minute == 0;
    }

    @Override
    public String convert(int hour, int minute) {
        return TimeWordUtils.getWordForHour(hour) + TimeWordUtils.O_CLOCK;
    }
}
