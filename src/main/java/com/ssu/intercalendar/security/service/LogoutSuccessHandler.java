package com.ssu.intercalendar.security.service;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 로그아웃 후 추가 처리 (예: 로그아웃 후 사용자에게 메시지 표시)
        response.sendRedirect("/login?logout"); // 로그아웃 후 리다이렉트
    }

}
