package com.aistar.pojo;

/**
 * Created by admin on 2020/2/27.
 */
public class JobCompanyDO {
    private Job job;
    private Company company;

    public JobCompanyDO(){}

    public JobCompanyDO(Job job, Company company) {
        this.job = job;
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "JobCompanyDO{" +
                "job=" + job +
                ", company=" + company +
                '}';
    }
}
