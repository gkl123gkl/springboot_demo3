package com.aistar.service;

import com.aistar.pojo.ResumeDeliveryRecord;
import com.aistar.util.ServerResponse;

/**
 * Created by admin on 2020/3/3.
 */
public interface ResumeDeliveryRecordService extends BaseService<ResumeDeliveryRecord>{

    //查询一个月之内 不能投递重复的岗位
    public ServerResponse getRecordInMonth(Integer jobId, Integer resumeId);
    //查询当前用户的所有投递记录CustomerAllResumeDeliveryVO
    public ServerResponse getCustomerAllResumeDeliveryVO(Integer custId);
}
