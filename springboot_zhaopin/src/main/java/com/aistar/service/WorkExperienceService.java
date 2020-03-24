package com.aistar.service;

import com.aistar.pojo.WorkExperience;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/3/2.
 */
public interface WorkExperienceService extends BaseService<WorkExperience> {
    public ServerResponse getLatestByResumeId(Integer resumId);
    public ServerResponse getAllByResumeId(Integer resumeId) ;
}
