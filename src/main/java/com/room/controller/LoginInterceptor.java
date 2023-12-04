package com.room.controller;

import com.room.util.CommonVal;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
        过滤器,校验所有需要验证的请求,判断是否有登录,如果未登录,则强制跳转到登录页面,如果已登录,则判断是否正在进行非法请求
*/
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String contextPath2 = requestUri.trim().replaceAll("/", "");

        if (contextPath2.equals("study_room_sys") ||
                ((contextPath2.contains("admin") == false) &&
                (contextPath2.contains("user") == false))) {
            return true;
        }

        if (login == null) {
            System.out.println(
                "尚未登录,调到登录页面");

            if (requestUri.contains("/admin/")) {
                response.sendRedirect(contextPath + "/commonapi/sys_login"); //强制跳转到登录页面

                return false;
            }

            if (requestUri.contains("/user/")) {
                response.sendRedirect(contextPath + "/commonapi/sys_login"); //强制跳转到登录页面

                return false;
            }

            response.sendRedirect(contextPath + "/");

            return false;
        } else {
            if (login.getLoginType() == 1) {
                if ((requestUri.contains("admin") == false) &&
                        (requestUri.contains("commonapi") == false)) { //当前登录角色为管理员,但请求其他角色使用的接口,即盗链,这种需要拦截并提示错误
                    response.sendRedirect(contextPath +
                        "/commonapi/error?msg=-2");

                    return true;
                }
            }

            if (login.getLoginType() == 2) {
                if ((requestUri.contains("user") == false) &&
                        (requestUri.contains("commonapi") == false)) { //当前登录角色为用户,但请求其他角色使用的接口,即盗链,这种需要拦截并提示错误
                    response.sendRedirect(contextPath +
                        "/commonapi/error?msg=-2");

                    return true;
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
    }
}

