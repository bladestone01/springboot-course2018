package org.boot.course.service;

import java.util.Date;
import java.util.List;

import org.boot.course.bean.PageResult;
import org.boot.course.dao.entity.SchoolInfo;

public interface SchoolService {
	
	//基于分页的数据查询
    public PageResult<SchoolInfo> getSchools(int pageNum, int pageSize);
    
    public SchoolInfo getById(Long id);
    
    public List<SchoolInfo> getByName(String schoolName);
    
    public void deleteByName(String schoolName);
    
    public void deleteOne(Long id);

    
    public void updateSchool(String name, int studentNum, int valid);
    
    public void updateSchool(Long id, String name, int studentNum, int valid);
    
    
    /**
     * 创建学校.
     * 
     * @param name
     * @param studentNum
     * @param valid
     */
    public Long createOne(String name, int studentNum, int valid, String createdBy, String updatedBy, Date updatedAt);
    public Long createOne(SchoolInfo schoolInfo);
}
