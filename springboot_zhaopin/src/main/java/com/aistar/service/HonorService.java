package com.aistar.service;

import com.aistar.pojo.Honor;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/3/2.
 */
public interface HonorService extends BaseService<Honor> {
    public ServerResponse getAllByResumeId(Integer resumeId);
}
