package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class MidnightConverterTest implements WithAssertions {
    private final TimeConverter midnightConverter = new MidnightConverter();

    @Test
    void canHandleReturnsTrueForMidnight() {
        assertThat(midnightConverter.canHandle(0, 0)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForDifferentHourAndMinutesThanMidnight() {
        assertThat(midnightConverter.canHandle(1, 0)).isFalse();
        assertThat(midnightConverter.canHandle(13, 0)).isFalse();

        assertThat(midnightConverter.canHandle(0, 1)).isFalse();
        assertThat(midnightConverter.canHandle(0, 30)).isFalse();
    }

    @Test
    void convertReturnsMidnightForValidInput() {
        assertThat(midnightConverter.convert(0, 0)).isEqualTo("midnight");
    }
}