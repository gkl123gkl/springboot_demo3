package com.aistar.pojo;

import java.io.Serializable;
import java.util.Date;

public class Honor implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.honor_id
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private Integer honorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.resume_id
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private Integer resumeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.honor_create_time
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private Date honorCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.honor_name
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private String honorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.honor_grade
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private String honorGrade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.status
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column honor.other1
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private String other1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table honor
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.honor_id
     *
     * @return the value of honor.honor_id
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public Integer getHonorId() {
        return honorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.honor_id
     *
     * @param honorId the value for honor.honor_id
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setHonorId(Integer honorId) {
        this.honorId = honorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.resume_id
     *
     * @return the value of honor.resume_id
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public Integer getResumeId() {
        return resumeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.resume_id
     *
     * @param resumeId the value for honor.resume_id
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.honor_create_time
     *
     * @return the value of honor.honor_create_time
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public Date getHonorCreateTime() {
        return honorCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.honor_create_time
     *
     * @param honorCreateTime the value for honor.honor_create_time
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setHonorCreateTime(Date honorCreateTime) {
        this.honorCreateTime = honorCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.honor_name
     *
     * @return the value of honor.honor_name
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public String getHonorName() {
        return honorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.honor_name
     *
     * @param honorName the value for honor.honor_name
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setHonorName(String honorName) {
        this.honorName = honorName == null ? null : honorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.honor_grade
     *
     * @return the value of honor.honor_grade
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public String getHonorGrade() {
        return honorGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.honor_grade
     *
     * @param honorGrade the value for honor.honor_grade
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setHonorGrade(String honorGrade) {
        this.honorGrade = honorGrade == null ? null : honorGrade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.status
     *
     * @return the value of honor.status
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.status
     *
     * @param status the value for honor.status
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column honor.other1
     *
     * @return the value of honor.other1
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public String getOther1() {
        return other1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column honor.other1
     *
     * @param other1 the value for honor.other1
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table honor
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", honorId=").append(honorId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", honorCreateTime=").append(honorCreateTime);
        sb.append(", honorName=").append(honorName);
        sb.append(", honorGrade=").append(honorGrade);
        sb.append(", status=").append(status);
        sb.append(", other1=").append(other1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}