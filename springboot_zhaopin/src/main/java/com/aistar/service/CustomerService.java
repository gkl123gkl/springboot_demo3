package com.aistar.service;

import com.aistar.pojo.Customer;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/2/12.
 */
public interface CustomerService extends BaseService<Customer> {
    public ServerResponse getByTelno(Long telno);
    public ServerResponse getByAccountAndPwd(Integer type, String account, String password);
    public ServerResponse getByUsernameAndPassword(String username, String password);

}
