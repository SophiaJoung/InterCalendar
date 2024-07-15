package com.ssu.intercalendar.user.domain;

import com.ssu.intercalendar.group.domain.UserGroup;
import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.user.enumerate.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGroup> userGroups = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = Role.ROLE_USER;
    }
}