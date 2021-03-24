package org.boot.course.controller;

import java.util.List;

import org.boot.course.bean.ResultInfo;
import org.boot.course.bean.SchoolBean;
import org.boot.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
	
	@GetMapping("/schools")
	public List<SchoolBean> getSchools() {
		List<SchoolBean> beans = this.schoolService.getSchools();
		
		log.info("school beans:{}", beans);
		
		return beans;
	}
	
	@GetMapping("/schools/type1")
	public List<SchoolBean> getSchoolsByName(@RequestParam("schoolName") String schoolName) {
		
		log.info("Request School Name:{}", schoolName);
		List<SchoolBean> beans = this.schoolService.getSchoolsbyName(schoolName);
		
		log.info("query by name:{}", beans);
		
		return beans;
	}
	
	@PostMapping("/schools")
	public ResultInfo createSchool(@RequestParam("name") String schoolName, @RequestParam("num") Integer studentNum) {
		
		SchoolBean schoolBean = new SchoolBean();
		schoolBean.setStudentNum(studentNum);
		schoolBean.setName(schoolName);
		
		Long id = this.schoolService.createSchool(schoolBean);
		
		
		ResultInfo resultInfo = ResultInfo.success();
		resultInfo.setData(id);
		
		return resultInfo;
	}
	
	@PutMapping("/schools")
	public ResultInfo updateSchool(@RequestParam("name") String schoolName, @RequestParam("num") Integer studentNum, 
			@RequestParam("valid") Integer valid) {
		SchoolBean schoolBean = new SchoolBean();
		schoolBean.setStudentNum(studentNum);
		schoolBean.setName(schoolName);
		schoolBean.setValid(valid);
		
		
		SchoolBean updatedSchoolBean = this.schoolService.updateSchool(schoolBean);
		
		
		ResultInfo resultInfo = ResultInfo.success();
		resultInfo.setData(updatedSchoolBean);
		
		return resultInfo;
	}
	
	@DeleteMapping("/schools")
	public ResultInfo deleteSchool(@RequestParam("name") String schoolName) {
		this.schoolService.deleteByName(schoolName);
		return ResultInfo.success();
	}
}
