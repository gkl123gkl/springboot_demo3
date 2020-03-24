package com.aistar.service.impl;

import com.aistar.mapper.ResumeMapper;
import com.aistar.pojo.*;
import com.aistar.service.*;
import com.aistar.util.ServerResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/2/28.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private WorkExperienceService workExperienceService;
    @Autowired
    private ProjectExperienceService projectExperienceService;
    @Autowired
    private HonorService honorService;
    @Autowired
    private SkillService skillService;


    @Override
    public ServerResponse add(Resume resume) {

        ServerResponse serverResponse=getCountByCustId(resume.getCustId(),resume.getResumeName());
        if(serverResponse.getStatus()==1){//简历不存在，需要创建
            int rows=resumeMapper.insert(resume);

            if(rows>0){
                return ServerResponse.addSuccess();
            }else{
                return ServerResponse.addFailed();
            }
        }else{
            return serverResponse;
        }
    }

    @Override
    public ServerResponse modify(Resume resume) {

        int rows = resumeMapper.updateByPrimaryKeySelective(resume);

        if(rows>0){
            return ServerResponse.updateSuccess();
        }else{
            return ServerResponse.updateFailed();
        }
    }

    @Override
    public ServerResponse modifyStatus(Resume resume) {
        return null;
    }

    @Override
    public ServerResponse getById(Integer id) {

        Resume resume = resumeMapper.selectByPrimaryKey(id);

        return ServerResponse.getDataSuccess(resume);
    }

    @Override
    public ServerResponse getAll() {
        return null;
    }

    @Override
    public ServerResponse getCountByCustId(Integer custId) {

        ResumeExample example = new ResumeExample();
        example.createCriteria().andCustIdEqualTo(custId).andStatusEqualTo(0);
        int count = resumeMapper.countByExample(example);

        System.out.println("该用户的已有简历的个数：" + count);
        if(count <3){
            return ServerResponse.getDataSuccess("可以创建新简历");
        }else{
            return ServerResponse.getDataFailed("最多只能创建3份简历");
            }
    }

    @Override
    public ServerResponse getCountByCustId(Integer custId, String resumeName) {

        ResumeExample example = new ResumeExample();
        example.createCriteria().andCustIdEqualTo(custId).andStatusEqualTo(0).andResumeNameEqualTo(resumeName);

        int count = resumeMapper.countByExample(example);

        System.out.println("该用户的已有简历的个数：" + count);
        if(count ==0){
            return ServerResponse.getDataSuccess("简历不存在");
        }
        return ServerResponse.getDataFailed("该简历名称已存在，请重命名简历名称");
    }


    //查询当前用户最新添加的简历
    @Override
    public ServerResponse getLatestOne(Integer custId) {

        ResumeExample example = new ResumeExample();
        example.createCriteria().andCustIdEqualTo(custId).andStatusEqualTo(0);
        example.setOrderByClause("resume_create_time desc" );
        Resume resume =  resumeMapper.selectByExample(example).get(0);
        return ServerResponse.getDataSuccess(resume);
    }

    @Override
    public ServerResponse getAllByCustId(Integer custId) {

        ResumeExample example=new ResumeExample();
        ResumeExample.Criteria criteria = example.createCriteria();
        criteria.andCustIdEqualTo(custId).andStatusEqualTo(0);
        List<Resume> resumeList = resumeMapper.selectByExample(example);

        return ServerResponse.getDataSuccess(resumeList);
    }

    @Override
    public ServerResponse getResumeAllVOById(Integer resumeId) {
        ResumeAllVO resumeAllVO=new ResumeAllVO();

        Resume resume = resumeMapper.selectByPrimaryKey(resumeId);
        resumeAllVO.setResume(resume);
        //根据简历id获得所有workExperience

        ServerResponse serverResponse1=workExperienceService.getAllByResumeId(resumeId);
        if(serverResponse1.getStatus()==1){
            List<WorkExperience> workExperienceList=(List<WorkExperience>) serverResponse1.getData();
            resumeAllVO.setWorkExperienceList(workExperienceList);
        }
        //根据简历id获得所有projectExperience

        ServerResponse serverResponse2=projectExperienceService.getAllByResumeId(resumeId);
        if(serverResponse2.getStatus()==1){
            List<ProjectExperience> projectExperienceList=(List<ProjectExperience>) serverResponse1.getData();
            resumeAllVO.setProjectExperienceList(projectExperienceList);
        }
        //根据简历id获得所有honor

        ServerResponse serverResponse3=honorService.getAllByResumeId(resumeId);
        if(serverResponse3.getStatus()==1){
            List<Honor> honorList=(List<Honor>) serverResponse1.getData();
            resumeAllVO.setHonorList(honorList);
        }
        //根据简历id获得所有skill

        ServerResponse serverResponse4=skillService.getAllByResumeId(resumeId);
        if(serverResponse4.getStatus()==1){
            List<Skill> skillList=(List<Skill>) serverResponse1.getData();
            resumeAllVO.setSkillList(skillList);
        }

        return ServerResponse.getDataSuccess(resumeAllVO);

    }
}
