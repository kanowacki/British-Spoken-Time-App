package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class ToConverterTest implements WithAssertions {

    private final TimeConverter toConverter = new ToConverter();

    @Test
    void canHandleReturnsTrueWhenMinutesBetween35And59() {
        assertThat(toConverter.canHandle(0, 35)).isTrue();
        assertThat(toConverter.canHandle(10, 46)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForDifferentMinutesEarlierThan35() {
        assertThat(toConverter.canHandle(1, 10)).isFalse();
        assertThat(toConverter.canHandle(13, 26)).isFalse();
        assertThat(toConverter.canHandle(13, 33)).isFalse();
    }

    @Test
    void shouldReturnMinutePastHourFormatCorrectlyWhenMinutesBetween1And29() {
        assertThat(toConverter.convert(5, 35)).isEqualTo("twenty five to six");
        assertThat(toConverter.convert(12, 45)).isEqualTo("quarter to one");
        assertThat(toConverter.convert(23, 47)).isEqualTo("thirteen to midnight");
    }

}