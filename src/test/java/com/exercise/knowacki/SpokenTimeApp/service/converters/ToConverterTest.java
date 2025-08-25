package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class ToConverterTest implements WithAssertions {

    private final TimeConverter toConverter = new ToConverter();

    @Test
    void canHandleReturnsTrueWhenMinutesBetween31And59() {
        assertThat(toConverter.canHandle(0, 34)).isTrue();
        assertThat(toConverter.canHandle(10, 46)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForDifferentMinutesEarlierThan30() {
        assertThat(toConverter.canHandle(1, 10)).isFalse();
        assertThat(toConverter.canHandle(13, 26)).isFalse();
    }

    @Test
    void shouldReturnMinutePastHourFormatCorrectlyWhenMinutesBetween1And29() {
        assertThat(toConverter.convert(5, 31)).isEqualTo("twenty nine to six");
        assertThat(toConverter.convert(12, 45)).isEqualTo("quarter to one");
        assertThat(toConverter.convert(23, 47)).isEqualTo("thirteen to midnight");
    }

}