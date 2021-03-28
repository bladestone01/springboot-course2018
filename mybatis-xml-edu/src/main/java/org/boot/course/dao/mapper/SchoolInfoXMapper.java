package org.boot.course.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boot.course.dao.po.SimpleSchool;

public interface SchoolInfoXMapper {
     public List<SimpleSchool> selectSimple(@Param("name") String name,
    		 @Param("number") Integer number);
}
