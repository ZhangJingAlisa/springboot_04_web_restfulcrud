package com.alisa.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
import java.util.Map;

/**
 * @titile: HelloController
 * @description: HelloWorld控制层
 * @author: Alisa
 * @create: 2019-03-02 16:51
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

    /**
     * 访问静态资源在templates中查找index.html
     * @return
     */
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
}