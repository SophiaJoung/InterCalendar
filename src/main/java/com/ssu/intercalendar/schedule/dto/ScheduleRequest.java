package com.ssu.intercalendar.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleRequest {

    @Getter
    public static class CreateScheduleRequest {
        private LocalDate date;
        private String description;
        private LocalTime startTime;
        private LocalTime endTime;
    }

    @Getter
    public static class GetScheduleByMonthRequest {
        public LocalDate startDate;
        public LocalDate endDate;
    }

}
