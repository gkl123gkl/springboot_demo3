package com.aistar.service.impl;

import com.aistar.mapper.ProjectExperienceMapper;
import com.aistar.pojo.ProjectExperience;
import com.aistar.pojo.ProjectExperienceExample;
import com.aistar.service.ProjectExperienceService;
import com.aistar.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/3/2.
 */
@Service
public class ProjectExperienceServiceImpl implements ProjectExperienceService {
    @Autowired
    private ProjectExperienceMapper projectExperienceMapper;
    @Override
    public ServerResponse add(ProjectExperience projectExperience) {

        int rows = projectExperienceMapper.insert(projectExperience);

        if(rows >0)
            return ServerResponse.addSuccess();
        return ServerResponse.addFailed();
    }

    @Override
    public ServerResponse modify(ProjectExperience projectExperience) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(ProjectExperience projectExperience) {
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

        ProjectExperienceExample example = new ProjectExperienceExample();
        ProjectExperienceExample.Criteria criteria=example.createCriteria();
        criteria.andResumeIdEqualTo(resumeId).andStatusEqualTo(0);
        List<ProjectExperience> projectExperienceList = projectExperienceMapper.selectByExample(example);
        if(projectExperienceList!=null && projectExperienceList.size() >0)
            return ServerResponse.getDataSuccess(projectExperienceList);
        return ServerResponse.getDataFailed("暂无项目经验");
    }
}
