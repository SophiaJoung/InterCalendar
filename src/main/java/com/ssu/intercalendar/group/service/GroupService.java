package com.ssu.intercalendar.group.service;

import com.ssu.intercalendar.exception.NotFoundGroupException;
import com.ssu.intercalendar.exception.NotFoundUserException;
import com.ssu.intercalendar.group.domain.Group;
import com.ssu.intercalendar.group.domain.UserGroup;
import com.ssu.intercalendar.group.dto.GroupDto;
import com.ssu.intercalendar.group.dto.GroupInUserDto;
import com.ssu.intercalendar.group.repository.GroupRepository;
import com.ssu.intercalendar.group.repository.UserGroupRepository;
import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.schedule.repository.ScheduleRepository;
import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupService {

    private final GroupRepository groupRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    public GroupDto createGroup(GroupDto groupDto) {

        Group group = Group.builder()
                .groupName(groupDto.getGroupName())
                .build();

        Group save = groupRepository.save(group);
        return new GroupDto(save);
    }

    public void joinGroup(Long id, GroupDto groupDto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundUserException("해당 유저를 찾을 수 없습니다."));

        Group group = groupRepository.findByGroupName(groupDto.getGroupName())
                .orElseThrow(() -> new NotFoundGroupException("해당 그룹을 찾을 수 없습니다."));

        UserGroup userGroup = UserGroup.builder()
                .user(user)
                .group(group)
                .build();

        group.addUserGroup(userGroup);
        user.getUserGroups().add(userGroup);

        userGroupRepository.save(userGroup);
    }

    public List<GroupInUserDto> list() {
        return groupRepository.findAll().stream().map(GroupInUserDto::new).collect(Collectors.toList());
    }

    public LocalTime findBestMeetingTime(Long groupId) {

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NotFoundGroupException("해당 그룹을 찾을 수 없습니다."));

        List<UserGroup> userGroups = group.getUserGroups();
        Map<LocalTime, Integer> timeCounts = new TreeMap<>();

        for (UserGroup userGroup : userGroups) {
            User user = userGroup.getUser();
            List<Schedule> schedules = scheduleRepository.findByUser(user);
            for (Schedule schedule : schedules) {
                LocalTime startTime = schedule.getStartTime();
                LocalTime endTime = schedule.getEndTime();
                while (startTime.isBefore(endTime)) {
                    timeCounts.put(startTime, timeCounts.getOrDefault(startTime, 0) + 1);
                    startTime = startTime.plusMinutes(30);
                }
            }
        }

        return timeCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("겹치는 시간이 없습니다."))
                .getKey();
    }
}
