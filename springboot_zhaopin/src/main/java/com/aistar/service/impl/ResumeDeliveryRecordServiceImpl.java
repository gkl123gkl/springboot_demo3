package com.aistar.service.impl;

import com.aistar.mapper.ResumeDeliveryRecordMapper;
import com.aistar.pojo.*;
import com.aistar.service.JobService;
import com.aistar.service.ResumeDeliveryRecordService;
import com.aistar.service.ResumeService;
import com.aistar.util.DateUtil;
import com.aistar.util.ServerResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2020/3/3.
 */
@Service
public class ResumeDeliveryRecordServiceImpl implements ResumeDeliveryRecordService {
    @Autowired
    private ResumeDeliveryRecordMapper resumeDeliveryRecordMapper;
    @Autowired
    private ResumeService resumeService;
 @Autowired
    private JobService jobService;

    @Override
    public ServerResponse add(ResumeDeliveryRecord resumeDeliveryRecord) {
        ServerResponse serverResponse=getRecordInMonth(resumeDeliveryRecord.getJobId(),resumeDeliveryRecord.getResumeId());
      if(serverResponse.getStatus()==1){//有记录，不能重复投递，即不能添加
          return ServerResponse.addFailed();
      }else{//没有记录，可以投递

          int rows=resumeDeliveryRecordMapper.insert(resumeDeliveryRecord);

           return ServerResponse.addSuccess();//添加成功，投递成功
          }
      }

    @Override
    public ServerResponse modify(ResumeDeliveryRecord resumeDeliveryRecord) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(ResumeDeliveryRecord resumeDeliveryRecord) {
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


    //查询一个月之内 不能投递重复的岗位
    @Override
    public ServerResponse getRecordInMonth(Integer jobId, Integer resumeId) {

        ResumeDeliveryRecordExample example=new ResumeDeliveryRecordExample();
        ResumeDeliveryRecordExample.Criteria criteria=example.createCriteria();
        criteria.andJobIdEqualTo(jobId).andResumeIdEqualTo(resumeId).andDeliveryTimeGreaterThanOrEqualTo(DateUtil.getBeforeDate(-30));
        List<ResumeDeliveryRecord> resumeDeliveryRecordList=resumeDeliveryRecordMapper.selectByExample(example);

        if(resumeDeliveryRecordList!=null && resumeDeliveryRecordList.size()>0){ // 有投递记录
            return ServerResponse.getDataSuccess(resumeDeliveryRecordList); // 1
        }else{
            return ServerResponse.getDataFailed("没有投递记录");// 0
        }
    }

    @Override
    public ServerResponse getCustomerAllResumeDeliveryVO(Integer custId) {
        List<CustomerAllResumeDeliveryVO> voList = new ArrayList<>();
        ResumeDeliveryRecordExample example = new ResumeDeliveryRecordExample();
        example.createCriteria().andCustIdEqualTo(custId).andDeliveryStatusEqualTo(0);
        example.setOrderByClause("delivery_time desc");
        List<ResumeDeliveryRecord> recordList =  resumeDeliveryRecordMapper.selectByExample(example);
        for(ResumeDeliveryRecord record:recordList){
            CustomerAllResumeDeliveryVO vo = new CustomerAllResumeDeliveryVO();
            vo.setResumeDeliveryRecord(record);
            System.out.print("申请投递id:" + record.getResumeDeliveryRecordId());

            ServerResponse resumeServerResponse = resumeService.getById(record.getResumeId());
            Resume resume = (Resume) resumeServerResponse.getData();
            vo.setResume(resume);
            System.out.print("简历id:" + resume.getResumeId());

            ServerResponse jobServerResponse = jobService.getById(record.getJobId());
            JobCompanyVO jobCompanyVO = (JobCompanyVO) jobServerResponse.getData();
            vo.setJob(jobCompanyVO.getJob());
            vo.setCompany(jobCompanyVO.getCompany());
            System.out.print(",职位id:" + jobCompanyVO.getJob().getJobId() + ",职位名称：" + jobCompanyVO.getJob().getJobName());
            System.out.print("公司id:" + jobCompanyVO.getCompany().getCompanyId() + ", 公司名：" + jobCompanyVO.getCompany().getCompanyName());
            voList.add(vo);
        }
        System.out.println();
        if(voList.size() >0)
            return ServerResponse.getDataSuccess(voList);
        return ServerResponse.getDataFailed("暂无投递记录");


    }
}
