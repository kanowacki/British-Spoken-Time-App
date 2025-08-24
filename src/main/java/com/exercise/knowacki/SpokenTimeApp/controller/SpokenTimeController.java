package com.exercise.knowacki.SpokenTimeApp.controller;

import com.exercise.knowacki.SpokenTimeApp.service.SpokenTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/spoken-time")
@RequiredArgsConstructor
public class SpokenTimeController {

    private final SpokenTimeService service;

    @GetMapping("/{time}")
    public String getSpokenTime(@PathVariable String time) {
        return service.convertToSpokenForm(time);
    }
}
