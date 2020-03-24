package com.aistar.pojo;

public class CustomerAllResumeDeliveryVO {
    private ResumeDeliveryRecord resumeDeliveryRecord;
    private Resume resume;
    private Job job;
    private Company company;

    public ResumeDeliveryRecord getResumeDeliveryRecord() {
        return resumeDeliveryRecord;
    }

    public void setResumeDeliveryRecord(ResumeDeliveryRecord resumeDeliveryRecord) {
        this.resumeDeliveryRecord = resumeDeliveryRecord;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
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
        return "CustomerAllResumeDeliveryVO{" +
                "resumeDeliveryRecord=" + resumeDeliveryRecord +
                ", resume=" + resume +
                ", job=" + job +
                ", company=" + company +
                '}';
    }
}
