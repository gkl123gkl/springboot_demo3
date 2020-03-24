package com.aistar.service;

import com.aistar.pojo.Skill;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/3/2.
 */
public interface SkillService extends BaseService<Skill> {
    public ServerResponse getAllByResumeId(Integer resumeId);
}
