package org.boot.course.controller;

import java.util.Date;
import java.util.List;

import org.boot.course.bean.PageResult;
import org.boot.course.bean.SchoolRequest;
import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SchoolController {
	@Autowired
	private SchoolService schoolService;

	@GetMapping("/schools")
	public PageResult getSchools(@RequestParam(value="pageNum", required=false, defaultValue="0") int pageNum,
			@RequestParam(value="pageSize", required=false, defaultValue="5") int pageSize) {
		
		return schoolService.getSchools(pageNum, pageSize);
	}
	
	@GetMapping("/schools/name")
	public List<SchoolInfo> getSchools(@RequestParam("name") String name) {
		return this.schoolService.getByName(name);
	}
	
	@GetMapping("/schools/id/{id}")
	public SchoolInfo getSchools(@PathVariable("id") Long id) {
		return this.schoolService.getById(id);
	}
	
	@PostMapping("/schools")
	public SchoolInfo createOne(SchoolRequest school) {
		Long schoolId = this.schoolService.createOne(school.getName(), school.getStudentNum(), school.getValid(), "jackie", "jackie", new Date());
		
		SchoolInfo schoolInfo = this.schoolService.getById(schoolId);
		
		log.info("New inserted School:{}", schoolInfo);
		
		return schoolInfo;
	}
	
	@PostMapping("/schools/object")
	public SchoolInfo createByObject(SchoolRequest school) {
		
		SchoolInfo schoolInfo = SchoolInfo.builder().createdBy(school.getCreatedBy())
				.updatedAt(new Date()).updatedBy(school.getUpdatedBy()).name(school.getName())
				.studentNum(school.getStudentNum())
				.valid(school.getValid()).build();
		
		Long schoolId = this.schoolService.createOne(schoolInfo);
		
		SchoolInfo newSchoolINfo = this.schoolService.getById(schoolId);
		
		log.info("New inserted School:{}", schoolInfo);
		
		return newSchoolINfo;
	}
	
	@PutMapping("/schools/{id}")
	public SchoolInfo updateOne(@PathVariable("id") Long id, SchoolRequest school) {
		this.schoolService.updateSchool(id, school.getName(), school.getStudentNum(), school.getValid());
		
		return this.schoolService.getById(id);
	}
	
	@DeleteMapping("/schools/{id}")
	public PageResult deleteOne(@PathVariable("id") Long id) {
		this.schoolService.deleteOne(id);
		
		return this.schoolService.getSchools(0, 5);
	}
	
	
	@DeleteMapping("/schools/name")
	public PageResult deleteOne(@RequestParam("name") String name) {
		this.schoolService.deleteByName(name);
		
		return this.schoolService.getSchools(0, 5);
	}
	
}
