package com.aistar.controller;

import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 2020/3/12.
 */
@Controller
public class CommonController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "customer/login";
    }
    @RequestMapping("/regist")
    public String regist(){
        return "customer/regist";
    }
    @RequestMapping("/joball")
    public ModelAndView allJob(String kw){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject(kw);
        modelAndView.setViewName("job/all");
        return modelAndView;
    }
    @RequestMapping("/resumedetail/{id}")
    public ModelAndView resumedetail(@PathVariable("id") Integer resumeId){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("resumeId",resumeId);
        modelAndView.setViewName("resume/detail");
        return modelAndView;
    }
    @RequestMapping("/resumeadd")
    public String resumeadd(){
        return "resume/add";
    }
    @RequestMapping("/resumedeliveryrecordall")
    public String resumedeliveryrecord(){
        return "resumeDeliveryRecord/all";
    }

}
