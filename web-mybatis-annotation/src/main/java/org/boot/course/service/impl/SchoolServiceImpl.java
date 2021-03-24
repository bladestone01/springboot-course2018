package org.boot.course.service.impl;

import java.util.Date;
import java.util.List;

import org.boot.course.bean.PageResult;
import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.dao.mapper.SchoolInfoMapper;
import org.boot.course.helper.PageUtils;
import org.boot.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;
    
	//@SuppressWarnings("unchecked")
	@Override
	public PageResult getSchools(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<SchoolInfo> pageInfos = new PageInfo<>(this.schoolInfoMapper.getSchools());
		
		
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public void deleteByName(String schoolName) {
		this.schoolInfoMapper.deleteById(schoolName);
	}

	@Override
	public void updateSchool(String name, int studentNum, int valid) {
		this.schoolInfoMapper.updateSchool(name, studentNum, valid);
	}

	@Override
	public void updateSchool(Long id, String name, int studentNum, int valid) {
        this.schoolInfoMapper.updateSchool2(id, name, studentNum, valid);
	}

	@Override
	public Long createOne(String name, int studentNum, int valid, String createdBy, String updatedBy, Date updatedAt) {
        return this.schoolInfoMapper.insert(name, studentNum, valid, createdBy, updatedBy, updatedAt);		
	}

	@Override
	public SchoolInfo getById(Long id) {
	    return this.schoolInfoMapper.getSchoolById(id);
	}

	@Override
	public List<SchoolInfo> getByName(String schoolName) {
		return this.schoolInfoMapper.getSchoolByName(schoolName);
	}

	@Override
	public void deleteOne(Long id) {
        this.schoolInfoMapper.deleteById(id);		
	}

	@Override
	public Long createOne(SchoolInfo schoolInfo) {
		 this.schoolInfoMapper.insertOne(schoolInfo);
		 
		 log.info("school Info new:{}", schoolInfo);
		 
		 return schoolInfo.getId();
	}
}
