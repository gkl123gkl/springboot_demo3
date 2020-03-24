package com.aistar.controller;

import com.aistar.pojo.Customer;
import com.aistar.service.CustomerService;
import com.aistar.service.impl.CustomerServiceImpl;
import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by admin on 2020/3/12.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    @ResponseBody
    public ServerResponse getById(@PathVariable("id") Integer custId){
        ServerResponse serverResponse=customerService.getById(custId);
        return serverResponse;
    }
//根据手机号查询用户，用户注册
    @PostMapping("/customer/login")
    @ResponseBody
    public ServerResponse login(Integer type,String account,String custPassword,HttpServletRequest request) {
        ServerResponse serverResponse=customerService.getByAccountAndPwd(type,account,custPassword);
        if(serverResponse.getStatus() ==1){//登录成功
            request.getSession().setAttribute("loginCustomer",serverResponse.getData());
//            request.getSession().setAttribute("loginAccount",account);
        }
      return serverResponse;
    }
    //根据手机号查询用户
    @GetMapping("/customer/getByTelno/{telno}")
    @ResponseBody
    public ServerResponse getByTelno (@PathVariable("telno") Long telno) {
        ServerResponse serverResponse=customerService.getByTelno(telno);
        System.out.println("server response:"+serverResponse);
        return serverResponse;
    }
//用户注册，添加用户
    @PostMapping("/customer/regist")
    @ResponseBody
    public ServerResponse add(Long custTelno,String custPassword){
        //1.接收参数
        //2.封装成customer对象
        Customer customer=new Customer();
        customer.setCustTelno(custTelno);
        customer.setCustPassword(custPassword);
        customer.setCustRegistTime(new Date());//注册时间

        //3.server添加数据

        ServerResponse serverResponse=customerService.add(customer);

        //4.serverResponse json
       return serverResponse;
    }

    @PostMapping("/customer/getCode")
    @ResponseBody
    public ServerResponse getCode( Long telno) {
        ServerResponse serverResponse = null;
        if (telno == null) {
            serverResponse = ServerResponse.getDataFailed("请输入手机号"); //0 手机号为空
        } else {
            //调用短信接口
//                 String code =  SmsApiHttpSendTest.getCode(telnoStr);
            String code = "666666";
            System.out.println("code:" + code);
            serverResponse = ServerResponse.getDataSuccess(code);
            serverResponse.setStatus(2);
        }
        return serverResponse;
    }
}
