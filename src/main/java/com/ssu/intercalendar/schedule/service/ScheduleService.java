package com.ssu.intercalendar.schedule.service;

import com.ssu.intercalendar.exception.NotFoundScheduleException;
import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.schedule.dto.GetScheduleByMonthRequest;
import com.ssu.intercalendar.schedule.dto.ScheduleRequest.CreateScheduleRequest;
import com.ssu.intercalendar.schedule.dto.ScheduleResponse.CreateScheduleResponse;
import com.ssu.intercalendar.schedule.dto.UpdateScheduleRequest;
import com.ssu.intercalendar.schedule.repository.ScheduleRepository;
import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public CreateScheduleResponse createSchedule(Long id, CreateScheduleRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow();

        Schedule schedule = Schedule.builder()
                .user(user)
                .date(request.getDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .description(request.getDescription())
                .build();

        Schedule save = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(save);
    }

    @Transactional
    public void updateSchedule(UpdateScheduleRequest request) {

        Schedule schedule = scheduleRepository.findById(request.id)
                .orElseThrow(() -> new NotFoundScheduleException("그런 일정 없어요."));

        schedule.updateSchedule(request.date, request.description, request.startTime, request.endTime);
    }

    public Schedule getSchedule (Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundScheduleException("그런 일정 없어요."));
    }

    public List<Schedule> getScheduleByMonth(GetScheduleByMonthRequest request) {
        return scheduleRepository.findScheduleByDateRange(request.getId(), request.getStartDate(), request.getEndDate());
    }

    @Transactional
    public void deleteSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundScheduleException("그런 일정 없어요."));

        scheduleRepository.delete(schedule);
    }
}
