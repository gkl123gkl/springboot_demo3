package com.aistar.service;

import com.aistar.pojo.ProjectExperience;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/3/2.
 */
public interface ProjectExperienceService extends BaseService<ProjectExperience> {
    public ServerResponse getAllByResumeId(Integer resumeId);
}
