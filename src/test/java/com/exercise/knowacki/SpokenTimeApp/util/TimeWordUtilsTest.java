package com.exercise.knowacki.SpokenTimeApp.util;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class TimeWordUtilsTest implements WithAssertions {

    @Test
    void shouldReturnCorrectWordForHourWithinRange1To11() {
        assertThat(TimeWordUtils.getWordForHour(1)).isEqualTo("one");
        assertThat(TimeWordUtils.getWordForHour(3)).isEqualTo("three");
        assertThat(TimeWordUtils.getWordForHour(11)).isEqualTo("eleven");
    }

    @Test
    void shouldWrapHourAbove12() {
        assertThat(TimeWordUtils.getWordForHour(13)).isEqualTo("one");
        assertThat(TimeWordUtils.getWordForHour(17)).isEqualTo("five");
    }

    @Test
    void shouldReturnBlankStringForHour12AndItsMultiples() {
        assertThat(TimeWordUtils.getWordForHour(12)).isBlank();
        assertThat(TimeWordUtils.getWordForHour(24)).isBlank();
    }

    @Test
    void shouldReturnExactWordForMinutesUpTo20() {
        assertThat(TimeWordUtils.getWordForMinute(1)).isEqualTo("one");
        assertThat(TimeWordUtils.getWordForMinute(10)).isEqualTo("ten");
        assertThat(TimeWordUtils.getWordForMinute(15)).isEqualTo("quarter");
        assertThat(TimeWordUtils.getWordForMinute(20)).isEqualTo("twenty");
    }

    @Test
    void shouldReturnWordForTensAndOnesBetween21And39() {
        assertThat(TimeWordUtils.getWordForMinute(21)).isEqualTo("twenty one");
        assertThat(TimeWordUtils.getWordForMinute(29)).isEqualTo("twenty nine");
        assertThat(TimeWordUtils.getWordForMinute(30)).isEqualTo("thirty");
        assertThat(TimeWordUtils.getWordForMinute(37)).isEqualTo("thirty seven");
    }


    @Test
    void shouldReturnBlankStringForUnsupportedMinutesNumbers() {
        assertThat(TimeWordUtils.getWordForMinute(0)).isBlank();
        assertThat(TimeWordUtils.getWordForMinute(40)).isBlank();
        assertThat(TimeWordUtils.getWordForMinute(55)).isBlank();
    }
}