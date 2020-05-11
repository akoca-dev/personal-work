package com.akoca.mvc.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Service
public class VisitorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("currentTime" , LocalDateTime.now());

        HttpSession httpSession = request.getSession(true);

        if(null == httpSession.getAttribute("sessionStartTime")) {
            httpSession.setAttribute("sessionStartTime" , LocalDateTime.now());
        }

        return true;
    }
}
