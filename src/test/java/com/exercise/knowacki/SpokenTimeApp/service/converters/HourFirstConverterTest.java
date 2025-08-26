package com.exercise.knowacki.SpokenTimeApp.service.converters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class HourFirstConverterTest implements WithAssertions {

    private final TimeConverter hourFirstConverter = new HourFirstConverter();

    @Test
    void canHandleReturnsTrueWhenMinutesBetween31And34() {
        assertThat(hourFirstConverter.canHandle(0, 31)).isTrue();
        assertThat(hourFirstConverter.canHandle(10, 32)).isTrue();
    }

    @Test
    void canHandleReturnsFalseWhenMinutesNotBetween31And34() {
        assertThat(hourFirstConverter.canHandle(10, 17)).isFalse();
        assertThat(hourFirstConverter.canHandle(1, 30)).isFalse();
        assertThat(hourFirstConverter.canHandle(13, 35)).isFalse();
        assertThat(hourFirstConverter.canHandle(7, 40)).isFalse();
    }

    @Test
    void shouldReturnMinutePastHourFormatCorrectlyWhenMinutesBetween1And29() {
        assertThat(hourFirstConverter.convert(5, 32)).isEqualTo("five thirty two");
        assertThat(hourFirstConverter.convert(12, 33)).isEqualTo("twelve thirty three");
        assertThat(hourFirstConverter.convert(0, 34)).isEqualTo("midnight thirty four");
    }

}