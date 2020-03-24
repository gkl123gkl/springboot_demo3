package com.aistar.service.impl;

import com.aistar.mapper.CustomerMapper;
import com.aistar.pojo.Customer;
import com.aistar.pojo.CustomerExample;
import com.aistar.service.CustomerService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by admin on 2020/2/12.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
private CustomerMapper customerMapper;

    @Override
    public ServerResponse add(Customer customer) {

        int rows=customerMapper.insert(customer);

        if(rows==0){
            return ServerResponse.addFailed();
        }else {
            return ServerResponse.addSuccess();
        }

    }

    @Override
    public ServerResponse modify(Customer customer) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(Customer customer) {
        return null;
    }

    @Override
    public ServerResponse getById(Integer id) {
        Customer customer=customerMapper.selectByPrimaryKey(id);
        if(customer!=null){
            return ServerResponse.getDataSuccess(customer);
        }else{
            return ServerResponse.getDataFailed("暂无数据");
        }
    }

    @Override
    public ServerResponse getAll() {
        return null;
    }

    @Override
    public ServerResponse getByTelno(Long telno) {

        CustomerExample example=new CustomerExample();
        CustomerExample.Criteria criteria=example.createCriteria();
        criteria.andCustTelnoEqualTo(telno);
        List<Customer> customerList=customerMapper.selectByExample(example);

        if(customerList!=null && customerList.size()>0){//找到用户了
            Customer customer=customerList.get(0);
            return ServerResponse.hasRegist();// 1,"查询数据成功",customer
        }else {// 用户不存在
            return ServerResponse.noRegist(); // 0,"查询数据失败","用户不存在"
        }
    }
    //根据账户密码查询用户
    @Override
    public ServerResponse getByAccountAndPwd(Integer type, String account, String password) {
        CustomerExample example=new CustomerExample();
        CustomerExample.Criteria criteria=example.createCriteria();
       switch(type){
           case 0:{
               Long telno=Long.valueOf(account);
               criteria.andCustTelnoEqualTo(telno);
               break;
           }
           case 1:{
               criteria.andCustEmailEqualTo(account);
               break;
           }
           case 2:{
               criteria.andCustNameEqualTo(account);
               break;
           }
       }
        criteria.andCustPasswordEqualTo(password);
        List<Customer> customerList=customerMapper.selectByExample(example);
        if(customerList!=null && customerList.size()>0){
            Customer customer=customerList.get(0);
            return ServerResponse.getDataSuccess(customerList.get(0));
        }else {// 用户不存在
            return ServerResponse.getDataFailed("登录失败");
        }
    }
    @Override
    public ServerResponse getByUsernameAndPassword(String username, String password) {

        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andCustPasswordEqualTo(password).andCustNameEqualTo(username);
        List<Customer> customerList = customerMapper.selectByExample(example);
        if (customerList != null && customerList.size() > 0) {
            Customer customer = customerList.get(0);
            return ServerResponse.getDataSuccess(customerList.get(0));
        } else {// 用户不存在
            return ServerResponse.getDataFailed("登录失败");
        }
    }
}

