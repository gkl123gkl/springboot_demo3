package com.aistar.service;

import com.aistar.pojo.Resume;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/2/28.
 */
public interface ResumeService extends BaseService<Resume> {
    //根据用户id 查询简历个数
    public ServerResponse getCountByCustId(Integer custId);

    //根据用户id和简历名称 查询简历个数
    public ServerResponse getCountByCustId(Integer custId, String resumeName);

    //获得当用户最近创建的简历
    public ServerResponse getLatestOne(Integer custId);

    //获得当前用户所有简历
    public ServerResponse getAllByCustId(Integer custId);

    //根据id查询简历详情
    public ServerResponse getResumeAllVOById(Integer resumeId);




}
