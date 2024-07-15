package com.ssu.intercalendar.user.enumerate;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_USER("user");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}
