package org.boot.course.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.boot.course.bean.SchoolBean;
import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.dao.entity.SchoolInfoExample;
import org.boot.course.dao.mapper.SchoolInfoMapper;
import org.boot.course.dao.mapper.SchoolInfoXMapper;
import org.boot.course.dao.po.SimpleSchool;
import org.boot.course.service.SchoolService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolInfoMapper schoolInfoMapper;
	
	@Autowired
	private SchoolInfoXMapper schoolInfoXMapper;

	@Override
	public List<SchoolBean> getSchools() {
		
		SchoolInfoExample exmaple = new SchoolInfoExample();
		List<SchoolInfo> schoolInfos = this.schoolInfoMapper.selectByExample(exmaple);

		log.info("School Info from DB:{}", schoolInfos);

		List<SchoolBean> beans = new ArrayList<SchoolBean>();

		for (SchoolInfo schoolInfo : schoolInfos) {
			SchoolBean schoolBean = new SchoolBean();

			BeanUtils.copyProperties(schoolInfo, schoolBean);
			schoolBean.setStudentNum(schoolInfo.getStudentNum());

			beans.add(schoolBean);
		}

		return beans;
	}

	@Override
	public List<SchoolBean> getSchoolsbyName(String schoolName) {
		
		log.info("School Name:{}", schoolName);
		SchoolInfoExample example = new SchoolInfoExample();
		SchoolInfoExample.Criteria criteria = example.createCriteria();
		
		criteria.andNameEqualTo(schoolName);
		criteria.andValidEqualTo(new Integer(1).shortValue());
		
		List<SchoolInfo> schoolInfos = this.schoolInfoMapper.selectByExample(example);

		log.info("School Info from DB:{}", schoolInfos);

		List<SchoolBean> beans = new ArrayList<SchoolBean>();

		for (SchoolInfo schoolInfo : schoolInfos) {
			SchoolBean schoolBean = new SchoolBean();

			BeanUtils.copyProperties(schoolInfo, schoolBean);
			schoolBean.setStudentNum(schoolInfo.getStudentNum());

			beans.add(schoolBean);
		}

		return beans;
 	}

	@Override
	public Long createSchool(SchoolBean schoolBean) {
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setName(schoolBean.getName());
		schoolInfo.setStudentNum(schoolBean.getStudentNum());
		
 		schoolInfo.setCreatedAt(new Date());
		schoolInfo.setCreatedBy("KKK");
		
		schoolInfo.setUpdatedAt(new Date());
		schoolInfo.setUpdatedBy("KKK Update");
		schoolInfo.setValid(Integer.valueOf(1).shortValue());
		
		int count = this.schoolInfoMapper.insert(schoolInfo);
		log.info("Inserted count:{}", count);
		
		return schoolInfo.getId();
	}

	@Override
	public SchoolBean updateSchool(SchoolBean schoolBean) {
		 
		SchoolInfoExample example = new SchoolInfoExample();
		SchoolInfoExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(schoolBean.getName());
		
//		List<SchoolInfo> schoolInfoBases = this.schoolInfoMapper.selectByExample(example);
//		SchoolInfo schoolInfo = schoolInfoBases.get(0);
//	
//		schoolInfo.setStudentNum(schoolBean.getStudentNum());
//		schoolInfo.setValid(schoolBean.getValid().shortValue());
		
//	    int count = this.schoolInfoMapper.updateByExample(schoolInfo, example);
		
		SchoolInfo schoolBeanOne = this.schoolInfoMapper.selectByPrimaryKey(schoolBean.getId());
		
 		schoolBeanOne.setName(schoolBean.getName());
		schoolBeanOne.setStudentNum(schoolBean.getStudentNum());
		schoolBeanOne.setValid(schoolBean.getValid().shortValue());
	    int count = this.schoolInfoMapper.updateByExample(schoolBeanOne, example);
	  
		
		return schoolBean;
	}

	@Override
	public void deleteByName(String schoolName) {
 		
		SchoolInfoExample example = new SchoolInfoExample();
		SchoolInfoExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(schoolName);
		 
		 log.info("delete the school info by name:{}", schoolName);
		 
		 this.schoolInfoMapper.deleteByExample(example);
 	}

	@Override
	public Long createSchoolOne(SchoolBean schoolBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SimpleSchool> getSimpleSchool(String name, Integer num) {
		List<SimpleSchool> simpleSchools = this.schoolInfoXMapper.selectSimple(name, num);
		 
		log.info("Simple School Search:{}", simpleSchools.size());
		return simpleSchools;
	}

	@Override
	public SchoolInfo getSimple(Long id) {
		return this.schoolInfoMapper.selectByPrimaryKey(id);
	}

}
