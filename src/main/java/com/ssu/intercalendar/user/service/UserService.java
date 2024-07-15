package com.ssu.intercalendar.user.service;

import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.dto.LoginRequest;
import com.ssu.intercalendar.user.dto.RegisterRequest;
import com.ssu.intercalendar.user.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Transactional
    public boolean register(RegisterRequest registerRequest) {

        User user = User.builder()
                .username(registerRequest.username)
                .email(registerRequest.email)
                .password(encoder.encode(registerRequest.password))
                .build();

        userRepository.save(user);
        return true;
    }

    public Authentication login(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            log.info("Authenticated: " + auth.getName());
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } else {
            log.info("Authentication Failed");
        }
        return auth;
    }
}
