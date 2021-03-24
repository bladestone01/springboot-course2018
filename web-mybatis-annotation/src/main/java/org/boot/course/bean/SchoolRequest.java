package org.boot.course.bean;

import java.util.Date;

import lombok.Data;

@Data
public class SchoolRequest {
	private Long id;
    private String name;
    private int valid;
    private int studentNum;
    
    private String createdBy;
    private String updatedBy;
    private Date updatedAt;
}
