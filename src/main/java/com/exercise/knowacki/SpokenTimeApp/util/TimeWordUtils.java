package com.exercise.knowacki.SpokenTimeApp.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class TimeWordUtils {
    private static final Map<Integer, String> NUMBER_TO_WORD = Map.ofEntries(
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
            Map.entry(11, "eleven"),
            Map.entry(12, "twelve"),
            Map.entry(13, "thirteen"),
            Map.entry(14, "fourteen"),
            Map.entry(15, "quarter"),
            Map.entry(16, "sixteen"),
            Map.entry(17, "seventeen"),
            Map.entry(18, "eighteen"),
            Map.entry(19, "nineteen"),
            Map.entry(20, "twenty"),
            Map.entry(30, "thirty")
    );

    public static String getWordForHour(int hour) {
        int adjustedHour = hour % 12;
        if (adjustedHour == 0) {
            adjustedHour = 12;
        }
        return NUMBER_TO_WORD.get(adjustedHour);
    }

    public static String getWordForMinute(int minute) {
        if (minute <= 20) {
            return NUMBER_TO_WORD.get(minute);
        }
        int tens = minute / 10 * 10;
        int ones = minute % 10;
        String tensWord = NUMBER_TO_WORD.get(tens);
        String onesWord = (ones > 0) ? " " + NUMBER_TO_WORD.get(ones) : "";

        return tensWord + onesWord;
    }

}
