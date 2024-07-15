package com.ssu.intercalendar.schedule.dto;

import com.ssu.intercalendar.common.BaseResponse;
import com.ssu.intercalendar.schedule.domain.Schedule;

public class GetScheduleResponse extends BaseResponse {
    public Schedule schedule;

    public GetScheduleResponse(Boolean status, Schedule schedule) {
        super(status);
        this.schedule = schedule;
    }
}
