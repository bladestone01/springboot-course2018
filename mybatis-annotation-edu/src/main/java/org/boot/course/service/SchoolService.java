package org.boot.course.service;

import java.util.List;

import org.boot.course.bean.SchoolBean;

public interface SchoolService {
    public List<SchoolBean> getSchools();
    
    public List<SchoolBean> getSchoolsbyName(String schoolName);
    
    
    public Long createSchool(SchoolBean schoolBean);
    
    public Long createSchoolOne(SchoolBean schoolBean);

    
    
    public SchoolBean updateSchool(SchoolBean schoolBean);
    
    public void deleteByName(String schoolName);
}
