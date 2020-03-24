package com.aistar.mapper;

import com.aistar.pojo.CompanyReceiveResumeRecord;
import com.aistar.pojo.CompanyReceiveResumeRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyReceiveResumeRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int countByExample(CompanyReceiveResumeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int deleteByExample(CompanyReceiveResumeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int deleteByPrimaryKey(Integer companyReceiveResumeRecordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int insert(CompanyReceiveResumeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int insertSelective(CompanyReceiveResumeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    List<CompanyReceiveResumeRecord> selectByExample(CompanyReceiveResumeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    CompanyReceiveResumeRecord selectByPrimaryKey(Integer companyReceiveResumeRecordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int updateByExampleSelective(@Param("record") CompanyReceiveResumeRecord record, @Param("example") CompanyReceiveResumeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int updateByExample(@Param("record") CompanyReceiveResumeRecord record, @Param("example") CompanyReceiveResumeRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int updateByPrimaryKeySelective(CompanyReceiveResumeRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_receive_resume_record
     *
     * @mbggenerated Thu Feb 13 09:39:31 CST 2020
     */
    int updateByPrimaryKey(CompanyReceiveResumeRecord record);
}