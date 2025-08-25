package com.exercise.knowacki.SpokenTimeApp.service.converters;

import com.exercise.knowacki.SpokenTimeApp.util.TimeWordUtils;
import org.springframework.stereotype.Component;

@Component
public class HalfConverter implements TimeConverter {

    @Override
    public boolean canHandle(int hour, int minute) {
        return minute == 30;
    }

    @Override
    public String convert(int hour, int minute) {
        return TimeWordUtils.HALF + TimeWordUtils.getWordForHour(hour);
    }
}
