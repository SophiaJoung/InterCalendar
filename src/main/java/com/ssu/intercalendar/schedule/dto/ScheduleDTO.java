package com.ssu.intercalendar.schedule.dto;

import com.ssu.intercalendar.schedule.domain.Schedule;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
public class ScheduleDTO {
    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;
    public String description;

    public static ScheduleDTO toDTO(Schedule schedule) {
        return new ScheduleDTO(schedule.getDate(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDescription());
    }
}
