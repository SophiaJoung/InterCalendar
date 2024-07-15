package com.ssu.intercalendar.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class CreateScheduleRequest {

    private LocalDate date;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
}
