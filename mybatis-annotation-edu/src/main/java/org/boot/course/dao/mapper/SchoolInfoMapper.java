package org.boot.course.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.boot.course.dao.entity.SchoolInfo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface SchoolInfoMapper extends BaseMapper<SchoolInfo>{
	@Results(id="schoolMap", value= {
			@Result(property="num", column="student_num")
	})
	@Select("select * from school_info ")
	public List<SchoolInfo> getSchools();
	
	// 将结果字段进行映射
	@ResultMap("schoolMap")
	@Select("select id, name, student_num,  valid, created_at, created_by, updated_at, updated_by from school_info where name = #{name}")
	public List<SchoolInfo> getSchoolsByName(String name);

	
	@ResultMap("schoolMap")
	@Update("update school_info set student_num=#{studentNum}, valid=#{valid} where name=#{schoolName}")
	public void updateSchoolInfo(String schoolName, int studentNum, int valid);
	
	
	@Delete("delete from school_info where name = #{schoolName}")
	public void deleteByName(String schoolName);
	
	
	@Insert("insert into school_info(name, student_num, valid, created_by, updated_by, updated_at) "
			+ " values(#{name}, #{num}, #{valid},#{createdBy}, #{updatedBy}, #{updatedAt}))")
	@SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
	public Long insertOne(SchoolInfo schoolInfo);
	
}
