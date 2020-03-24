package com.aistar.controller;

import com.aistar.pojo.Customer;
import com.aistar.pojo.ResumeDeliveryRecord;
import com.aistar.service.ResumeDeliveryRecordService;
import com.aistar.service.impl.ResumeDeliveryRecordServiceImpl;
import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by admin on 2020/3/3.
 */
@Controller
public class ResumeDeliveryRecordcontroller extends HttpServlet {

    @Autowired
    private ResumeDeliveryRecordService resumeDeliveryRecordService;

    @PostMapping("/resumeDeliveryRecord")
    @ResponseBody
    public ServerResponse add(Integer resumeId,Integer jobId,HttpServletRequest request){

        Customer customer=(Customer) request.getSession().getAttribute("loginCustomer");
        Integer custId=customer.getCustId();
        ResumeDeliveryRecord resumeDeliveryRecord=new ResumeDeliveryRecord();
        resumeDeliveryRecord.setCustId(custId);
        resumeDeliveryRecord.setJobId(jobId);
        resumeDeliveryRecord.setResumeId(resumeId);
        resumeDeliveryRecord.setDeliveryTime(new Date());

        ServerResponse serverResponse=resumeDeliveryRecordService.add(resumeDeliveryRecord);
        return serverResponse;
    }
    @GetMapping("/resumeDeliveryRecord")
    @ResponseBody
    public ServerResponse getCustomerAllResumeDeliveryRecord(HttpServletRequest request)   {
        Customer customer =(Customer) request.getSession().getAttribute("loginCustomer");
        Integer custId = customer.getCustId();

        ServerResponse serverResponse = resumeDeliveryRecordService.getCustomerAllResumeDeliveryVO(custId);
        return serverResponse;
    }
}
