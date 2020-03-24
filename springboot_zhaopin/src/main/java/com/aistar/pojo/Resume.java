package com.aistar.pojo;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_id
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Integer resumeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.cust_id
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Integer custId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_name
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_create_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Date resumeCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_update_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Date resumeUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_profile
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeProfile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_birth
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Date resumeBirth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_telno
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Long resumeTelno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_email
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_gender
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_leaving__working
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeLeavingWorking;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_live_city
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeLiveCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_personid
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumePersonid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_income
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Integer resumeIncome;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_full_part_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String resumeFullPartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.status
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.other1
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String other1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.other2
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private String other2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resume
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_id
     *
     * @return the value of resume.resume_id
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Integer getResumeId() {
        return resumeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_id
     *
     * @param resumeId the value for resume.resume_id
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.cust_id
     *
     * @return the value of resume.cust_id
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.cust_id
     *
     * @param custId the value for resume.cust_id
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_name
     *
     * @return the value of resume.resume_name
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeName() {
        return resumeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_name
     *
     * @param resumeName the value for resume.resume_name
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeName(String resumeName) {
        this.resumeName = resumeName == null ? null : resumeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_create_time
     *
     * @return the value of resume.resume_create_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Date getResumeCreateTime() {
        return resumeCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_create_time
     *
     * @param resumeCreateTime the value for resume.resume_create_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeCreateTime(Date resumeCreateTime) {
        this.resumeCreateTime = resumeCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_update_time
     *
     * @return the value of resume.resume_update_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Date getResumeUpdateTime() {
        return resumeUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_update_time
     *
     * @param resumeUpdateTime the value for resume.resume_update_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeUpdateTime(Date resumeUpdateTime) {
        this.resumeUpdateTime = resumeUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_profile
     *
     * @return the value of resume.resume_profile
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeProfile() {
        return resumeProfile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_profile
     *
     * @param resumeProfile the value for resume.resume_profile
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeProfile(String resumeProfile) {
        this.resumeProfile = resumeProfile == null ? null : resumeProfile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_birth
     *
     * @return the value of resume.resume_birth
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Date getResumeBirth() {
        return resumeBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_birth
     *
     * @param resumeBirth the value for resume.resume_birth
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeBirth(Date resumeBirth) {
        this.resumeBirth = resumeBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_telno
     *
     * @return the value of resume.resume_telno
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Long getResumeTelno() {
        return resumeTelno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_telno
     *
     * @param resumeTelno the value for resume.resume_telno
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeTelno(Long resumeTelno) {
        this.resumeTelno = resumeTelno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_email
     *
     * @return the value of resume.resume_email
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeEmail() {
        return resumeEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_email
     *
     * @param resumeEmail the value for resume.resume_email
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeEmail(String resumeEmail) {
        this.resumeEmail = resumeEmail == null ? null : resumeEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_gender
     *
     * @return the value of resume.resume_gender
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeGender() {
        return resumeGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_gender
     *
     * @param resumeGender the value for resume.resume_gender
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeGender(String resumeGender) {
        this.resumeGender = resumeGender == null ? null : resumeGender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_leaving__working
     *
     * @return the value of resume.resume_leaving__working
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeLeavingWorking() {
        return resumeLeavingWorking;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_leaving__working
     *
     * @param resumeLeavingWorking the value for resume.resume_leaving__working
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeLeavingWorking(String resumeLeavingWorking) {
        this.resumeLeavingWorking = resumeLeavingWorking == null ? null : resumeLeavingWorking.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_live_city
     *
     * @return the value of resume.resume_live_city
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeLiveCity() {
        return resumeLiveCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_live_city
     *
     * @param resumeLiveCity the value for resume.resume_live_city
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeLiveCity(String resumeLiveCity) {
        this.resumeLiveCity = resumeLiveCity == null ? null : resumeLiveCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_personid
     *
     * @return the value of resume.resume_personid
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumePersonid() {
        return resumePersonid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_personid
     *
     * @param resumePersonid the value for resume.resume_personid
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumePersonid(String resumePersonid) {
        this.resumePersonid = resumePersonid == null ? null : resumePersonid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_income
     *
     * @return the value of resume.resume_income
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Integer getResumeIncome() {
        return resumeIncome;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_income
     *
     * @param resumeIncome the value for resume.resume_income
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeIncome(Integer resumeIncome) {
        this.resumeIncome = resumeIncome;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_full_part_time
     *
     * @return the value of resume.resume_full_part_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getResumeFullPartTime() {
        return resumeFullPartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_full_part_time
     *
     * @param resumeFullPartTime the value for resume.resume_full_part_time
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setResumeFullPartTime(String resumeFullPartTime) {
        this.resumeFullPartTime = resumeFullPartTime == null ? null : resumeFullPartTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.status
     *
     * @return the value of resume.status
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.status
     *
     * @param status the value for resume.status
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.other1
     *
     * @return the value of resume.other1
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getOther1() {
        return other1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.other1
     *
     * @param other1 the value for resume.other1
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.other2
     *
     * @return the value of resume.other2
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public String getOther2() {
        return other2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.other2
     *
     * @param other2 the value for resume.other2
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume
     *
     * @mbggenerated Thu Feb 13 09:39:32 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resumeId=").append(resumeId);
        sb.append(", custId=").append(custId);
        sb.append(", resumeName=").append(resumeName);
        sb.append(", resumeCreateTime=").append(resumeCreateTime);
        sb.append(", resumeUpdateTime=").append(resumeUpdateTime);
        sb.append(", resumeProfile=").append(resumeProfile);
        sb.append(", resumeBirth=").append(resumeBirth);
        sb.append(", resumeTelno=").append(resumeTelno);
        sb.append(", resumeEmail=").append(resumeEmail);
        sb.append(", resumeGender=").append(resumeGender);
        sb.append(", resumeLeavingWorking=").append(resumeLeavingWorking);
        sb.append(", resumeLiveCity=").append(resumeLiveCity);
        sb.append(", resumePersonid=").append(resumePersonid);
        sb.append(", resumeIncome=").append(resumeIncome);
        sb.append(", resumeFullPartTime=").append(resumeFullPartTime);
        sb.append(", status=").append(status);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}