package com.aistar.controller;

import com.aistar.pojo.Customer;
import com.aistar.pojo.Resume;
import com.aistar.service.ResumeService;
import com.aistar.service.impl.ResumeServiceImpl;
import com.aistar.util.DateUtil;
import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2020/3/16.
 */
@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @GetMapping("/resume/{id}")
    @ResponseBody
    public ServerResponse getById(@PathVariable("id") Integer resumeId){
        ServerResponse serverResponse=resumeService.getResumeAllVOById(resumeId);
        return serverResponse;

    }

    @GetMapping("/resume")
    public ModelAndView getAllResumeByCustId(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Customer customer = (Customer)  request.getSession().getAttribute("loginCustomer");
        Integer custId = customer.getCustId();
        ServerResponse serverResponse =resumeService.getAllByCustId(custId);
        List<Resume> resumeList =( List<Resume> ) serverResponse.getData();
        modelAndView.addObject("resumeList",resumeList);
        modelAndView.setViewName("/resume/all");
        return modelAndView;
    }
    @GetMapping("/resume/count")
    @ResponseBody
    public ServerResponse getCount(HttpServletRequest request){
        Customer customer = (Customer) request.getSession().getAttribute("loginCustomer");
        Integer custId = customer.getCustId();
        System.out.println("custId:" + custId);
        ServerResponse serverResponse = resumeService.getCountByCustId(custId);
        System.out.println("serverResponse:=====" + serverResponse);
        return serverResponse;
    }
    @PostMapping("/resume/name")
    @ResponseBody
    public ServerResponse add(HttpServletRequest request,String resumeName){
        Customer customer = (Customer) request.getSession().getAttribute("loginCustomer");
        Integer custId = customer.getCustId();
        Resume resume = new Resume();
        resume.setCustId(custId);
        resume.setResumeName(resumeName);
        resume.setResumeCreateTime(new Date());
        resume.setStatus(0);
        ServerResponse serverResponse = resumeService.add(resume);
        if (serverResponse.getStatus() == 1) {
            //获得刚添加的简历对象
            serverResponse = resumeService.getLatestOne(custId);
        }
        return serverResponse;
    }
    @PutMapping("/resume/name")
    @ResponseBody
    public ServerResponse update(Integer resumeId,  String resumeName){

        Resume resume = new Resume();
        resume.setResumeId(resumeId);
        resume.setResumeName(resumeName);
        resume.setResumeUpdateTime(new Date());

        ServerResponse serverResponse = resumeService.modify(resume);
        if (serverResponse.getStatus() == 1) {
            //修改成功后，需要重新查询该resume (根据主键查询)
            serverResponse = resumeService.getById(resumeId);
        }
        return serverResponse;
    }

    @GetMapping("/resume/custInfo")
    @ResponseBody
    public ServerResponse updateCustInfo(Integer resumeId , String custName, String custGender,  String custBirthday,
                                         String custStartWorkyear, Long custTelno,String custWorkStatus, String custEmail ,
                                         String custLocation,  String custPersonId){
        Date custBirth = DateUtil.string2Date(custBirthday);

        Resume resume=new Resume();
        resume.setResumeId(resumeId);
        resume.setOther1(custName);
        resume.setResumeGender(custGender);
        resume.setResumeBirth(custBirth);
        resume.setOther2(custStartWorkyear);
        resume.setResumeTelno(custTelno);
        resume.setResumeEmail(custEmail);
        resume.setResumeLeavingWorking(custWorkStatus);
        resume.setResumeLiveCity(custLocation);
        resume.setResumePersonid(custPersonId);
        resume.setResumeUpdateTime(new Date());

        ServerResponse serverResponse=resumeService.modify(resume);
        if(serverResponse.getStatus()==1){//修改成功
            serverResponse=resumeService.getById(resumeId);
        }
       return serverResponse;
    }
    @PutMapping("/resume/yearsalary")
    @ResponseBody
    public ServerResponse updateYearSalary( Integer resumeId,Integer salary){
        Resume resume=new Resume();
        resume.setResumeId(resumeId);
        resume.setResumeIncome(salary);
        resume.setResumeUpdateTime(new Date());
        ServerResponse serverResponse=resumeService.modify(resume);
        if(serverResponse.getStatus()==1){//修改成功
            serverResponse=resumeService.getById(resumeId);
        }
        return serverResponse;
    }
    //获得当前登录用户的所有简历（最多只有三个,返回JSON数据）
    @GetMapping("/resume/list")
    @ResponseBody
    public ServerResponse getAllResumeByCustIdJSON(HttpServletRequest request){
        Customer customer = (Customer)  request.getSession().getAttribute("loginCustomer");
        Integer custId = customer.getCustId();
        ServerResponse serverResponse = resumeService.getAllByCustId(custId);

        return serverResponse;
    }
    @GetMapping("/resume/preview/{id}")
    public ModelAndView getPreview(@PathVariable("id") Integer resumeId){
        ModelAndView modelAndView=new ModelAndView();
        ServerResponse serverResponse = resumeService.getResumeAllVOById(resumeId);
        modelAndView.addObject("resumeVO",serverResponse.getData());
        modelAndView.setViewName("/resume/preview");
        return modelAndView;
    }

}
