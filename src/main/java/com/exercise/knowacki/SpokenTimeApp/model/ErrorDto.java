package com.exercise.knowacki.SpokenTimeApp.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorDto {
    Integer statusCode;
    String requestedHour;
    String error;
    String errorMessage;
}
