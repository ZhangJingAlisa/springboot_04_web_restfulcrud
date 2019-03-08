package com.alisa.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在访问链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();  //如果不携带区域信息，则设置为默认方式，此时浏览器的设置功能切换无效
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");  //以_分割区域信息
            locale = new Locale(split[0],split[1]);  //将区域信息的信息头和国际代码取出返回
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

