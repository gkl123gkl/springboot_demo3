package com.aistar.controller;

import com.aistar.service.CustomerService;
import com.aistar.service.JobService;
import com.aistar.service.impl.JobServiceImpl;
import com.aistar.util.DateUtil;
import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by admin on 2020/3/12.
 */
@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/job/{id}")
    @ResponseBody
    public ServerResponse getById(@PathVariable("id") Integer jobId){
        System.out.println("job id:"+jobId);
        ServerResponse serverResponse=jobService.getById(jobId);
        return serverResponse;
    }
    @GetMapping("/job/getSomeLatest")
    @ResponseBody
    public ServerResponse getSomeLatest(){
       ServerResponse serverResponse=jobService.getSomeLatest();
       return serverResponse;
    }
    @GetMapping("/job/getAll")
    @ResponseBody
    public ServerResponse getAll(String kw,String city,String publishtime,String minsalary,String maxsalary,String company,String workyear,String degree,Integer page){

        //获得页面每个参数
        String publishtimeStr=publishtime;
        String minsalaryStr=minsalary;
        String maxsalaryStr=maxsalary;

        //关键字
        if(kw==null || kw.trim().equals(""))
            kw = null;
        //城市
        if(city==null || city.trim().equals(""))
            city = null;

        //发布日期
      Date time=null;
        if(publishtimeStr!=null && !publishtimeStr.equals("")){
            time= DateUtil.getBeforeDate(Integer.valueOf(publishtimeStr));
        }

        //最低最高薪资
        Float minSalary=0f;
        Float maxSalary=50000f;
        if(minsalaryStr!=null && !minsalaryStr.equals("")){
            minSalary=Float.valueOf(minsalaryStr);
        }
        if(maxsalaryStr!=null && !maxsalaryStr.equals("")){
            maxSalary=Float.valueOf(maxsalaryStr);
        }

        //学历
        if(degree==null || degree.trim().equals("")){
            degree=null;
        }

        //工作年限
        if(workyear==null || workyear.trim().equals("")){
            workyear=null;
        }
        //页码

        if(page==null){
            page=1;
        }
        System.out.println("kw2:"+kw);
        System.out.println("city2:"+city);
        //servlce层
        ServerResponse serverResponse=jobService.getAll(kw,city,time,minSalary,maxSalary,company,workyear,degree,page);
       return serverResponse;

    }

    @GetMapping("/job/detail/{id}")
    @ResponseBody
    public ModelAndView detail(@PathVariable("id") Integer jobId) {
        ModelAndView modelAndView=new ModelAndView();
        ServerResponse serverResponse=jobService.getById(jobId);
//        request.setAttribute("jobCompany",serverResponse.getData());
        modelAndView.addObject("jobCompany",serverResponse.getData());
        modelAndView.setViewName("job/detail");
        return modelAndView;
    }


}

