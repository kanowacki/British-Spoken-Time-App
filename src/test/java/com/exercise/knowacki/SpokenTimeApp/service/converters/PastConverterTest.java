package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class PastConverterTest implements WithAssertions {

    private final TimeConverter pastConverter = new PastConverter();

    @Test
    void canHandleReturnsTrueWhenMinutesBetween1And29() {
        assertThat(pastConverter.canHandle(0, 4)).isTrue();
        assertThat(pastConverter.canHandle(10, 26)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForMinutesLaterThan30() {
        assertThat(pastConverter.canHandle(1, 40)).isFalse();
        assertThat(pastConverter.canHandle(13, 56)).isFalse();
        assertThat(pastConverter.canHandle(0, 31)).isFalse();
    }

    @Test
    void shouldReturnMinutePastHourFormatCorrectlyWhenMinutesBetween1And29() {
        assertThat(pastConverter.convert(5, 11)).isEqualTo("eleven past five");
        assertThat(pastConverter.convert(12, 6)).isEqualTo("six past twelve");
        assertThat(pastConverter.convert(0, 17)).isEqualTo("seventeen past midnight");
    }

}