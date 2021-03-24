package org.boot.course.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.boot.course.bean.SchoolBean;
import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.dao.mapper.SchoolInfoMapper;
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

	@Override
	public List<SchoolBean> getSchools() {
		List<SchoolInfo> schoolInfos = this.schoolInfoMapper.getSchools();

		log.info("School Info from DB:{}", schoolInfos);

		List<SchoolBean> beans = new ArrayList<SchoolBean>();

		for (SchoolInfo schoolInfo : schoolInfos) {
			SchoolBean schoolBean = new SchoolBean();

			BeanUtils.copyProperties(schoolInfo, schoolBean);
			schoolBean.setStudentNum(schoolInfo.getNum());

			beans.add(schoolBean);
		}

		return beans;
	}

	@Override
	public List<SchoolBean> getSchoolsbyName(String schoolName) {
		
		log.info("School Name:{}", schoolName);
		List<SchoolInfo> schoolInfos = this.schoolInfoMapper.getSchoolsByName(schoolName);

		log.info("School Info from DB:{}", schoolInfos);

		List<SchoolBean> beans = new ArrayList<SchoolBean>();

		for (SchoolInfo schoolInfo : schoolInfos) {
			SchoolBean schoolBean = new SchoolBean();

			BeanUtils.copyProperties(schoolInfo, schoolBean);
			schoolBean.setStudentNum(schoolInfo.getNum());

			beans.add(schoolBean);
		}

		return beans;
	}

	@Override
	public Long createSchool(SchoolBean schoolBean) {
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setName(schoolBean.getName());
		schoolInfo.setNum(schoolBean.getStudentNum());
		
		schoolInfo.setCreatedAtTime(new Date());
		schoolInfo.setCreatedBy("KKK");
		
		schoolInfo.setUpdatedAt(new Date());
		schoolInfo.setUpdatedBy("KKK Update");
		
		Long id = this.schoolInfoMapper.insertOne(schoolInfo);
		
		return schoolInfo.getId();
	}

	@Override
	public SchoolBean updateSchool(SchoolBean schoolBean) {
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setName(schoolBean.getName());
		schoolInfo.setNum(schoolBean.getStudentNum());
		schoolInfo.setValid(schoolBean.getValid());
		
	    this.schoolInfoMapper.updateSchoolInfo(schoolBean.getName(), schoolBean.getStudentNum(), schoolBean.getValid());
		
		SchoolBean schoolBeanOne = new SchoolBean();
		
		schoolBeanOne.setId(schoolInfo.getId());
		schoolBeanOne.setName(schoolBean.getName());
		schoolBeanOne.setStudentNum(schoolInfo.getNum());
		schoolBeanOne.setValid(schoolInfo.getValid());
		
		return schoolBeanOne;
	}

	@Override
	public void deleteByName(String schoolName) {
		 this.schoolInfoMapper.deleteByName(schoolName);
		 
		 log.info("delete the school info by name:{}", schoolName);
		 
 	}

	@Override
	public Long createSchoolOne(SchoolBean schoolBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
