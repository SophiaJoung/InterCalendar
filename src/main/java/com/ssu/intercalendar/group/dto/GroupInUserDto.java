package com.ssu.intercalendar.group.dto;

import com.ssu.intercalendar.group.domain.Group;
import com.ssu.intercalendar.user.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class GroupInUserDto {

    private Long id;
    private String groupName;
    private List<UserDto> users;

    public GroupInUserDto(Group group) {
        this.id = group.getId();
        this.groupName = group.getGroupName();
        this.users = group.getUserGroups().stream()
                .map(userGroup -> new UserDto(userGroup.getUser()))
                .collect(Collectors.toList());
    }
}
