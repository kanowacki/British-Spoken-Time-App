package com.exercise.knowacki.SpokenTimeApp.controller;

import com.exercise.knowacki.SpokenTimeApp.service.SpokenTimeService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SpokenTimeController.class)
class SpokenTimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SpokenTimeService service;

    @SneakyThrows
    @Test
    void shouldReturnSpokenTimeForValidInput() {
        // Given
        String timeInput = "14:00";
        when(service.convertToSpokenForm(timeInput)).thenReturn("two o'clock");

        // When & Then
        mockMvc.perform(get("/spoken-time/GB/{time}", timeInput))
                .andExpect(status().isOk())
                .andExpect(content().string("two o'clock"));
    }

    @SneakyThrows
    @Test
    void shouldReturnMidnightFor00_00(){
        // Given
        String timeInput = "00:00";
        when(service.convertToSpokenForm(timeInput)).thenReturn("midnight");

        // When & Then
        mockMvc.perform(get("/spoken-time/GB/{time}", timeInput))
                .andExpect(status().isOk())
                .andExpect(content().string("midnight"));
    }

    @SneakyThrows
    @Test
    void shouldReturnNoonFor12_00() {
        // Given
        String timeInput = "12:00";
        when(service.convertToSpokenForm(timeInput)).thenReturn("noon");

        // When & Then
        mockMvc.perform(get("/spoken-time/GB/{time}", timeInput))
                .andExpect(status().isOk())
                .andExpect(content().string("noon"));
    }

    @SneakyThrows
    @Test
    void shouldReturnBadRequestForInvalidTimeFormat() {
        // Given
        String timeInput = "25:00";
        when(service.convertToSpokenForm(timeInput))
                .thenThrow(new IllegalArgumentException("Invalid time format. Please use HH:mm (e.g., 14:30)"));

        // When & Then
        mockMvc.perform(get("/spoken-time/GB/{time}", timeInput))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.requestedHour").value("25:00"))
                .andExpect(jsonPath("$.error").value("IllegalArgumentException"))
                .andExpect(jsonPath("$.errorMessage").value("Invalid time format. Please use HH:mm (e.g., 14:30)"));
    }

    @SneakyThrows
    @Test
    void shouldReturnBadRequestForNonNumericInput() {
        // Given
        String timeInput = "invalid";
        when(service.convertToSpokenForm(timeInput))
                .thenThrow(new IllegalArgumentException("Invalid time format. Please use HH:mm (e.g., 14:30)"));

        // When & Then
        mockMvc.perform(get("/spoken-time/GB/{time}", timeInput))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.requestedHour").value("invalid"))
                .andExpect(jsonPath("$.error").value("IllegalArgumentException"))
                .andExpect(jsonPath("$.errorMessage").value("Invalid time format. Please use HH:mm (e.g., 14:30)"));
    }
}