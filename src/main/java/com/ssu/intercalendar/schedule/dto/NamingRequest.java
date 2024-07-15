package com.ssu.intercalendar.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NamingRequest {

    private LocalDate startDate;
    private LocalDate endDate;
}
