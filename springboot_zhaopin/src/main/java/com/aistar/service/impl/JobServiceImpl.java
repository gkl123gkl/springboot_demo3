package com.aistar.service.impl;

import com.aistar.mapper.CompanyMapper;
import com.aistar.mapper.JobMapper;
import com.aistar.pojo.Company;
import com.aistar.pojo.Job;
import com.aistar.pojo.JobCompanyDO;
import com.aistar.pojo.JobExample;
import com.aistar.service.JobService;
import com.aistar.util.ServerResponse;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2020/2/25.
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override//查询最新的10条记录
    public ServerResponse getSomeLatest() {

        JobExample example=new JobExample();
        JobExample.Criteria criteria=example.createCriteria();
        criteria.andStatusEqualTo(0);
        example.setOrderByClause("job_publish_time desc");

        List<Job> jobList=jobMapper.selectByExample(example);

        return ServerResponse.getDataSuccess(jobList);
    }

    @Override//关键字搜索
    public ServerResponse getByJobNameAndKeyword(String kw, Integer pageNum) {

        JobExample example=new JobExample();
        JobExample.Criteria criteria1=example.createCriteria();
        JobExample.Criteria criteria2=example.createCriteria();
        if(kw!=null){
            criteria1.andStatusEqualTo(0).andJobNameLike(kw);
            criteria2.andStatusEqualTo(0).andJobSearchKeywordLike(kw);
            example.or(criteria1);
            example.or(criteria2);
        }else{
            example.createCriteria().andStatusEqualTo(0);
        }
        example.setOrderByClause("job_publish_time desc");

        List<Job> jobList = jobMapper.selectByExample(example);

        System.out.println(jobList.size());
        for(Job job:jobList){
            System.out.println(job.getJobId()+"," + job.getJobName()+ ","+job.getJobSearchKeyword()+","+ job.getJobPublishTime());
        }
        if(jobList!=null && jobList.size()>0)
            return ServerResponse.getDataSuccess(jobList)  ;
        else
            return  ServerResponse.getDataFailed("对不起，没有找到符合你条件的职位！")    ;
    }

    @Override
    public ServerResponse getAll(String kw, String city, Date publishTime, Float minSalary, Float maxSalary, String company, String workYear, String degree, Integer pageNum) {
        //最后的数据集合的本质
        List<JobCompanyDO> jobCompanyDOList=new ArrayList<>();
        //分页查询
        Page<Job> page = PageHelper.startPage(pageNum,5);  // 分页查询 是job的分页查询
//        System.out.println("page:   "+page);
        List<Job> jobList = jobMapper.selectAllJobBySearch(kw,city,publishTime,minSalary,maxSalary,workYear,degree,company);// select * from job where ... limit....
//        System.out.println("jobList:   "+jobList);
        PageInfo pageInfo = page.toPageInfo();  //PageInfo只有Job,需要改成PageInfo<JobCompanyDO>

        //再封装Company 根据job_id查询所属公司 company
        // select * from company where company_id = ? (company_id 来源于 Job对象中的)
        for(Job job:jobList){
            Company com=companyMapper.selectByPrimaryKey(job.getCompanyId());
            jobCompanyDOList.add(new JobCompanyDO(job,com));
        }
        pageInfo.setList(jobCompanyDOList);
        if(jobCompanyDOList!=null && jobCompanyDOList.size()>0){
            return ServerResponse.getDataSuccess(pageInfo);
        }else{
            return ServerResponse.getDataFailed("对不起，没有找到符合你条件的职位！");
        }
    }


    @Override
    public ServerResponse add(Job job) {
        return null;
    }

    @Override
    public ServerResponse modify(Job job) {
        return null;
    }

    @Override
    public ServerResponse modifyStatus(Job job) {
        return null;
    }

    @Override
    public ServerResponse getById(Integer id) {
        Job job=jobMapper.selectByPrimaryKey(id);
        if(job==null){
            return ServerResponse.getDataFailed("暂无岗位");
        }else{
            Company company=companyMapper.selectByPrimaryKey(job.getCompanyId());
            JobCompanyDO jobCompanyDO=new JobCompanyDO(job,company);

            return ServerResponse.getDataSuccess(jobCompanyDO);
        }
    }

    @Override
    public ServerResponse getAll() {
       return null;
    }




}
