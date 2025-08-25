package com.exercise.knowacki.SpokenTimeApp.service.converters;

public interface TimeConverter {
    boolean canHandle(int hour, int minute);
    String convert(int hour, int minute);
}
