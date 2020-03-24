package com.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2020/3/11.
 */
@Controller
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public String fun1(){
        System.out.println("=====================");
        return "hello------------";
    }

    @RequestMapping("/")
    public String fun2(){
        System.out.println("index===========");
        return "index";
    }
}
