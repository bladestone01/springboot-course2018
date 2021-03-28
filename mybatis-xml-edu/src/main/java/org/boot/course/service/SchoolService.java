package org.boot.course.service;

import java.util.List;

import org.boot.course.bean.SchoolBean;
import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.dao.po.SimpleSchool;

public interface SchoolService {
    public List<SchoolBean> getSchools();
    
    public List<SchoolBean> getSchoolsbyName(String schoolName);
    
    
    public Long createSchool(SchoolBean schoolBean);
    
    public Long createSchoolOne(SchoolBean schoolBean);

    
    
    public SchoolBean updateSchool(SchoolBean schoolBean);
    
    public void deleteByName(String schoolName);
    
    public List<SimpleSchool> getSimpleSchool(String name, Integer num);
    
    public SchoolInfo getSimple(Long id);
    
}
