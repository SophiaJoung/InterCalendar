package com.ssu.intercalendar.schedule.dto;

import com.ssu.intercalendar.common.BaseResponse;
import com.ssu.intercalendar.schedule.domain.Schedule;

import java.util.ArrayList;
import java.util.List;

public class GetScheduleByMonthResponse extends BaseResponse {
    public List<ScheduleDTO> schedules = new ArrayList<>();

    public GetScheduleByMonthResponse (Boolean status, List<Schedule> schedules) {
        super(status);
        for(Schedule schedule : schedules) {
            ScheduleDTO dto = ScheduleDTO.toDTO(schedule);
            this.schedules.add(dto);
        }
    }
}
