package com.exercise.knowacki.SpokenTimeApp.controller;

import com.exercise.knowacki.SpokenTimeApp.service.SpokenTimeService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class SpokenTimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private SpokenTimeService service;

    @ParameterizedTest(name="Time: {0}, Spoken form: {1}")
    @CsvFileSource(resources = "/spokenTimeServiceTestData.csv", numLinesToSkip = 1)
    @SneakyThrows
    void shouldReturnSpokenTimeForValidInput(String testInput, String expectedOutput) {

        mockMvc.perform(get("/spoken-time/{time}", testInput))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }

    @SneakyThrows
    @Test
    void shouldReturnBadRequestForInvalidTimeFormat() {
        // Given
        String timeInput = "25:00";

        // When & Then
        mockMvc.perform(get("/spoken-time/{time}", timeInput))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.requestedHour").value("25:00"))
                .andExpect(jsonPath("$.error").value("IllegalArgumentException"))
                .andExpect(jsonPath("$.errorMessage").value("Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)"));
    }

    @SneakyThrows
    @Test
    void shouldReturnBadRequestForNonNumericInput() {
        // Given
        String timeInput = "invalid";

        // When & Then
        mockMvc.perform(get("/spoken-time/{time}", timeInput))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.requestedHour").value("invalid"))
                .andExpect(jsonPath("$.error").value("IllegalArgumentException"))
                .andExpect(jsonPath("$.errorMessage").value("Invalid time format. Please use HH:mm (e.g., 14:30, 06:02)"));
    }
}