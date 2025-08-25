package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class NoonConverterTest implements WithAssertions {

    private final TimeConverter noonConverter = new NoonConverter();

    @Test
    void canHandleReturnsTrueForNoon() {
        assertThat(noonConverter.canHandle(12, 0)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForDifferentHourAndMinutesThanNoon() {
        assertThat(noonConverter.canHandle(11, 0)).isFalse();
        assertThat(noonConverter.canHandle(13, 0)).isFalse();

        assertThat(noonConverter.canHandle(12, 1)).isFalse();
        assertThat(noonConverter.canHandle(12, 30)).isFalse();
    }

    @Test
    void convertReturnsNoonForValidInput() {
        assertThat(noonConverter.convert(12, 0)).isEqualTo("noon");
    }
}