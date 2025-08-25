package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class OClockConverterTest implements WithAssertions {
    private final TimeConverter oClockConverter = new OClockConverter();

    @Test
    void canHandleReturnsTrueWhenMinutesEquals0() {
        assertThat(oClockConverter.canHandle(6, 0)).isTrue();
        assertThat(oClockConverter.canHandle(11, 0)).isTrue();
        assertThat(oClockConverter.canHandle(16, 0)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForDifferentMinutes() {
        assertThat(oClockConverter.canHandle(1, 15)).isFalse();
        assertThat(oClockConverter.canHandle(13, 46)).isFalse();
        assertThat(oClockConverter.canHandle(0, 1)).isFalse();
    }

    @Test
    void convertReturnsOClockForValidInput() {
        assertThat(oClockConverter.convert(9, 0)).isEqualTo("nine o'clock");
    }
}