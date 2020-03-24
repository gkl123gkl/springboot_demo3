package com.aistar.service.impl;

import com.aistar.mapper.HonorMapper;
import com.aistar.pojo.Honor;
import com.aistar.pojo.HonorExample;
import com.aistar.service.HonorService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by admin on 2020/3/2.
 */
@Service
public class HonorServiceImpl implements HonorService{
    @Autowired
    private HonorMapper honorMapper;
    @Override
    public ServerResponse add(Honor honor) {

        int rows = honorMapper.insert(honor);

        if(rows >0)
            return ServerResponse.addSuccess();
        return ServerResponse.addFailed();
    }

    @Override
    public ServerResponse modify(Honor honor) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(Honor honor) {
        return null;
    }

    @Override
    public ServerResponse getById(Integer id) {
        return null;
    }

    @Override
    public ServerResponse getAll() {
        return null;
    }

    @Override
    public ServerResponse getAllByResumeId(Integer resumeId) {

        HonorExample example = new HonorExample();
        HonorExample.Criteria criteria=example.createCriteria();
        criteria.andResumeIdEqualTo(resumeId).andStatusEqualTo(0);
        List<Honor> honorList =  honorMapper.selectByExample(example);
        if(honorList!=null && honorList.size() >0)
            return ServerResponse.getDataSuccess(honorList);
        return ServerResponse.getDataFailed("暂无项目经验");
    }
}
