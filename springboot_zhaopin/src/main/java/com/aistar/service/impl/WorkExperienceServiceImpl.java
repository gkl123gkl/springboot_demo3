package com.aistar.service.impl;

import com.aistar.mapper.WorkExperienceMapper;
import com.aistar.pojo.WorkExperience;
import com.aistar.pojo.WorkExperienceExample;
import com.aistar.service.WorkExperienceService;
import com.aistar.util.ServerResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/3/2.
 */
@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Autowired
    private WorkExperienceMapper workExperienceMapper;
    @Override
    public ServerResponse add(WorkExperience workExperience) {

        int rows = workExperienceMapper.insert(workExperience);

        if(rows >0)
            return ServerResponse.addSuccess();
        return ServerResponse.addFailed();
    }

    @Override
    public ServerResponse modify(WorkExperience workExperience) {

        int rows = workExperienceMapper.updateByPrimaryKeySelective(workExperience);

        if(rows >0)
            return ServerResponse.updateSuccess();
        return ServerResponse.updateFailed();
    }

    @Override
    public ServerResponse modifyStatus(WorkExperience workExperience) {
        return null;
    }

    @Override
    public ServerResponse getById(Integer id) {

        WorkExperience experience = workExperienceMapper.selectByPrimaryKey(id);

        if(experience !=null)
            return ServerResponse.getDataSuccess(experience);
        return ServerResponse.getDataFailed("没有该工作经验");
    }


    @Override
    public ServerResponse getAll() {
        return null;
    }


    ////获得到当前用户的某个简历中最新添加的工作经验
    @Override
    public ServerResponse getLatestByResumeId(Integer resumId) {

        WorkExperienceExample example =new WorkExperienceExample();
        WorkExperienceExample.Criteria criteria=example.createCriteria();
        criteria.andResumeIdEqualTo(resumId).andStatusEqualTo(0);
        example.setOrderByClause("work_experi_id desc");
        WorkExperience experience=workExperienceMapper.selectByExample(example).get(0);
        return ServerResponse.getDataSuccess(experience);
    }

    @Override
    public ServerResponse getAllByResumeId(Integer resumeId) {

        WorkExperienceExample example = new WorkExperienceExample();
        WorkExperienceExample.Criteria criteria=example.createCriteria();
        criteria.andResumeIdEqualTo(resumeId).andStatusEqualTo(0);
        List<WorkExperience> workExperienceList =  workExperienceMapper.selectByExample(example);
        if(workExperienceList!=null && workExperienceList.size() >0)
            return ServerResponse.getDataSuccess(workExperienceList);
        return ServerResponse.getDataFailed("暂无工作经验");
    }
}

