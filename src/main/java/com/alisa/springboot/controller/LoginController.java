package com.alisa.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @titile: LoginController
 * @description: 登陆页面跳转到主页
 * @author: Alisa
 * @create: 2019-03-07 11:42
 */
@Controller
public class LoginController {

//    @GetMapping
//    @PutMapping
//    @DeleteMapping
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST) 被@PostMapping给替代了
    @PostMapping(value = "user/login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功，跳转到主页；防止表单重复提交，可以重定向到主页【把dashboard改为】：(redirect:/main.html)
            session.setAttribute("loginUser",username);//登陆过的用户会保存在session中
            return "redirect:/main.html";
        }else {
            //登陆失败
            map.put("message","用户名密码错误");  //创建一个Map来封装错误消息
            return "login";
        }

    }
}