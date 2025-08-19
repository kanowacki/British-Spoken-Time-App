package com.exercise.knowacki.SpokenTimeApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class SpokenTimeServiceTest {

    private SpokenTimeService service;

    @BeforeEach
    void setUp() {
        service = new SpokenTimeService();
    }

    @Test
    void shouldReturnMidnightFor00_00() {
        String result = service.convertToSpokenForm("00:00");
        assertEquals("midnight", result);
    }

    @Test
    void shouldReturnNoonFor12_00() {
        String result = service.convertToSpokenForm("12:00");
        assertEquals("noon", result);
    }

    @Test
    void shouldReturnHourWithOClockForValidHourWithoutMinutes() {
        String result = service.convertToSpokenForm("14:00");
        assertEquals("two o'clock", result);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForInvalidTimeFormat() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.convertToSpokenForm("25:00")
        );
        assertEquals("Invalid time format. Please use HH:mm (e.g., 14:30)", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonNumericInput() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.convertToSpokenForm("invalid")
        );
        assertEquals("Invalid time format. Please use HH:mm (e.g., 14:30)", exception.getMessage());
    }
}