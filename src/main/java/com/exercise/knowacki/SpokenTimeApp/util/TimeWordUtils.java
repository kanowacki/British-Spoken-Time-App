package com.exercise.knowacki.SpokenTimeApp.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class TimeWordUtils {
    private static final Map<Integer, String> SPECIAL_WORDS = Map.ofEntries(
            Map.entry(1, "one"),
            Map.entry(2, "two"),
            Map.entry(3, "three"),
            Map.entry(4, "four"),
            Map.entry(5, "five"),
            Map.entry(6, "six"),
            Map.entry(7, "seven"),
            Map.entry(8, "eight"),
            Map.entry(9, "nine"),
            Map.entry(10, "ten"),
            Map.entry(11, "eleven")
    );

    public static String getHourWord(int hour) {
        int adjustedHour = hour % 12;
        if (adjustedHour == 0) {
            adjustedHour = 12;
        }
        return SPECIAL_WORDS.get(adjustedHour);
    }


}
