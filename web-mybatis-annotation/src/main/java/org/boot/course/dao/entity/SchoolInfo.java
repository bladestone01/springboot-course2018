package org.boot.course.dao.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolInfo {
    
	private Long id;
	private String name;
	private Integer studentNum;
	private int valid;
	
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;
}
