package com.ssu.intercalendar.group.controller;

import com.ssu.intercalendar.group.domain.Group;
import com.ssu.intercalendar.group.dto.GroupDto;
import com.ssu.intercalendar.group.dto.GroupInUserDto;
import com.ssu.intercalendar.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupService.createGroup(groupDto));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> joinGroup(@PathVariable Long id, @RequestBody GroupDto groupDto) {
        groupService.joinGroup(id, groupDto);
        return ResponseEntity.ok("");
    }

    @GetMapping("/best-meeting-time/{groupId}")
    public ResponseEntity<LocalTime> findBestMeetingTime(@PathVariable Long groupId) {
        LocalTime bestMeetingTime = groupService.findBestMeetingTime(groupId);
        return ResponseEntity.ok(bestMeetingTime);
    }

    @GetMapping
    public ResponseEntity<List<GroupInUserDto>> list() {
        return ResponseEntity.ok(groupService.list());
    }
}
