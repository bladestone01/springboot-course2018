package org.boot.course.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.dao.entity.SchoolInfoEnum;
import org.boot.course.dao.entity.ValidEnum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 完全基于注解实现增删改查功能.
 * 
 * @author chenjunfeng
 *
 */
@Mapper
public interface SchoolInfoMapper extends BaseMapper<SchoolInfo> {
	@Results(id="schoolMap", value={
			@Result(property="createdAt", column="created_at"),
			@Result(property="createdBy", column="created_by")
		})
	@Select("select id, name, student_num,  valid, created_at, created_by, updated_at, updated_by from school_info")
    public List<SchoolInfo> getSchools();
	
	@Results(id="schoolMap2", value={
			@Result(property="createdAt", column="created_at"),
			@Result(property="createdBy", column="created_by"),
			@Result(property="valid", column="valid", javaType=ValidEnum.class)
		})
	@Select("select id, name, student_num,  valid, created_at, created_by, updated_at, updated_by from school_info")
    public List<SchoolInfoEnum> getSchoolEnums();
	
	//展示结果Result注解
	//${id}类型映射
	@ResultMap("schoolMap")
	@Select("select id, name, student_num,  valid, created_at, created_by, updated_at, updated_by from school_info where id = #{id}")
	public SchoolInfo getSchoolById(Long id);
	
	@Select("select id, name, student_num,  valid, created_at, created_by, updated_at, updated_by from school_info where where name = #{name}")
	@ResultMap("schoolMap")
	public List<SchoolInfo> getSchoolByName(String name);
	
	
	@Insert("insert into school_info(name, student_num, valid, created_by, updated_by, updated_at) "
			+ "values(#{name}, #{studentNum}, #{valid},#{createdBy}, #{updatedBy}, #{updatedAt})")
	//返回PO的id属性
	//@Options(useGeneratedKeys=true, keyProperty="id"), 与@Options等同
	@SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
	public Long insertOne(SchoolInfo schoolInfo);
	
	//自增主键
	@Options(useGeneratedKeys=true, keyProperty="id")
	@Insert("insert into school_info(name, student_num, valid, created_by, updated_by, updated_at) "
			+ "values(#{name}, #{studentNum}, #{valid},#{createdBy}, #{updatedBy}, #{updatedAt})")
    @SelectKey(statement = "select last_insert_id()", before = false, resultType = Long.class, keyProperty = "id")
	public Long insert(String name, int studentNum, int valid, String createdBy, String updatedBy, Date updatedAt);
	
	@Update("update school_info set student_num=#{studentNum}, valid=${valid} where name=#{schoolName}")
	public void updateSchool(String schoolName, int studentNum, int valid);
	
	
	/**
	 * 重载方法不支持.
	 * 
	 * @param id
	 * @param schoolName
	 * @param studentNum
	 * @param valid
	 */
	@Update("update school_info set name=#{schoolName}, student_num=#{studentNum}, valid=#{valid} where id = #{id}")
	public void updateSchool2(Long id, String schoolName, int studentNum, int valid);
	
	
	@Delete("delete from school_info where name = #{schoolName}")
	public void deleteByName(String schoolName);
}
