package com.ssu.intercalendar.group.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<UserGroup> userGroups = new ArrayList<>();

    @Builder
    public Group(String groupName, List<UserGroup> userGroups) {
        this.groupName = groupName;
        this.userGroups = userGroups;
    }

    public void updateGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addUserGroup(UserGroup userGroup) {
        this.userGroups.add(userGroup);
        userGroup.addGroup(this);
    }

    public static Group createGroup(UserGroup... userGroups) {
        Group group = new Group();
        for (UserGroup userGroup : userGroups) {
            group.addUserGroup(userGroup);
        }
        return group;
    }
}