package com.aistar.service.impl;

import com.aistar.mapper.SkillMapper;
import com.aistar.pojo.Skill;
import com.aistar.pojo.SkillExample;
import com.aistar.service.SkillService;
import com.aistar.util.ServerResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/3/2.
 */
@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillMapper skillMapper;
    @Override
    public ServerResponse add(Skill skill) {

        int rows = skillMapper.insert(skill);

        if(rows >0)
            return ServerResponse.addSuccess();
        return ServerResponse.addFailed();
    }

    @Override
    public ServerResponse modify(Skill skill) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(Skill skill) {
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

        SkillExample example = new SkillExample();
        SkillExample.Criteria criteria=example.createCriteria();
        criteria.andResumeIdEqualTo(resumeId).andStatusEqualTo(0);
        List<Skill> skillList =  skillMapper.selectByExample(example);
        if(skillList!=null && skillList.size() >0)
            return ServerResponse.getDataSuccess(skillList);
        return ServerResponse.getDataFailed("暂无专业技能");
    }
}
