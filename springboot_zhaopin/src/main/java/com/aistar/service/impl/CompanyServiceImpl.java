package com.aistar.service.impl;

import com.aistar.mapper.CompanyMapper;
import com.aistar.pojo.Company;
import com.aistar.service.CompanyService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2020/3/3.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ServerResponse add(Company company) {
        return null;
    }

    @Override
    public ServerResponse modify(Company company) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(Company company) {
        return null;
    }

    @Override
    public ServerResponse getById(Integer id) {
        Company company = companyMapper.selectByPrimaryKey(id);

        if(company==null)
            return ServerResponse.getDataFailed("暂无数据");

        return ServerResponse.getDataSuccess(company) ;
    }

    @Override
    public ServerResponse getAll() {
        return null;
    }
}
