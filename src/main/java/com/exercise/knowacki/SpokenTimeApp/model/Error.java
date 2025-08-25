package com.exercise.knowacki.SpokenTimeApp.model;

public record Error(Integer statusCode,
                       String requestedHour,
                       String error,
                       String errorMessage) {

}
