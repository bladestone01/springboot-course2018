package org.boot.course.dao.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SchoolInfo {
    private Long id;
    private String name;
    private Integer num;
    
    private int valid;
    
    //createdAt --> createdAtTime
    private Date createdAtTime;
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
}
