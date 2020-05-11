package com.akoca.mvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ExecutionTimerInterceptor implements HandlerInterceptor {

    private static Logger LOGGER = LoggerFactory.getLogger(ExecutionTimerInterceptor.class);
    private long PREHANDLE_TIME = 0;
    private long POSTHANDLE_TIME = 0;
    private long AFTER_COMPLETION_TIME = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        PREHANDLE_TIME = System.currentTimeMillis();
        LOGGER.info("Prehandle time: " + PREHANDLE_TIME);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        POSTHANDLE_TIME = System.currentTimeMillis();
        LOGGER.info("Posthandle time : " + POSTHANDLE_TIME);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AFTER_COMPLETION_TIME = System.currentTimeMillis();
        LOGGER.info("After comp time: " + AFTER_COMPLETION_TIME);
        long handleExecTime = POSTHANDLE_TIME - PREHANDLE_TIME;
        long totalEXecTime = AFTER_COMPLETION_TIME - PREHANDLE_TIME;
        LOGGER.info("Handler time: " + handleExecTime);
        LOGGER.info("Total exec time: " + totalEXecTime);
    }
}