package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class HalfConverterTest implements WithAssertions {
    private final TimeConverter halfConverter = new HalfConverter();

    @Test
    void canHandleReturnsTrueFor30Minutes() {
        assertThat(halfConverter.canHandle(0, 30)).isTrue();
        assertThat(halfConverter.canHandle(12, 30)).isTrue();
        assertThat(halfConverter.canHandle(16, 30)).isTrue();
    }

    @Test
    void canHandleReturnsFalseForDifferentMinutes() {
        assertThat(halfConverter.canHandle(1, 15)).isFalse();
        assertThat(halfConverter.canHandle(13, 0)).isFalse();
        assertThat(halfConverter.canHandle(0, 1)).isFalse();
    }

    @Test
    void convertReturnsNoonForValidInput() {
        assertThat(halfConverter.convert(9, 30)).isEqualTo("half past nine");
    }
}