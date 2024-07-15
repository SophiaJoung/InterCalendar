package com.ssu.intercalendar.user.dto;

import lombok.Getter;

@Getter
public class RegisterRequest {
    public String username;
    public String email;
    public String password;
}
