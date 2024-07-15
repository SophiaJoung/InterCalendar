package com.ssu.intercalendar.user.controller;

import com.ssu.intercalendar.user.dto.LoginRequest;
import com.ssu.intercalendar.user.dto.RegisterRequest;
import com.ssu.intercalendar.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public boolean register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    @PostMapping("/login")
    public HttpStatus login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        userService.login(loginRequest, request, response);
        return HttpStatus.OK;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            SecurityContextHolder.clearContext();

            request.getSession().invalidate();

            return "Logout successful";
        } else {
            return "Not authenticated";
        }
    }
}
