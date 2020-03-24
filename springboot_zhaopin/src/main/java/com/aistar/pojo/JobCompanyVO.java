package com.aistar.pojo;

public class JobCompanyVO {
    private Job job;
    private Company company;


    public JobCompanyVO(){}
    public JobCompanyVO(Job job, Company company) {
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
        return "JobCompanyVO{" +
                "job=" + job +
                ", company=" + company +
                '}';
    }
}
