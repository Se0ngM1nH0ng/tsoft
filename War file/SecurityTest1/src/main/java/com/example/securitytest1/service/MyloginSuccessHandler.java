package com.example.securitytest1.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class MyloginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
            HttpSession session = request.getSession();

            session.setAttribute("greeting", authentication.getName() + "님 환영합니다.");
        // "greeting" 이라는 key 값으로 "ㅇㅇ"님 환영합니다.
            response.sendRedirect("/loginSuccess"); // 사용자가 보게될 Page로 redirect
    }
}
