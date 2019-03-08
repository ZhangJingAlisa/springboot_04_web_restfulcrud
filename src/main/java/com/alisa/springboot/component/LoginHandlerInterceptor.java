package com.alisa.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @titile: LoginHandlerInterceptor
 * @description: 登陆拦截检查
 * @author: Alisa
 * @create: 2019-03-07 14:41
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser"); //获取session中的用户
        if(user == null){
            //未登录，返回登陆页面
            request.setAttribute("message","没有权限，请先登陆"); //放上错误消息
            //获取getRequestDispatcher转发器到登陆页面
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            //已登录，请求放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}