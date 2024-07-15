package com.ssu.intercalendar.schedule.controller;

import com.ssu.intercalendar.common.BaseResponse;
import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.schedule.dto.GetScheduleByMonthRequest;
import com.ssu.intercalendar.schedule.dto.GetScheduleByMonthResponse;
import com.ssu.intercalendar.schedule.dto.GetScheduleResponse;
import com.ssu.intercalendar.schedule.dto.ScheduleRequest.CreateScheduleRequest;
import com.ssu.intercalendar.schedule.dto.ScheduleResponse.CreateScheduleResponse;
import com.ssu.intercalendar.schedule.dto.UpdateScheduleRequest;
import com.ssu.intercalendar.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/{id}")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@PathVariable Long id, @RequestBody CreateScheduleRequest request) {
        return ResponseEntity.ok(scheduleService.createSchedule(id, request));
    }

    @PutMapping("/{id}")
    public BaseResponse updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequest request) {
        scheduleService.updateSchedule(request);
        return new BaseResponse(true);
    }

    @GetMapping("/{id}")
    public GetScheduleResponse getSchedule(@PathVariable Long id) {
        Schedule schedule = scheduleService.getSchedule(id);
        return new GetScheduleResponse(true, schedule);
    }

    //월 별 조회
    @GetMapping
    public GetScheduleByMonthResponse getScheduleByMonth(@RequestBody GetScheduleByMonthRequest request) {
        List<Schedule> schedules = scheduleService.getScheduleByMonth(request);
        return new GetScheduleByMonthResponse(true, schedules);
    }

    //일정 삭제 (캘린더)
    @DeleteMapping("/{id}")
    public BaseResponse deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return new BaseResponse(true);
    }
}
