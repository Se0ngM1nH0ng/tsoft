package com.tsoft.sched.config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PageInterceptor implements HandlerInterceptor {
    @Value("${container.name}")
    private String containerName;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("request.getRequestURI() : "+ request.getRequestURI());
        if(request.getRequestURI().indexOf("/resources")>-1){
            return true;
        }
        if ("agent".equals(containerName)&& request.getRequestURI().indexOf("/page")>-1) {
            // 특정 조건이 충족되지 않으면 컨트롤러 실행을 막기
            request.getRequestDispatcher("/error").forward(request, response);
            return false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 컨트롤러 실행 후, 뷰 생성 전에 수행할 작업
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 뷰 생성 후에 수행할 작업
    }
}