package com.ssu.intercalendar.group.dto;

import com.ssu.intercalendar.group.domain.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupDto {

    private String groupName;

    @Builder
    public GroupDto(Group group) {
        this.groupName = group.getGroupName();
    }

}
