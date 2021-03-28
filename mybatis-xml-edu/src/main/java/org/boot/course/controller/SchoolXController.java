package org.boot.course.controller;

import java.util.List;

import org.boot.course.bean.ResultInfo;
import org.boot.course.bean.SimpleBean;
import org.boot.course.dao.mapper.SchoolInfoMapper;
import org.boot.course.dao.po.SimpleSchool;
import org.boot.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SchoolXController {

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private SchoolInfoMapper shoolInfoMapper;

	@GetMapping("/xschools")
	public List<SimpleSchool> getSimpleInfo(@RequestParam("name") String name, @RequestParam("num") Integer num) {
		List<SimpleSchool> simpleSchools = this.schoolService.getSimpleSchool(name, num);

		return simpleSchools;
	}

	@GetMapping("/xschools/{id}")
	public ResultInfo getSimple(@PathVariable("id") Long id, @RequestParam("name") String name) {
		// SchoolInfo schoolInfo = this.schoolService.getSimple(id);

		log.info("Id:{}, name:{}", id, name);

		ResultInfo resultInfo = ResultInfo.success();
		resultInfo.setData(id + "," + name);
		return resultInfo;
	}

	@PostMapping("/xschools")
	public ResultInfo createSimple(@RequestParam("name") String name, @RequestParam("id") Long id) {
		log.info("Id:{}, name:{}", id, name);

		ResultInfo resultInfo = ResultInfo.success();
		resultInfo.setData(id + "," + name);
		return resultInfo;
	}
	
	@PostMapping("/xschools/json")
	public ResultInfo createSimpleJson(@RequestBody SimpleBean simpleBean) {
		log.info("simple json:{}", simpleBean);

		ResultInfo resultInfo = ResultInfo.success();
		resultInfo.setData(simpleBean);
		return resultInfo;
	}
}
