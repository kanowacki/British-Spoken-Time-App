package com.exercise.knowacki.SpokenTimeApp.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class ToConverterTest implements WithAssertions {

    @Test
    void shouldReturnMinutesToHourFormatWhenMinutesBetween35And59(){
        ToConverter toConverter = new ToConverter();

        String result = toConverter.convert(5,40);

        assertThat(result).isEqualTo("twenty to six");
    }

}