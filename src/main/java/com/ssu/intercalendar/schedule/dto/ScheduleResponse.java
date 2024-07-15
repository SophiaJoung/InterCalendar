package com.ssu.intercalendar.schedule.dto;

import com.ssu.intercalendar.schedule.domain.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleResponse {

    @Getter
    @NoArgsConstructor
    public static class CreateScheduleResponse {
        private String username;
        private LocalDate date;
        private String description;
        private LocalTime startTime;
        private LocalTime endTime;

        @Builder
        public CreateScheduleResponse(Schedule schedule) {
            this.username = schedule.getUser().getUsername();
            this.date = schedule.getDate();
            this.description = schedule.getDescription();
            this.startTime = schedule.getStartTime();
            this.endTime = schedule.getEndTime();
        }
    }
}
