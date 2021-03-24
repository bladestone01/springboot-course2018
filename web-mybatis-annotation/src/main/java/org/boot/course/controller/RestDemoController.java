package org.boot.course.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.boot.course.bean.ResultInfo;
import org.boot.course.bean.UserInfo;
import org.boot.course.helper.PropertyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Restful API.
 * 
 *
 */
@RestController
@Slf4j
public class RestDemoController {
    private Map<Integer, UserInfo> users = new HashMap<Integer, UserInfo>();
    
	@PostMapping("/users")
	public ResultInfo create(UserInfo userInfo) {
		log.info("Incoming Param, userInfo:{}", userInfo);
		
		Integer index = users.size();
		users.put(++index, userInfo);
		
		ResultInfo resultInfo = ResultInfo.success();
		resultInfo.setData(users);
		
		log.info("New Inserted User Id:{}, User Info:{}", index, userInfo);
		log.info("users:{}", users);
		
		return resultInfo;
	}
	
	@GetMapping("/users/{userid}")
	public ResultInfo getUser(@PathVariable("userid") Integer userId) {
		log.info("Incoming Param:{}", userId);
		ResultInfo resultInfo = ResultInfo.success();
		
		resultInfo.setData(users.get(userId));
		
		log.info("Get User:{}", users.get(userId));
		return resultInfo;
	}
	
	
	@GetMapping("/users")
	public ResultInfo getUsers() {
		log.info("Incoming Param");
		ResultInfo resultInfo = ResultInfo.success();
		
		resultInfo.setData(users);
		
		log.info("Get Users:{}", users);
		return resultInfo;
	}
	
	@DeleteMapping("/users/{userid}")
	public ResultInfo deleteUser(@PathVariable("userid") Integer userId) {
		log.info("Incoming Param:{}", userId);
		ResultInfo resultInfo = ResultInfo.success();
		
		UserInfo userInfo = users.remove(userId);
		resultInfo.setData(userInfo);
		
		log.info("Get User:{}", userInfo);
		return resultInfo;
	}
	
	@PutMapping("/users/{userid}")
	public ResultInfo updateUser(@PathVariable("userid") Integer userId, UserInfo userInfo) {
		log.info("Incoming Param,userId:{}, userInfo:{}", userId, userInfo);
		ResultInfo resultInfo = ResultInfo.success();
		
		if (users.containsKey(userId)) {
			log.info("user id {} exists", userId);
 			
			UserInfo srcUserInfo = users.get(userId);
 		    BeanUtils.copyProperties(userInfo, srcUserInfo, PropertyUtil.getNullPropertyNames(userInfo));
 			
			resultInfo.setData(srcUserInfo);
		}
		
		
		return resultInfo;
		
	}
}
