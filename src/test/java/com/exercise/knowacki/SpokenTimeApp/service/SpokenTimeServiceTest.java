package com.exercise.knowacki.SpokenTimeApp.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class SpokenTimeServiceTest implements WithAssertions {

    @Autowired
    private SpokenTimeService service;

    @Test
    void shouldReturnMidnightFor00_00() {
        String result = service.convertToSpokenForm("00:00");
        assertThat(result).isEqualTo("midnight");
    }

    @Test
    void shouldReturnNoonFor12_00() {
        String result = service.convertToSpokenForm("12:00");
        assertThat(result).isEqualTo("noon");
    }

    @Test
    void shouldReturnHalfPasWhenMinutesEquals30() {
        String result = service.convertToSpokenForm("12:30");
        assertThat(result).isEqualTo("half past twelve");
    }

    @Test
    void shouldReturnHourWithOClockForValidHourWithoutMinutes() {
        String result = service.convertToSpokenForm("14:00");
        assertThat(result).isEqualTo("two o'clock");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForInvalidTimeFormat() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.convertToSpokenForm("25:00")
        );
        assertThat(exception.getMessage()).isEqualTo("Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonNumericInput() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.convertToSpokenForm("invalid")
        );
        assertThat(exception.getMessage()).isEqualTo("Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)");
    }

    @Test
    void shouldUsePastConverterForMinutesUpTo34() {

        assertThat(service.convertToSpokenForm("02:05")).isEqualTo("five past two");
        assertThat(service.convertToSpokenForm("04:15")).isEqualTo("quarter past four");
    }

    @Test
    void shouldUseToConverterForMinutesGreaterThan34() {

        assertThat(service.convertToSpokenForm("07:35")).isEqualTo("twenty five to eight");
        assertThat(service.convertToSpokenForm("11:55")).isEqualTo("five to twelve");
    }

}