package com.alisa.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @titile: MyMvcConfig
 * @description: mvc配置类
 * @author: Alisa
 * @create: 2019-03-05 17:37
 */
//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // super.addViewControllers(registry);
//        //浏览器发送 /atguigu 请求来到 success页面
//        registry.addViewController("/atguigu").setViewName("success");
//    }

    /**
     * 视图映射
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/alisa 请求会来到success页面
        registry.addViewController("/alisa").setViewName("success");
    }

    /**
     *
     * @return
     */
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
//    @Bean //将组件注册在容器
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                //添加视图映射
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index.html").setViewName("index");
//            }
//        };
//        return adapter;
//    }
}