package org.boot.course.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class SchoolInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.id
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.name
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.student_num
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private Integer studentNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.created_at
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.created_by
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private String createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.updated_by
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private String updatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.updated_at
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private Date updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.valid
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private Short valid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table school_info
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.id
     *
     * @return the value of school_info.id
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.id
     *
     * @param id the value for school_info.id
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.name
     *
     * @return the value of school_info.name
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.name
     *
     * @param name the value for school_info.name
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.student_num
     *
     * @return the value of school_info.student_num
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public Integer getStudentNum() {
        return studentNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.student_num
     *
     * @param studentNum the value for school_info.student_num
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.created_at
     *
     * @return the value of school_info.created_at
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.created_at
     *
     * @param createdAt the value for school_info.created_at
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.created_by
     *
     * @return the value of school_info.created_by
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.created_by
     *
     * @param createdBy the value for school_info.created_by
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.updated_by
     *
     * @return the value of school_info.updated_by
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.updated_by
     *
     * @param updatedBy the value for school_info.updated_by
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.updated_at
     *
     * @return the value of school_info.updated_at
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.updated_at
     *
     * @param updatedAt the value for school_info.updated_at
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.valid
     *
     * @return the value of school_info.valid
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public Short getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.valid
     *
     * @param valid the value for school_info.valid
     *
     * @mbg.generated Sun Mar 21 11:54:14 CST 2021
     */
    public void setValid(Short valid) {
        this.valid = valid;
    }
}