package com.aistar.controller;

import com.aistar.pojo.WorkExperience;
import com.aistar.service.WorkExperienceService;
import com.aistar.service.impl.WorkExperienceServiceImpl;
import com.aistar.util.DateUtil;
import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by admin on 2020/3/16.
 */
@Controller
public class workExperienceController {
    @Autowired
    private WorkExperienceService workExperienceService;
    @PostMapping("/workexperience")
    @ResponseBody
    //添加新的工作经验
    public ServerResponse add(Integer resumeId, String startWorkTimeStr, String endWorkTimeStr, String companyName,
                              String jobName, String companySize,String depatement, String companyType, String jobDescription,
                              String jobType )  {


        //数据类型转换
        Date startWorkTime =  DateUtil.string2DateYM(startWorkTimeStr);
        Date endWorkTime =  DateUtil.string2DateYM(endWorkTimeStr);

        //封装成WorkExperience 对象
        WorkExperience experience =   new WorkExperience();
        experience.setResumeId(resumeId);
        experience.setWorkStartTime(startWorkTime);
        experience.setWorkEndTime(endWorkTime);
        experience.setWorkCompanyName(companyName);
        experience.setWorkPosition(jobName);
        experience.setWorkCompanyScaler(companySize);
        experience.setWorkDepartment(depatement);
        experience.setWorkCompanyProperty(companyType);
        experience.setWorkDesc(jobDescription);
        experience.setWorkType(jobType);
        experience.setStatus(0);


        ServerResponse serverResponse = workExperienceService.add(experience);

        if(serverResponse.getStatus() ==1){
            serverResponse =  workExperienceService.getLatestByResumeId(resumeId);
        }
       return serverResponse;
    }
    @GetMapping("/workexperience/{workExperienceId}")
    @ResponseBody
    public ServerResponse  detail(@PathVariable("workExperienceId") Integer id){

        ServerResponse serverResponse =  workExperienceService.getById(id);
        return serverResponse;
    }
    @PutMapping("/workexperience")
    @ResponseBody
    public ServerResponse update(Integer workExperienceId, String startWorkTimeStr, String endWorkTimeStr, String companyName,
                                 String jobPosition, String companySize,String deptName, String companyType, String jobDesc,
                                 String jobType){

        //数据类型转换
        Date startWorkTime =  DateUtil.string2DateYM(startWorkTimeStr);
        Date endWorkTime =  DateUtil.string2DateYM(endWorkTimeStr);

        //封装成WorkExperience 对象
        WorkExperience experience =   new WorkExperience();
        experience.setWorkExperiId(workExperienceId);
        experience.setWorkStartTime(startWorkTime);
        experience.setWorkEndTime(endWorkTime);
        experience.setWorkCompanyName(companyName);
        experience.setWorkPosition(jobPosition);
        experience.setWorkCompanyScaler(companySize);
        experience.setWorkDepartment(deptName);
        experience.setWorkCompanyProperty(companyType);
        experience.setWorkDesc(jobDesc);
        experience.setWorkType(jobType);
        experience.setStatus(0);

        ServerResponse serverResponse = workExperienceService.modify(experience);
        if(serverResponse.getStatus() ==1){
            serverResponse =  workExperienceService.getById(workExperienceId);
        }
       return serverResponse;
    }

}
