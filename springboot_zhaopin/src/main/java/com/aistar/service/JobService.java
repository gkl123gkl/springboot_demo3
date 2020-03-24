package com.aistar.service;

import com.aistar.pojo.Job;
import com.aistar.util.ServerResponse;

import java.util.Date;

/**
 * Created by admin on 2020/2/25.
 */
public interface JobService extends BaseService<Job> {
   //查询最新的10条记录
    public ServerResponse getSomeLatest();
    //关键字查询
    public ServerResponse getByJobNameAndKeyword(String kw, Integer pageNum);
    //查询所有

 /**
  * 多条件查询招聘职位记录
  * @param kw 搜索的关键字（职位名称或者关键字）
  * @param city 城市
  * @param publishTime 发布的时间
  * @param minSalary 最低薪资
  * @param maxSalary 最高薪资
  * @param workYear 工作年限
  * @param degree 学历
  * @param company   公司性质
  * @param pageNum   查询的页码
  * @return 返回匹配的招聘记录
  */
    public ServerResponse getAll(String kw, String city, Date publishTime, Float minSalary, Float maxSalary, String company, String workYear, String degree, Integer pageNum);

}
