package com.exercise.knowacki.SpokenTimeApp.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class PastConverterTest implements WithAssertions {

    @Test
    void shouldReturnMinutePastHourFormatCorrectlyWhenMinutesBetween1And35(){
        PastConverter pastConverter = new PastConverter();

        String result = pastConverter.convert(5,11);

        assertThat(result).isEqualTo("eleven past five");
    }

}