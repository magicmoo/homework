package com.homework.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String password = (String)request.getAttribute("password");
//        if(!"yes".equals(password)){
//            request.getRequestDispatcher("/pages/error.html").forward(request,response);
//        }
        return true;
    }
}
